package g.star.iota.milk.ui.minitokyo;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class MINITOKYOFragment extends ScrollImageFragment<MINITOKYOPresenter, MINITOKYOAdapter> {


    public static MINITOKYOFragment newInstance(String url) {
        MINITOKYOFragment fragment = new MINITOKYOFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MINITOKYOPresenter getPresenter() {
        return new MINITOKYOPresenter(this);
    }

    @Override
    protected MINITOKYOAdapter getAdapter() {
        return new MINITOKYOAdapter();
    }
}
