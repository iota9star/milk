package g.star.iota.milk.ui.nijieroch.nijiero;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class NijieroCHFragment extends ScrollImageFragment<NijieroCHPresenter, NijieroCHAdapter> {


    public static NijieroCHFragment newInstance(String url) {
        NijieroCHFragment fragment = new NijieroCHFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected NijieroCHPresenter getPresenter() {
        return new NijieroCHPresenter(this);
    }

    @Override
    protected NijieroCHAdapter getAdapter() {
        return new NijieroCHAdapter();
    }

}
