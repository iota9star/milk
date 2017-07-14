package g.star.iota.milk.ui.chinagirlol.china;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class ChinaGirlOLPresenter extends StringPresenter<List<ChinaGirlOLBean>> {


    public ChinaGirlOLPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ChinaGirlOLBean> dealResponse(String s) {
        List<ChinaGirlOLBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#waterfall > li > div.c.cl > a");
        for (Element element : select) {
            ChinaGirlOLBean bean = new ChinaGirlOLBean();
            String preview = Contracts.Url.CHINAGIRLOL_BASE + element.select("img").attr("src");
            bean.setPreview(preview);
            String url = element.attr("href");
            bean.setUrl(url);
            String description = element.select("img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
