package g.star.iota.milk.ui.bcy.ing;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class IngFragment extends FixedImageFragment<IngPresenter, IngAdapter> {

    public static IngFragment newInstance(String url) {
        IngFragment fragment = new IngFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected IngPresenter getPresenter() {
        return new IngPresenter(this);
    }

    @Override
    protected IngAdapter getAdapter() {
        return new IngAdapter();
    }

}
