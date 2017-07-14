package g.star.iota.milk.ui.anipic.pictures;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class PicturesFragment extends ScrollImageFragment<PicturesPresenter, PicturesAdapter> {

    public static PicturesFragment newInstance(String url) {
        PicturesFragment fragment = new PicturesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected PicturesPresenter getPresenter() {
        return new PicturesPresenter(this);
    }

    @Override
    protected PicturesAdapter getAdapter() {
        return new PicturesAdapter();
    }

}
