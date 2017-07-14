package g.star.iota.milk.ui.gacha;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class GachaPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("日榜");
        titles.add("周榜");
        titles.add("月榜");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GachaFragment.newInstance(Contracts.Url.GACHA_DAY));
        fragments.add(GachaFragment.newInstance(Contracts.Url.GACHA_WEEK));
        fragments.add(GachaFragment.newInstance(Contracts.Url.GACHA_MONTH));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
