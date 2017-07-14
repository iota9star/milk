package g.star.iota.milk.ui.moe005tv.moe;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MOE005TVFragment extends ScrollImageFragment<MOE005TVPresenter, MOE005TVAdapter> {


    public static MOE005TVFragment newInstance(String url) {
        MOE005TVFragment fragment = new MOE005TVFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MOE005TVPresenter getPresenter() {
        return new MOE005TVPresenter(this);
    }

    @Override
    protected MOE005TVAdapter getAdapter() {
        return new MOE005TVAdapter();
    }
}
