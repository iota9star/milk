package g.star.iota.milk.ui.anipic.anime;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class AnimePictureFragment extends ScrollImageFragment<AnimePicturePresenter, AnimePictureAdapter> {


    public static AnimePictureFragment newInstance(String url) {
        AnimePictureFragment fragment = new AnimePictureFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putInt("initial_page", 0);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected AnimePicturePresenter getPresenter() {
        return new AnimePicturePresenter(this);
    }

    @Override
    protected AnimePictureAdapter getAdapter() {
        return new AnimePictureAdapter();
    }
}
