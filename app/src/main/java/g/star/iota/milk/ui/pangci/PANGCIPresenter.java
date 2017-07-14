package g.star.iota.milk.ui.pangci;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class PANGCIPresenter extends StringPresenter<List<PANGCIBean>> {

    public PANGCIPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<PANGCIBean> dealResponse(String s) {
        List<PANGCIBean> list = new ArrayList<>();
        String body = Jsoup.parse(s).select("textarea.noshow").first().text();
        Elements eles = Jsoup.parse(body).select("div.item div.line div.p a img");
        for (Element e : eles) {
            PANGCIBean bean = new PANGCIBean();
            String preview = e.attr("src");
            bean.setPreview(preview);
            String url = preview.replace("thumb_300_0_", "");
            bean.setUrl(url);
            String description = e.attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
