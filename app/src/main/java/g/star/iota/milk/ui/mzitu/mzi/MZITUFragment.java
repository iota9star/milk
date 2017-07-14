package g.star.iota.milk.ui.mzitu.mzi;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MZITUFragment extends ScrollImageFragment<MZITUPresenter, MZITUAdapter> {


    public static MZITUFragment newInstance(String url) {
        MZITUFragment fragment = new MZITUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MZITUPresenter getPresenter() {
        return new MZITUPresenter(this);
    }

    @Override
    protected MZITUAdapter getAdapter() {
        return new MZITUAdapter();
    }
}
