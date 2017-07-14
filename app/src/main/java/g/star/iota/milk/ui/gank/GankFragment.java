package g.star.iota.milk.ui.gank;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class GankFragment extends ScrollImageFragment<GankPresenter, GankAdapter> {


    public static GankFragment newInstance(String url) {
        GankFragment fragment = new GankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GankPresenter getPresenter() {
        return new GankPresenter(this);
    }

    @Override
    protected GankAdapter getAdapter() {
        return new GankAdapter();
    }
}
