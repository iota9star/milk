package g.star.iota.milk.ui.xiumm.xiu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class XIUMMPresenter extends StringPresenter<List<XIUMMBean>> {


    public XIUMMPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("page-1.html")) {
            url = Contracts.Url.XIUMM_BASE;
        }
        return url;
    }

    @Override
    protected List<XIUMMBean> dealResponse(String s) {
        List<XIUMMBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#bodywrap > table > tbody > tr > td > div > div > div.gallary_wrap > div.gallary_item_album > div.item > div.pic_box");
        for (Element element : select) {
            XIUMMBean bean = new XIUMMBean();
            String preview = element.select("table > tbody > tr > td > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("table > tbody > tr > td > a").attr("href");
            bean.setUrl(url);
            String description = element.select("table > tbody > tr > td > a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
