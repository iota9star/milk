package g.star.iota.milk.ui.gamersky.sky;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class SkyPresenter extends StringPresenter<List<SkyBean>> {

    public SkyPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<SkyBean> dealResponse(String s) {
        List<SkyBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.Mid > div.Mid_con > div.Mid_L > div.MidL_con > p > a");
        for (Element element : select) {
            String url = element.attr("href");
            if (!url.contains(".shtml?http")) continue;
            url = url.substring(url.indexOf(".shtml?http") + 7, url.length());
            SkyBean bean = new SkyBean();
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.shtml")) {
            url = url.replace("_1.shtml", ".shtml");
        }
        return url;
    }
}
