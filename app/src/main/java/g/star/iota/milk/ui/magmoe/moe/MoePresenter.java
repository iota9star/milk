package g.star.iota.milk.ui.magmoe.moe;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MoePresenter extends StringPresenter<List<MoeBean>> {


    public MoePresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MoeBean> dealResponse(String s) {
        List<MoeBean> list = new ArrayList<>();
        Element i = Jsoup.parse(s).select("#main > article div.post-img > a > img").first();
        if (i != null) {
            MoeBean bean = new MoeBean();
            String url = i.attr("src");
            if (url.contains("?itok=")) {
                url = url.replace(url.substring(url.lastIndexOf("?itok=")), "").trim();
            }
            bean.setUrl(url);
            list.add(bean);
        }
        Elements select = Jsoup.parse(s).select("#main > article div.post-entry > p > img");
        for (Element element : select) {
            MoeBean bean = new MoeBean();
            String url = element.attr("src");
            if (url.contains("?itok=")) {
                url = url.replace(url.substring(url.lastIndexOf("?itok=")), "").trim();
            }
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
