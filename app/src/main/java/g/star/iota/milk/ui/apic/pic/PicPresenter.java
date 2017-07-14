package g.star.iota.milk.ui.apic.pic;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class PicPresenter extends StringPresenter<List<PicBean>> {
    @Override
    protected String dealUrl(String url) {
        if (url.contains(".htm/1")) {
            String page = url.substring(url.lastIndexOf("/") + 1, url.length());
            if (Integer.parseInt(page) == 1) {
                url = url.replace(".htm/1", ".htm");
            }
        }
        return url;
    }

    public PicPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<PicBean> dealResponse(String s) {
        List<PicBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post > div.post > p img");
        for (Element element : select) {
            PicBean bean = new PicBean();
            String url = element.attr("src").replace("!origin", "");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
