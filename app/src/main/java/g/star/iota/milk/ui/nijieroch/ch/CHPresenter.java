package g.star.iota.milk.ui.nijieroch.ch;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class CHPresenter extends StringPresenter<List<CHBean>> {

    public CHPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<CHBean> dealResponse(String s) {
        List<CHBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#entry > ul > li > a > img");
        for (Element element : select) {
            CHBean bean = new CHBean();
            String url = element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
