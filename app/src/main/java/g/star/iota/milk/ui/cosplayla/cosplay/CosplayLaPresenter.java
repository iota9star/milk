package g.star.iota.milk.ui.cosplayla.cosplay;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class CosplayLaPresenter extends StringPresenter<List<CosplayLaBean>> {

    public CosplayLaPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<CosplayLaBean> dealResponse(String s) {
        List<CosplayLaBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.box > div.pics > ul > li.fleft");
        for (Element element : select) {
            CosplayLaBean bean = new CosplayLaBean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview(preview);
            String url = Contracts.Url.COSPLAY_LA_BASE + element.select("p:nth-child(2) > a").attr("href");
            bean.setUrl(url);
            String description = element.select("p:nth-child(2) > a").text();
            bean.setDescription(description);
            String date = element.select("p:nth-child(3) > span").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
