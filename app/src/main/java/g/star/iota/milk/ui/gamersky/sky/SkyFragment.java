package g.star.iota.milk.ui.gamersky.sky;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class SkyFragment extends ScrollImageFragment<SkyPresenter, SkyAdapter> {

    public static SkyFragment newInstance(String url) {
        SkyFragment fragment = new SkyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".shtml");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected SkyPresenter getPresenter() {
        return new SkyPresenter(this);
    }

    @Override
    protected SkyAdapter getAdapter() {
        return new SkyAdapter();
    }

}
