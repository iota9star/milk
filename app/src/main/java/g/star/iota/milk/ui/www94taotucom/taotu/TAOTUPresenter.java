package g.star.iota.milk.ui.www94taotucom.taotu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class TAOTUPresenter extends StringPresenter<List<TAOTUBean>> {

    public TAOTUPresenter(PVContract.View view) {
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
    protected List<TAOTUBean> dealResponse(String s) {
        List<TAOTUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#bodywrap > table > tbody > tr > td > div > div.innercol.grid > div > div > div.item > div > table > tbody > tr > td > img");
        for (Element element : select) {
            TAOTUBean bean = new TAOTUBean();
            String url = element.attr("src");
            if (!url.contains("94taotu.com")) {
                url = Contracts.Url.WWW94TAOTUCOM_BASE + url;
            }
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
