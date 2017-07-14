package g.star.iota.milk.ui.cosplayla.cosplay;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class CosplayLaFragment extends ScrollImageFragment<CosplayLaPresenter, CosplayLaAdapter> {


    public static CosplayLaFragment newInstance(String url) {
        CosplayLaFragment fragment = new CosplayLaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected CosplayLaPresenter getPresenter() {
        return new CosplayLaPresenter(this);
    }

    @Override
    protected CosplayLaAdapter getAdapter() {
        return new CosplayLaAdapter();
    }
}
