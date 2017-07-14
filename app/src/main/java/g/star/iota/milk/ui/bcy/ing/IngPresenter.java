package g.star.iota.milk.ui.bcy.ing;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class IngPresenter extends StringPresenter<List<IngBean>> {


    public IngPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<IngBean> dealResponse(String s) {
        List<IngBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("div.post__content img.detail_std");
        for (Element element : select) {
            IngBean bean = new IngBean();
            String url = element.attr("src").replace("/w650", "");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
