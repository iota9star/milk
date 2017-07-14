package g.star.iota.milk.ui.moeimg.img;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class ImgFragment extends FixedImageFragment<ImgPresenter, ImgAdapter> {

    public static ImgFragment newInstance(String url) {
        ImgFragment fragment = new ImgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ImgPresenter getPresenter() {
        return new ImgPresenter(this);
    }

    @Override
    protected ImgAdapter getAdapter() {
        return new ImgAdapter();
    }

}
