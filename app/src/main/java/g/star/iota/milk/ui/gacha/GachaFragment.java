package g.star.iota.milk.ui.gacha;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class GachaFragment extends FixedImageFragment<GachaPresenter, GachaAdapter> {


    public static GachaFragment newInstance(String url) {
        GachaFragment fragment = new GachaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GachaPresenter getPresenter() {
        return new GachaPresenter(this);
    }

    @Override
    protected GachaAdapter getAdapter() {
        return new GachaAdapter();
    }
}
