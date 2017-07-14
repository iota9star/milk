package g.star.iota.milk.ui.mangadrawing;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PagerFragment;
import g.star.iota.milk.base.TitlePagerAdapter;


public class MangaDrawingPagerFragment extends PagerFragment {
    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("ALL");
        titles.add("IMAGES");
        titles.add("ARTWORKS");
        titles.add("FAVORITES");
        titles.add("DOWNLOADS");
        titles.add("POPULAR");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_ALL));
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_IMAGES));
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_ARTWORKS));
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_FAVORITES));
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_DOWNLOADS));
        fragments.add(MangaDrawingFragment.newInstance(Contracts.Url.MANGA_DRAWING_POPULAR));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return 0;
    }
}
