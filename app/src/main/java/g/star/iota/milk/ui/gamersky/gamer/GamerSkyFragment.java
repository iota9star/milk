package g.star.iota.milk.ui.gamersky.gamer;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class GamerSkyFragment extends ScrollImageFragment<GamerSkyPresenter, GamerSkyAdapter> {


    public static GamerSkyFragment newInstance(String url) {
        GamerSkyFragment fragment = new GamerSkyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", "}");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GamerSkyPresenter getPresenter() {
        return new GamerSkyPresenter(this);
    }

    @Override
    protected GamerSkyAdapter getAdapter() {
        return new GamerSkyAdapter();
    }
}
