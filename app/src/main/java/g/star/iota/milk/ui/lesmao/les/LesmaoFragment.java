package g.star.iota.milk.ui.lesmao.les;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class LesmaoFragment extends ScrollImageFragment<LesmaoPresenter, LesmaoAdapter> {


    public static LesmaoFragment newInstance(String url) {
        LesmaoFragment fragment = new LesmaoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LesmaoPresenter getPresenter() {
        return new LesmaoPresenter(this);
    }

    @Override
    protected LesmaoAdapter getAdapter() {
        return new LesmaoAdapter();
    }
}
