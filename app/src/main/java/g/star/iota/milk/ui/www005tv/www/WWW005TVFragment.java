package g.star.iota.milk.ui.www005tv.www;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class WWW005TVFragment extends ScrollImageFragment<WWW005TVPresenter, WWW005TVAdapter> {


    public static WWW005TVFragment newInstance(String url) {
        WWW005TVFragment fragment = new WWW005TVFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WWW005TVPresenter getPresenter() {
        return new WWW005TVPresenter(this);
    }

    @Override
    protected WWW005TVAdapter getAdapter() {
        return new WWW005TVAdapter();
    }
}
