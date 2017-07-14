package g.star.iota.milk.ui.www94taotucom.www;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class WWW94TAOTUCOMFragment extends ScrollImageFragment<WWW94TAOTUCOMPresenter, WWW94TAOTUCOMAdapter> {


    public static WWW94TAOTUCOMFragment newInstance(String url) {
        WWW94TAOTUCOMFragment fragment = new WWW94TAOTUCOMFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WWW94TAOTUCOMPresenter getPresenter() {
        return new WWW94TAOTUCOMPresenter(this);
    }

    @Override
    protected WWW94TAOTUCOMAdapter getAdapter() {
        return new WWW94TAOTUCOMAdapter();
    }
}
