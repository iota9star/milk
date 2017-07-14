package g.star.iota.milk.ui.apic.a;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class ApicFragment extends ScrollImageFragment<ApicPresenter, ApicAdapter> {


    public static ApicFragment newInstance(String url) {
        ApicFragment fragment = new ApicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ApicPresenter getPresenter() {
        return new ApicPresenter(this);
    }

    @Override
    protected ApicAdapter getAdapter() {
        return new ApicAdapter();
    }
}
