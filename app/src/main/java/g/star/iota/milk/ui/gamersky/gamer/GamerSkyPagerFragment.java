package g.star.iota.milk.ui.gamersky.gamer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class GamerSkyPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("最新壁纸");
        titles.add("电脑壁纸");
        titles.add("手机壁纸");
        titles.add("动漫美图");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GamerSkyFragment.newInstance(Contracts.Url.ACG_GAMERSKY_ZX));
        fragments.add(GamerSkyFragment.newInstance(Contracts.Url.ACG_GAMERSKY_PC));
        fragments.add(GamerSkyFragment.newInstance(Contracts.Url.ACG_GAMERSKY_SJ));
        fragments.add(GamerSkyFragment.newInstance(Contracts.Url.ACG_GAMERSKY_MT));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
