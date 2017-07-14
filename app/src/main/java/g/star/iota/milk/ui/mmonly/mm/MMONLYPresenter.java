package g.star.iota.milk.ui.mmonly.mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MMONLYPresenter extends StringPresenter<List<MMONLYBean>> {

    public MMONLYPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MMONLYBean> dealResponse(String s) {
        List<MMONLYBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#infinite_scroll > div.item > div.item_t > div > div.ABox > a");
        for (Element element : select) {
            MMONLYBean bean = new MMONLYBean();
            String preview = element.select("img").attr("original");
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
