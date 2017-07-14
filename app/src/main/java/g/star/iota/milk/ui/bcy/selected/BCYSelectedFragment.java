package g.star.iota.milk.ui.bcy.selected;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class BCYSelectedFragment extends ScrollImageFragment<BCYSelectedPresenter, BCYSelectedAdapter> {

    public static BCYSelectedFragment newInstance(String url) {
        BCYSelectedFragment fragment = new BCYSelectedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BCYSelectedPresenter getPresenter() {
        return new BCYSelectedPresenter(this);
    }

    @Override
    protected BCYSelectedAdapter getAdapter() {
        return new BCYSelectedAdapter();
    }
}
