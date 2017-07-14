package g.star.iota.milk.ui.moe005tv.moe;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;
import g.star.iota.milk.util.SnackbarUtils;


public class MOE005TVPagerFragment extends PagerFragment {

    public static final int ACG = 1;
    public static final int COS = 2;

    public static MOE005TVPagerFragment newInstance(int type) {
        MOE005TVPagerFragment fragment = new MOE005TVPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        int type = getArguments().getInt("type");
        if (type == ACG) {
            titles.add("萌图");
            titles.add("电脑壁纸");
            titles.add("手机壁纸");
            fragments.add(MOE005TVFragment.newInstance(Contracts.Url.MOE005TV_MT));
            fragments.add(MOE005TVFragment.newInstance(Contracts.Url.MOE005TV_DNBZ));
            fragments.add(MOE005TVFragment.newInstance(Contracts.Url.MOE005TV_SJBZ));
        } else if (type == COS) {
            titles.add("COSER介绍");
            titles.add("写真图集");
            fragments.add(MOE005TVFragment.newInstance(Contracts.Url.MOE005TV_COSER));
            fragments.add(MOE005TVFragment.newInstance(Contracts.Url.MOE005TV_COS));
        } else {
            SnackbarUtils.create(mContext, "获取数据错误，请稍候重试");
        }

        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
