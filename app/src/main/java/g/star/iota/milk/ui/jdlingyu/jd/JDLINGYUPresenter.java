package g.star.iota.milk.ui.jdlingyu.jd;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class JDLINGYUPresenter extends StringPresenter<List<JDLINGYUBean>> {

    public JDLINGYUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("/page/1/")) {
            url = url.replace("page/1/", "");
        }
        return url;
    }

    @Override
    protected List<JDLINGYUBean> dealResponse(String s) {
        List<JDLINGYUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#postlist > div.pin");
        for (Element element : select) {
            JDLINGYUBean bean = new JDLINGYUBean();
            String preview = element.select("div.pin-coat > a > img").attr("original");
            if (preview == null || preview.length() < 5) {
                preview = element.select("div.pin-coat > a > img").attr("src");
            }
            bean.setPreview(preview);
            String description = element.select("div.pin-coat > a > img").attr("alt");
            bean.setDescription(description);
            String url = element.select("div.pin-coat > a").attr("href");
            bean.setUrl(url);
            String date = element.select("div.pin-coat > div.pin-data > span.timer > span").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
