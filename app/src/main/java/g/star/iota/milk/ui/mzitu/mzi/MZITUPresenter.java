package g.star.iota.milk.ui.mzitu.mzi;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MZITUPresenter extends StringPresenter<List<MZITUBean>> {


    public MZITUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MZITUBean> dealResponse(String s) {
        List<MZITUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#pins > li");
        for (Element element : select) {
            MZITUBean bean = new MZITUBean();
            String preview = element.select("a > img").attr("data-original");
            bean.setPreview(preview);
            String url = element.select("span:nth-child(2) > a").attr("href") + "/";
            bean.setUrl(url);
            String description = element.select("span:nth-child(2) > a").text();
            bean.setDescription(description);
            String date = element.select("span.time").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
