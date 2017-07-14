package g.star.iota.milk.ui.magmoe.mag;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MagPresenter extends StringPresenter<List<MagBean>> {

    public MagPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MagBean> dealResponse(String s) {
        List<MagBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main > article.list-item");
        for (Element element : select) {
            MagBean bean = new MagBean();
            String title = element.select("div.list-content > div.post-header > h2 > a").text();
            bean.setTitle(title);
            String url = element.select("div.list-content > div.post-header > h2 > a").attr("href");
            bean.setUrl(url);
            String subtitle = element.select("div.list-content > div.post-entry > p").text();
            bean.setSubtitle(subtitle);
            String preview = element.select("div.post-img > a > img").attr("src");
            bean.setPreview(preview);
            list.add(bean);
        }
        return list;
    }
}
