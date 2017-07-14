package g.star.iota.milk.ui.mangadrawing;


import android.os.Bundle;

import g.star.iota.milk.base.ScrollImageFragment;

public class MangaDrawingFragment extends ScrollImageFragment<MangaDrawingPresenter, MangaDrawingAdapter> {


    public static MangaDrawingFragment newInstance(String url) {
        MangaDrawingFragment fragment = new MangaDrawingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putInt("initial_page", 0);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MangaDrawingPresenter getPresenter() {
        return new MangaDrawingPresenter(this);
    }

    @Override
    protected MangaDrawingAdapter getAdapter() {
        return new MangaDrawingAdapter();
    }
}
