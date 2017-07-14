package g.star.iota.milk.ui.nijieroch.nijiero;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class NijieroCHPresenter extends StringPresenter<List<NijieroCHBean>> {

    public NijieroCHPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<NijieroCHBean> dealResponse(String s) {
        List<NijieroCHBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#mainContent > div.post");
        for (Element element : select) {
            NijieroCHBean bean = new NijieroCHBean();
            String preview = element.select("a > div > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("section > h1 > a").attr("href");
            bean.setUrl(url);
            String description = element.select("section > h1 > a").text();
            bean.setDescription(description);
            String date = element.select("section > div > dl:nth-child(2) > dd").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
