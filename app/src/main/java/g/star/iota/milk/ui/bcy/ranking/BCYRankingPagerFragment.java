package g.star.iota.milk.ui.bcy.ranking;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class BCYRankingPagerFragment extends PagerFragment {

    public static final int ILLUST = 1;
    public static final int COS = 2;

    public static BCYRankingPagerFragment newInstance(int type) {
        BCYRankingPagerFragment fragment = new BCYRankingPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("本周");
        titles.add("今日");
        titles.add("原创");
        titles.add("新人");
        List<Fragment> fragments = new ArrayList<>();
        int type = getArguments().getInt("type");
        if (type == ILLUST) {
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_ILLUST_RANK_WEEK));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_ILLUST_RANK_TODAY));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_ILLUST_RANK_ART_WORK));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_ILLUST_RANK_NEW_PEOPLE));
        } else if (type == COS) {
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_COS_RANK_WEEK));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_COS_RANK_TODAY));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_COS_RANK_ART_WORK));
            fragments.add(BCYRankingFragment.newInstance(Contracts.Url.BCY_COS_RANK_NEW_PEOPLE));
        } else {
            fragments.add(null);
            fragments.add(null);
            fragments.add(null);
            fragments.add(null);
        }
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
