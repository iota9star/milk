package g.star.iota.milk.ui.bing;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class BingFragment extends FixedImageFragment<BingPresenter, BingAdapter> {


    public static BingFragment newInstance(String url) {
        BingFragment fragment = new BingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BingPresenter getPresenter() {
        return new BingPresenter(this);
    }

    @Override
    protected BingAdapter getAdapter() {
        return new BingAdapter();
    }
}
