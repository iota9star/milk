package g.star.iota.milk.ui.lingyu.ling;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class LingYuFragment extends ScrollImageFragment<LingYuPresenter, LingYuAdapter> {


    public static LingYuFragment newInstance(String url) {
        LingYuFragment fragment = new LingYuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LingYuPresenter getPresenter() {
        return new LingYuPresenter(this);
    }

    @Override
    protected LingYuAdapter getAdapter() {
        return new LingYuAdapter();
    }
}
