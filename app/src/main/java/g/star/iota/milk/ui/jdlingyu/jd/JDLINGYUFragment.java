package g.star.iota.milk.ui.jdlingyu.jd;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class JDLINGYUFragment extends ScrollImageFragment<JDLINGYUPresenter, JDLINGYUAdapter> {


    public static JDLINGYUFragment newInstance(String url) {
        JDLINGYUFragment fragment = new JDLINGYUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", "/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected JDLINGYUPresenter getPresenter() {
        return new JDLINGYUPresenter(this);
    }

    @Override
    protected JDLINGYUAdapter getAdapter() {
        return new JDLINGYUAdapter();
    }
}
