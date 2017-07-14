package g.star.iota.milk.ui.www005tv.www;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class WWW005TVPresenter extends StringPresenter<List<WWW005TVBean>> {


    public WWW005TVPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<WWW005TVBean> dealResponse(String s) {
        List<WWW005TVBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.article-list-page > div.article-list-wrap > div.article-list > ul > li");
        for (Element element : select) {
            WWW005TVBean bean = new WWW005TVBean();
            String title = element.select("div > div > h3 > a").text();
            bean.setTitle(title);
            String url = element.select("div > div > h3 > a").attr("href");
            bean.setUrl(url);
            String subtitle = element.select("div > div > div.p-row").text();
            bean.setSubtitle(subtitle);
            String date = element.select("div > div > div.label-row > span.time").text();
            bean.setDate(date);
            String preview = element.select("a.img > img").attr("src");
            bean.setPreview(preview);
            list.add(bean);
        }
        return list;
    }
}
