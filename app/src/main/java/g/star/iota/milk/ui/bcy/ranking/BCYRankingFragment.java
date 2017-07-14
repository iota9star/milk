package g.star.iota.milk.ui.bcy.ranking;


import android.os.Bundle;

import g.star.iota.milk.base.FixedImageFragment;


public class BCYRankingFragment extends FixedImageFragment<BCYRankingPresenter, BCYRankingAdapter> {

    public static BCYRankingFragment newInstance(String url) {
        BCYRankingFragment fragment = new BCYRankingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BCYRankingPresenter getPresenter() {
        return new BCYRankingPresenter(this);
    }

    @Override
    protected BCYRankingAdapter getAdapter() {
        return new BCYRankingAdapter();
    }
}
