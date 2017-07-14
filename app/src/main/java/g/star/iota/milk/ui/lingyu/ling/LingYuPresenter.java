package g.star.iota.milk.ui.lingyu.ling;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class LingYuPresenter extends StringPresenter<List<LingYuBean>> {

    public LingYuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<LingYuBean> dealResponse(String s) {
        List<LingYuBean> list = new ArrayList<>();
        Document parse = Jsoup.parse(s);
        parse.select("#slideshow").remove();
        Elements select = parse.select("#main > div.wow");
        for (Element element : select) {
            LingYuBean bean = new LingYuBean();
            String preview = element.select("article > div > figure div img").attr("data-original");
            Log.i("preview", "apply: " + preview);
            bean.setPreview(preview);
            String url = element.select("article > header > h2 > a").attr("href");
            bean.setUrl(url);
            String description = element.select("article > header > h2 > a").text();
            bean.setDescription(description);
            String date = element.select("article > div > span.entry-meta > span:nth-child(2)").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
