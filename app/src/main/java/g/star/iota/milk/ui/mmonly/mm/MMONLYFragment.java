package g.star.iota.milk.ui.mmonly.mm;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MMONLYFragment extends ScrollImageFragment<MMONLYPresenter, MMONLYAdapter> {


    public static MMONLYFragment newInstance(String url) {
        MMONLYFragment fragment = new MMONLYFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MMONLYPresenter getPresenter() {
        return new MMONLYPresenter(this);
    }

    @Override
    protected MMONLYAdapter getAdapter() {
        return new MMONLYAdapter();
    }
}
