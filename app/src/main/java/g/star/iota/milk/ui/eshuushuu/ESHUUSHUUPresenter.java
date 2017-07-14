package g.star.iota.milk.ui.eshuushuu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class ESHUUSHUUPresenter extends StringPresenter<List<ESHUUSHUUBean>> {


    public ESHUUSHUUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ESHUUSHUUBean> dealResponse(String s) {
        List<ESHUUSHUUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#content > div.image_thread");
        for (Element element : select) {
            ESHUUSHUUBean bean = new ESHUUSHUUBean();
            String size = element.select("div.meta > dl > dd:nth-child(8)").text();
            size = size.substring(0, size.indexOf("("));
            bean.setSize(size);
            String preview = Contracts.Url.E_SHUUSHUU_BASE + element.select("div.thumb > a > img").attr("src");
            bean.setPreview(preview);
            String url = Contracts.Url.E_SHUUSHUU_BASE + element.select("div.thumb > a").attr("href");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
