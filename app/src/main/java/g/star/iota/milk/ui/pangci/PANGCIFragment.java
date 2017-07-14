package g.star.iota.milk.ui.pangci;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class PANGCIFragment extends ScrollImageFragment<PANGCIPresenter, PANGCIAdapter> {


    public static PANGCIFragment newInstance(String url) {
        PANGCIFragment fragment = new PANGCIFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected PANGCIPresenter getPresenter() {
        return new PANGCIPresenter(this);
    }

    @Override
    protected PANGCIAdapter getAdapter() {
        return new PANGCIAdapter();
    }
}
