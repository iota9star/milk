package g.star.iota.milk.ui.nijieroch.ch;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class CHFragment extends FixedImageFragment<CHPresenter, CHAdapter> {

    public static CHFragment newInstance(String url) {
        CHFragment fragment = new CHFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected CHPresenter getPresenter() {
        return new CHPresenter(this);
    }

    @Override
    protected CHAdapter getAdapter() {
        return new CHAdapter();
    }

}
