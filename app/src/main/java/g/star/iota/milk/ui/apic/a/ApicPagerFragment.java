package g.star.iota.milk.ui.apic.a;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class ApicPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("A区");
        titles.add("动漫区");
        titles.add("制服控");
        titles.add("Hentai");
        titles.add("御三家");
        titles.add("杂图集");
        titles.add("福利包");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_ALL));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_ANIME));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_ZHIFU));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_HENTAI));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_YUSANJIA));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_ZATUJI));
        fragments.add(ApicFragment.newInstance(Contracts.Url.APIC_FULI));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }
}
