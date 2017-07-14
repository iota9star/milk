package g.star.iota.milk.ui.magmoe.mag;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class MagFragment extends ScrollImageFragment<MagPresenter, MagAdapter> {

    public static MagFragment newInstance(String url) {
        MagFragment fragment = new MagFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MagPresenter getPresenter() {
        return new MagPresenter(this);
    }

    @Override
    protected MagAdapter getAdapter() {
        return new MagAdapter();
    }

}
