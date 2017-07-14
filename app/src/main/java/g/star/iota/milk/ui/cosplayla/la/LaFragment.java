package g.star.iota.milk.ui.cosplayla.la;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class LaFragment extends FixedImageFragment<LaPresenter, LaAdapter> {

    public static LaFragment newInstance(String url) {
        LaFragment fragment = new LaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LaPresenter getPresenter() {
        return new LaPresenter(this);
    }

    @Override
    protected LaAdapter getAdapter() {
        return new LaAdapter();
    }

}
