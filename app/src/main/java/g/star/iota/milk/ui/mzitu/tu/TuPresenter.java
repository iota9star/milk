package g.star.iota.milk.ui.mzitu.tu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class TuPresenter extends StringPresenter<List<TuBean>> {

    public TuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<TuBean> dealResponse(String s) {
        List<TuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.main > div.content > div.main-image > p > a > img");
        for (Element element : select) {
            TuBean bean = new TuBean();
            String url = element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
