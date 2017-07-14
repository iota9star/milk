package g.star.iota.milk.ui.menu;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import butterknife.BindView;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.base.SGSpacingItemDecoration;
import g.star.iota.milk.util.ConfigUtils;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

public abstract class MenuFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private SGSpacingItemDecoration mItemDecoration;
    private StaggeredGridLayoutManager mLayoutManager;

    private MenuAdapter.OnMenuItemClickListener mOnMenuItemClickListener = new MenuAdapter.OnMenuItemClickListener() {
        @Override
        public void onClick(MenuBean menu) {
            handleOnMenuItemOnClick(menu);
        }
    };

    protected abstract void handleOnMenuItemOnClick(MenuBean menu);

    private int mSpanCount;

    @Override
    protected void init(Bundle savedInstanceState) {
        init();
        initRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler_view;
    }

    private void initRecyclerView() {
        mRecyclerView.setItemAnimator(new LandingAnimator());
        mLayoutManager = new StaggeredGridLayoutManager(mSpanCount, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mItemDecoration = new SGSpacingItemDecoration(mSpanCount, mContext.getResources().getDimensionPixelSize(R.dimen.v4dp));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mItemDecoration);
        MenuAdapter adapter = new MenuAdapter();
        adapter.add(getMenuList());
        adapter.setOnMenuItemClickListener(mOnMenuItemClickListener);
        mRecyclerView.setAdapter(adapter);
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
        mSpanCount = ConfigUtils.getCurrentSpanCount(aContext);
    }

    protected abstract List<MenuBean> getMenuList();
}