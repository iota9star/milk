package g.star.iota.milk.ui.www94taotucom.taotu;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class TAOTUFragment extends ScrollImageFragment<TAOTUPresenter, TAOTUAdapter> {

    public static TAOTUFragment newInstance(String url) {
        TAOTUFragment fragment = new TAOTUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TAOTUPresenter getPresenter() {
        return new TAOTUPresenter(this);
    }

    @Override
    protected TAOTUAdapter getAdapter() {
        return new TAOTUAdapter();
    }

}
