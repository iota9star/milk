package g.star.iota.milk.ui.lingyu.yu;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class YuFragment extends ScrollImageFragment<YuPresenter, YuAdapter> {

    public static YuFragment newInstance(String url) {
        YuFragment fragment = new YuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YuPresenter getPresenter() {
        return new YuPresenter(this);
    }

    @Override
    protected YuAdapter getAdapter() {
        return new YuAdapter();
    }

}
