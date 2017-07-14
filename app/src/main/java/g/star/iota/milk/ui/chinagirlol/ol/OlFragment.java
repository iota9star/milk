package g.star.iota.milk.ui.chinagirlol.ol;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class OlFragment extends FixedImageFragment<OlPresenter, OlAdapter> {

    public static OlFragment newInstance(String url) {
        OlFragment fragment = new OlFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected OlPresenter getPresenter() {
        return new OlPresenter(this);
    }

    @Override
    protected OlAdapter getAdapter() {
        return new OlAdapter();
    }

}
