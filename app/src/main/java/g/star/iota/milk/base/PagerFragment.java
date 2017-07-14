package g.star.iota.milk.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import g.star.iota.milk.R;


public abstract class PagerFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private TabLayout mTabLayout;

    @Override
    protected void init(Bundle savedInstanceState) {
        mTabLayout = getActivity().findViewById(R.id.tab_layout);
        mTabLayout.setTabMode(setTabMode());
        TitlePagerAdapter mAdapter = getPagerAdapter();
        mViewPager.setOffscreenPageLimit(mAdapter.getCount());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setVisibility(View.VISIBLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    protected abstract TitlePagerAdapter getPagerAdapter();

    protected abstract int setTabMode();


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_view_pager;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTabLayout != null) {
            mTabLayout.removeAllTabs();
            mTabLayout.setVisibility(View.GONE);
        }
    }
}
