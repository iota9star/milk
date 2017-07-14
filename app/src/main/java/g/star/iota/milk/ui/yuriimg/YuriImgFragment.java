package g.star.iota.milk.ui.yuriimg;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class YuriImgFragment extends ScrollImageFragment<YuriImgPresenter, YuriImgAdapter> {


    public static YuriImgFragment newInstance(String url) {
        YuriImgFragment fragment = new YuriImgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YuriImgPresenter getPresenter() {
        return new YuriImgPresenter(this);
    }

    @Override
    protected YuriImgAdapter getAdapter() {
        return new YuriImgAdapter();
    }
}
