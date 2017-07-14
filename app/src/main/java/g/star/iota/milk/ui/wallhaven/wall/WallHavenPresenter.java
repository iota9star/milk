package g.star.iota.milk.ui.wallhaven.wall;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class WallHavenPresenter extends StringPresenter<List<WallHavenBean>> {

    public WallHavenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<WallHavenBean> dealResponse(String s) {
        List<WallHavenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#thumbs > section > ul > li > figure");
        for (Element element : select) {
            WallHavenBean bean = new WallHavenBean();
            String preview = element.select("img.lazyload").attr("data-src");
            bean.setPreview(preview);
            String url = element.select("a.preview").attr("href");
            bean.setUrl(url);
            String size = element.select("div > span.wall-res").text();
            bean.setSize(size);
            list.add(bean);
        }
        return list;
    }
}
