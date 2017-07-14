package g.star.iota.milk.ui.apic.pic;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class PicFragment extends ScrollImageFragment<PicPresenter, PicAdapter> {

    public static PicFragment newInstance(String url) {
        PicFragment fragment = new PicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected PicPresenter getPresenter() {
        return new PicPresenter(this);
    }

    @Override
    protected PicAdapter getAdapter() {
        return new PicAdapter();
    }

}
