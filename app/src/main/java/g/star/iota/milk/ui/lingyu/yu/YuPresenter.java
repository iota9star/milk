package g.star.iota.milk.ui.lingyu.yu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class YuPresenter extends StringPresenter<List<YuBean>> {

    public YuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YuBean> dealResponse(String s) {
        List<YuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("article > div > div.single-content > p > a > img");
        for (Element element : select) {
            YuBean bean = new YuBean();
            String url = element.attr("data-original");
            url = url.replace(url.substring(url.lastIndexOf("-"), url.lastIndexOf(".")), "");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
