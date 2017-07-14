package g.star.iota.milk.ui.xiuren.xiu;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class XiuRenFragment extends ScrollImageFragment<XiuRenPresenter, XiuRenAdapter> {


    public static XiuRenFragment newInstance(String url) {
        XiuRenFragment fragment = new XiuRenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected XiuRenPresenter getPresenter() {
        return new XiuRenPresenter(this);
    }

    @Override
    protected XiuRenAdapter getAdapter() {
        return new XiuRenAdapter();
    }
}
