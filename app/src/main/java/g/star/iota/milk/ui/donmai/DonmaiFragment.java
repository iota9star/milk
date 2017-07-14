package g.star.iota.milk.ui.donmai;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class DonmaiFragment extends ScrollImageFragment<DonmaiPresenter, DonmaiAdapter> {

    public static DonmaiFragment newInstance(String url) {
        DonmaiFragment fragment = new DonmaiFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected DonmaiPresenter getPresenter() {
        return new DonmaiPresenter(this);
    }

    @Override
    protected DonmaiAdapter getAdapter() {
        return new DonmaiAdapter();
    }
}
