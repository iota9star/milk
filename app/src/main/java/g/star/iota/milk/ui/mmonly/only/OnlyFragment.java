package g.star.iota.milk.ui.mmonly.only;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class OnlyFragment extends ScrollImageFragment<OnlyPresenter, OnlyAdapter> {

    public static OnlyFragment newInstance(String url) {
        OnlyFragment fragment = new OnlyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected OnlyPresenter getPresenter() {
        return new OnlyPresenter(this);
    }

    @Override
    protected OnlyAdapter getAdapter() {
        return new OnlyAdapter();
    }

}
