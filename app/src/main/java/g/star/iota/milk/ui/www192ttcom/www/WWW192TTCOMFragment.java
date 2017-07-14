package g.star.iota.milk.ui.www192ttcom.www;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;


public class WWW192TTCOMFragment extends ScrollImageFragment<WWW192TTCOMPresenter, WWW192TTCOMAdapter> {


    public static WWW192TTCOMFragment newInstance(String url) {
        WWW192TTCOMFragment fragment = new WWW192TTCOMFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putInt("initial_page", 0);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WWW192TTCOMPresenter getPresenter() {
        return new WWW192TTCOMPresenter(this);
    }

    @Override
    protected WWW192TTCOMAdapter getAdapter() {
        return new WWW192TTCOMAdapter();
    }
}
