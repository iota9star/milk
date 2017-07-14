package g.star.iota.milk.ui.www192ttcom.www;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class WWW192TTCOMPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("高清");
        titles.add("美图");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(WWW192TTCOMFragment.newInstance(Contracts.Url.WWW192TTCOM_GQ));
        fragments.add(WWW192TTCOMFragment.newInstance(Contracts.Url.WWW192TTCOM_MT));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
