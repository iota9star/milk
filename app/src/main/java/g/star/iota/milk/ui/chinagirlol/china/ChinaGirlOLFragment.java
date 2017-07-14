package g.star.iota.milk.ui.chinagirlol.china;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class ChinaGirlOLFragment extends ScrollImageFragment<ChinaGirlOLPresenter, ChinaGirlOLAdapter> {


    public static ChinaGirlOLFragment newInstance(String url) {
        ChinaGirlOLFragment fragment = new ChinaGirlOLFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ChinaGirlOLPresenter getPresenter() {
        return new ChinaGirlOLPresenter(this);
    }

    @Override
    protected ChinaGirlOLAdapter getAdapter() {
        return new ChinaGirlOLAdapter();
    }
}
