package g.star.iota.milk.ui.www192ttcom.tt;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class TTFragment extends ScrollImageFragment<TTPresenter, TTAdapter> {

    public static TTFragment newInstance(String url) {
        TTFragment fragment = new TTFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TTPresenter getPresenter() {
        return new TTPresenter(this);
    }

    @Override
    protected TTAdapter getAdapter() {
        return new TTAdapter();
    }

}
