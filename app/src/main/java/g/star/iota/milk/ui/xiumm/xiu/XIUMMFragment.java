package g.star.iota.milk.ui.xiumm.xiu;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class XIUMMFragment extends ScrollImageFragment<XIUMMPresenter, XIUMMAdapter> {


    public static XIUMMFragment newInstance(String url) {
        XIUMMFragment fragment = new XIUMMFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected XIUMMPresenter getPresenter() {
        return new XIUMMPresenter(this);
    }

    @Override
    protected XIUMMAdapter getAdapter() {
        return new XIUMMAdapter();
    }
}
