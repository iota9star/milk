package g.star.iota.milk.ui.tngou;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class TGFragment extends ScrollImageFragment<TGPresenter, TGAdapter> {

    public static TGFragment newInstance(String url) {
        TGFragment fragment = new TGFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TGPresenter getPresenter() {
        return new TGPresenter(this);
    }

    @Override
    protected TGAdapter getAdapter() {
        return new TGAdapter();
    }
}
