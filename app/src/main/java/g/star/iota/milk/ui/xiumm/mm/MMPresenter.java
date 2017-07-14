package g.star.iota.milk.ui.xiumm.mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class MMPresenter extends StringPresenter<List<MMBean>> {

    public MMPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("-1.html")) {
            url = url.replace("-1.html", ".html");
        }
        return url;
    }

    @Override
    protected List<MMBean> dealResponse(String s) {
        List<MMBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#bodywrap > table > tbody > tr > td > div > div.innercol.grid > div > div > div.item > div > table > tbody > tr > td > img");
        for (Element element : select) {
            MMBean bean = new MMBean();
            String url = Contracts.Url.XIUMM_BASE + element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
