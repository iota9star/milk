package g.star.iota.milk.ui.mangadrawing;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MangaDrawingPresenter extends StringPresenter<List<MangaDrawingBean>> {

    public MangaDrawingPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MangaDrawingBean> dealResponse(String s) {
        List<MangaDrawingBean> list = new ArrayList<>();
        Elements elements = Jsoup.parse(s)
                .select("#content > div  div.view-content ul > li.views-fluid-grid-inline.views-fluid-grid-item > div > span > a > img");
        for (Element e : elements) {
            MangaDrawingBean bean = new MangaDrawingBean();
            String preview = e.attr("src");
            bean.setPreview(preview);
            String url = "http://static.mangadrawing.net/users/image" + preview.substring(preview.lastIndexOf("/"));
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
