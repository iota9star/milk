package g.star.iota.milk.ui.wallhaven.wall;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class WallHavenFragment extends ScrollImageFragment<WallHavenPresenter, WallHavenAdapter> {

    public static WallHavenFragment newInstance(String url) {
        WallHavenFragment fragment = new WallHavenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WallHavenPresenter getPresenter() {
        return new WallHavenPresenter(this);
    }

    @Override
    protected WallHavenAdapter getAdapter() {
        return new WallHavenAdapter();
    }
}
