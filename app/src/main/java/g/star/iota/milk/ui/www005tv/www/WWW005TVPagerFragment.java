package g.star.iota.milk.ui.www005tv.www;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class WWW005TVPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("二次元美图");
        titles.add("每周P站本子图");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(WWW005TVFragment.newInstance(Contracts.Url.WWW_005_TV_ACG));
        fragments.add(WWW005TVFragment.newInstance(Contracts.Url.WWW_005_TV_P));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
