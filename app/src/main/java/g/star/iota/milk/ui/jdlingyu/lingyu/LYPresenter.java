package g.star.iota.milk.ui.jdlingyu.lingyu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class LYPresenter extends StringPresenter<List<LYBean>> {

    public LYPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<LYBean> dealResponse(String s) {
        List<LYBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#single > div.main > div > div.post.image > div.main-body > p > a");
        for (Element element : select) {
            LYBean bean = new LYBean();
            String url = element.attr("href");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
