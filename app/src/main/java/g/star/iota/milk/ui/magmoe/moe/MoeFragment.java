package g.star.iota.milk.ui.magmoe.moe;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;

public class MoeFragment extends FixedImageFragment<MoePresenter, MoeAdapter> {

    public static MoeFragment newInstance(String url) {
        MoeFragment fragment = new MoeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MoePresenter getPresenter() {
        return new MoePresenter(this);
    }

    @Override
    protected MoeAdapter getAdapter() {
        return new MoeAdapter();
    }

}
