package g.star.iota.milk.ui.gacha;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class GachaPresenter extends StringPresenter<List<GachaBean>> {


    public GachaPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GachaBean> dealResponse(String s) {
        List<GachaBean> list = new ArrayList<>();
        Element top = Jsoup.parse(s).select("div.g-body > div.m-ikon-list.j-ikon-list > div.top-five.f-cb > div.m-ikon-first.f-fl").first();
        GachaBean t = new GachaBean();
        t.setRank(top.select("div > div.rank-num").text());
        t.setAvatar(top.select("div.ikon-mes div > a > img").attr("data-src"));
        t.setAuthor(top.select("div.ikon-mes div > a").text());
        String p = top.select("div.ikon > img").attr("data-src");
        t.setPreview(p);
        String u = p.replace(p.substring(p.lastIndexOf("?imageView")), "");
        t.setUrl(u);
        list.add(t);
        Elements select = Jsoup.parse(s).select("div.g-body >div.m-ikon-list div.m-ikon-card");
        for (Element element : select) {
            GachaBean image = new GachaBean();
            Element ep = element.select("div.ikon > img").first();
            String preview;
            if (ep != null) {
                preview = ep.attr("data-src");
                image.setPreview(preview);
                String url = preview.replace(preview.substring(preview.lastIndexOf("?imageView")), "");
                image.setUrl(url);
            }
            Element er = element.select("div.ikon > div.rank-num").first();
            if (er != null) {
                String rank = er.text();
                image.setRank(rank);
            }
            Element eau = element.select("div.ikon-mes div > a > span").first();
            if (eau != null) {
                String author = eau.text();
                image.setAuthor(author);
            }
            Element eav = element.select("div.ikon-mes div > a > img").first();
            if (eav != null) {
                String avatar = eav.attr("data-src");
                image.setAvatar(avatar);
            }
            list.add(image);
        }
        return list;
    }
}
