package g.star.iota.milk.ui.chinagirlol.china;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class ChinaGirlOLPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("美女玩家");
        titles.add("美图贴贴");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ChinaGirlOLFragment.newInstance(Contracts.Url.CHINAGIRLOL_MN));
        fragments.add(ChinaGirlOLFragment.newInstance(Contracts.Url.CHINAGIRLOL_MT));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
