package g.star.iota.milk.ui.zerochan;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class ZerochanFragment extends ScrollImageFragment<ZerochanPresenter, ZerochanAdapter> {

    public static ZerochanFragment newInstance(String url) {
        ZerochanFragment fragment = new ZerochanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ZerochanPresenter getPresenter() {
        return new ZerochanPresenter(this);
    }

    @Override
    protected ZerochanAdapter getAdapter() {
        return new ZerochanAdapter();
    }
}
