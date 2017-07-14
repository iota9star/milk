package g.star.iota.milk.ui.bcy.ranking;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class BCYRankingPresenter extends StringPresenter<List<BCYRankingBean>> {


    public BCYRankingPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<BCYRankingBean> dealResponse(String s) {
        List<BCYRankingBean> list = new ArrayList<>();
        Element doc = Jsoup.parse(s)
                .select("body > div.div_body > div.row.grid.grid--25")
                .first();
        Elements eles = doc.select("ul > div.l-clearfix > li.l-work-thumbnail");
        for (Element e : eles) {
            BCYRankingBean bean = new BCYRankingBean();
            String description = e.select("div > div.work-thumbnail__ft.center > a").text();
            bean.setDescription(description);
            String author = e.select("div > div.center.cut > span > a").text();
            bean.setAuthor(author);
            String avatar = e.select("div.center.cut > a > img").attr("src");
            bean.setAvatar(avatar);
            String ranking = e.select("span").first().text();
            bean.setRank(ranking);
            String preview = e.select("div > div.work-thumbnail__topBd > a > img").attr("src");
            bean.setPreview(preview);
            String url = Contracts.Url.BCY_BASE + e.select("div > div.work-thumbnail__ft.center > a").attr("href");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
