package g.star.iota.milk.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.List;

import butterknife.BindView;
import g.star.iota.milk.R;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.SnackbarUtils;
import jp.wasabeef.recyclerview.animators.LandingAnimator;


public abstract class ScrollImageFragment<P extends PVContract.Presenter, A extends BaseAdapter> extends BaseFragment implements PVContract.View {

    @BindView(R.id.twinkling_refresh_layout)
    TwinklingRefreshLayout mTwinklingRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private boolean isRunning;
    private boolean isLoadMore;
    private int currentPage;

    private int mInitialPage;

    private A mAdapter;

    private String mBaseUrl;
    private P mPresenter;
    private SGSpacingItemDecoration mItemDecoration;
    private StaggeredGridLayoutManager mLayoutManager;

    private int mSpanCount;
    private String mSuffix;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mBaseUrl = bundle.getString("base_url");
        mInitialPage = bundle.getInt("initial_page", 1);
        mSuffix = bundle.getString("page_suffix", "");
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        init();
        initRecyclerView();
        initRefreshLayout();
    }

    protected abstract P getPresenter();

    protected abstract A getAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler_view_with_refresh_layout;
    }

    private void initRecyclerView() {
        mRecyclerView.setItemAnimator(new LandingAnimator());
        mLayoutManager = new StaggeredGridLayoutManager(mSpanCount, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mItemDecoration = new SGSpacingItemDecoration(mSpanCount, mContext.getResources().getDimensionPixelSize(R.dimen.v4dp));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mItemDecoration);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void scrollToTop() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void changeRecyclerViewSpanCount() {
        int spanCount = mLayoutManager.getSpanCount();
        if (spanCount >= ConfigUtils.getSpanCountConfig(aContext)) {
            spanCount = 1;
        } else {
            spanCount++;
        }
        ConfigUtils.saveCurrentSpanCount(aContext, spanCount);
        mLayoutManager.setSpanCount(spanCount);
        mItemDecoration.setSpanCount(spanCount);
    }

    private void init() {
        isLoadMore = false;
        isRunning = false;
        currentPage = mInitialPage;
        mSpanCount = ConfigUtils.getCurrentSpanCount(aContext);
        mPresenter = getPresenter();
        mAdapter = getAdapter();
    }

    private void initRefreshLayout() {
        ProgressLayout header = new ProgressLayout(mContext);
        header.setColorSchemeResources(
                R.color.ThemeRed,
                R.color.ThemePink,
                R.color.ThemePurple,
                R.color.ThemeDeepPurple,
                R.color.ThemeIndigo,
                R.color.ThemeBlue,
                R.color.ThemeLightBlue,
                R.color.ThemeCyan,
                R.color.ThemeTeal,
                R.color.ThemeGreen,
                R.color.ThemeLightGreen,
                R.color.ThemeLime,
                R.color.ThemeYellow,
                R.color.ThemeAmber,
                R.color.ThemeOrange,
                R.color.ThemeDeepOrange,
                R.color.ThemeBrown,
                R.color.ThemeGrey,
                R.color.ThemeBlueGrey,
                R.color.ThemeBiliBili,
                R.color.ThemeBlack,
                R.color.ThemeDarkBlack
        );
        mTwinklingRefreshLayout.setFloatRefresh(true);
        mTwinklingRefreshLayout.setOverScrollRefreshShow(false);
        mTwinklingRefreshLayout.setMaxHeadHeight(mContext.getResources().getDimension(R.dimen.v48dp));
        mTwinklingRefreshLayout.setOverScrollHeight(mContext.getResources().getDimension(R.dimen.v42dp));
        mTwinklingRefreshLayout.setHeaderView(header);
        mTwinklingRefreshLayout.setHeaderHeight(mContext.getResources().getDimension(R.dimen.v36dp));
        mTwinklingRefreshLayout.startRefresh();
        mTwinklingRefreshLayout.setAutoLoadMore(true);
        mTwinklingRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                if (isRunning) return;
                isRunning = true;
                isLoadMore = false;
                if (mAdapter != null) {
                    mAdapter.clear();
                }
                if (mPresenter != null) {
                    mPresenter.get(mBaseUrl + mInitialPage + mSuffix);
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                if (isRunning) return;
                isRunning = true;
                isLoadMore = true;
                if (mPresenter != null) {
                    mPresenter.get(mBaseUrl + currentPage + mSuffix);
                }
            }
        });
    }


    @Override
    public void success(Object result) {
        List beans = (List) result;
        if (isLoadMore) {
            currentPage++;
        } else {
            currentPage = mInitialPage + 1;
        }
        if (beans == null || beans.size() == 0) {
            SnackbarUtils.create(mContext, "没有更多记录了");
        } else {
            mAdapter.add(beans);
        }
        endTask();
    }


    @Override
    public void error(String error) {
        endTask();
        SnackbarUtils.create(mContext, error);
    }

    private void endTask() {
        isRunning = false;
        if (isLoadMore) {
            mTwinklingRefreshLayout.finishLoadmore();
        } else {
            mTwinklingRefreshLayout.finishRefreshing();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unsubscribe();
        }
    }
}