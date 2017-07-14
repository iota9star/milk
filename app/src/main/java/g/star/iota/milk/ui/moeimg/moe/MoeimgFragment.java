package g.star.iota.milk.ui.moeimg.moe;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MoeimgFragment extends ScrollImageFragment<MoeimgPresenter, MoeimgAdapter> {


    public static MoeimgFragment newInstance(String url) {
        MoeimgFragment fragment = new MoeimgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MoeimgPresenter getPresenter() {
        return new MoeimgPresenter(this);
    }

    @Override
    protected MoeimgAdapter getAdapter() {
        return new MoeimgAdapter();
    }
}
