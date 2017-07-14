package g.star.iota.milk.ui.eshuushuu;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class ESHUUSHUUFragment extends ScrollImageFragment<ESHUUSHUUPresenter, ESHUUSHUUAdapter> {

    public static ESHUUSHUUFragment newInstance(String url) {
        ESHUUSHUUFragment fragment = new ESHUUSHUUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ESHUUSHUUPresenter getPresenter() {
        return new ESHUUSHUUPresenter(this);
    }

    @Override
    protected ESHUUSHUUAdapter getAdapter() {
        return new ESHUUSHUUAdapter();
    }
}
