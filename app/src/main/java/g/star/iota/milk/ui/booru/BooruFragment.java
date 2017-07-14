package g.star.iota.milk.ui.booru;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class BooruFragment extends ScrollImageFragment<BooruPresenter, BooruAdapter> {

    public static BooruFragment newInstance(String url) {
        BooruFragment fragment = new BooruFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BooruPresenter getPresenter() {
        return new BooruPresenter(this);
    }

    @Override
    protected BooruAdapter getAdapter() {
        return new BooruAdapter();
    }
}
