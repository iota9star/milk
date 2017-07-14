package g.star.iota.milk.ui.lesmao.mao;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MaoFragment extends ScrollImageFragment<MaoPresenter, MaoAdapter> {

    public static MaoFragment newInstance(String url) {
        MaoFragment fragment = new MaoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", "-1.html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MaoPresenter getPresenter() {
        return new MaoPresenter(this);
    }

    @Override
    protected MaoAdapter getAdapter() {
        return new MaoAdapter();
    }

}
