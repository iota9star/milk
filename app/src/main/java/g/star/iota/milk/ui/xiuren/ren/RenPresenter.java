package g.star.iota.milk.ui.xiuren.ren;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class RenPresenter extends StringPresenter<List<RenBean>> {

    public RenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<RenBean> dealResponse(String s) {
        List<RenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post > div.post > p > span.photoThum > a");
        for (Element element : select) {
            RenBean bean = new RenBean();
            String url = element.attr("href");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
