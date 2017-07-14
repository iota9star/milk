package g.star.iota.milk.ui.apic.a;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class ApicPresenter extends StringPresenter<List<ApicBean>> {


    public ApicPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ApicBean> dealResponse(String s) {
        List<ApicBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main > div.loop");
        if (select.size() < 1) {
            select = Jsoup.parse(s).select("#primary > div > article.angela--post-home");
            for (Element element : select) {
                ApicBean bean = new ApicBean();
                String preview = element.select("a.block-image").attr("style").replace("background-image:url(", "").replace(")", "").trim().replaceAll(" ", "");
                bean.setPreview(preview);
                String url = element.select("h2.angela-title > a").attr("href");
                bean.setUrl(url);
                String description = element.select("h2.angela-title > a").text();
                bean.setDescription(description);
                String date = element.select("div.v-clearfix.block-postMetaWrap > div > div.postMetaInline-feedSummary > span.postMetaInline.postMetaInline--supplemental").text();
                bean.setDate(date);
                list.add(bean);
            }
        } else {
            for (Element element : select) {
                ApicBean bean = new ApicBean();
                String preview = element.select("div.content > a > img").attr("src").replace("!thumb", "");
                bean.setPreview(preview);
                String url = element.select("h2 > a").attr("href");
                bean.setUrl(url);
                String description = element.select("h2 > a").text();
                bean.setDescription(description);
                element.select("div.date > div").remove();
                String date = element.select("div.date").text();
                bean.setDate(date);
                list.add(bean);
            }
        }
        return list;
    }

}
