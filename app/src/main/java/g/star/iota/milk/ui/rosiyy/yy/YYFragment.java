package g.star.iota.milk.ui.rosiyy.yy;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class YYFragment extends ScrollImageFragment<YYPresenter, YYAdapter> {

    public static YYFragment newInstance(String url) {
        YYFragment fragment = new YYFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YYPresenter getPresenter() {
        return new YYPresenter(this);
    }

    @Override
    protected YYAdapter getAdapter() {
        return new YYAdapter();
    }

}
