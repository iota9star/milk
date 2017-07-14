package g.star.iota.milk.ui.rosiyy.rosi;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class ROSIYYFragment extends ScrollImageFragment<ROSIYYPresenter, ROSIYYAdapter> {


    public static ROSIYYFragment newInstance(String url) {
        ROSIYYFragment fragment = new ROSIYYFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ROSIYYPresenter getPresenter() {
        return new ROSIYYPresenter(this);
    }

    @Override
    protected ROSIYYAdapter getAdapter() {
        return new ROSIYYAdapter();
    }
}
