package g.star.iota.milk.ui.xiuren.ren;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class RenFragment extends FixedImageFragment<RenPresenter, RenAdapter> {

    public static RenFragment newInstance(String url) {
        RenFragment fragment = new RenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected RenPresenter getPresenter() {
        return new RenPresenter(this);
    }

    @Override
    protected RenAdapter getAdapter() {
        return new RenAdapter();
    }

}
