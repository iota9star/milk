package g.star.iota.milk.ui.moe005tv.moe;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class MOE005TVPresenter extends StringPresenter<List<MOE005TVBean>> {

    public MOE005TVPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MOE005TVBean> dealResponse(String s) {
        List<MOE005TVBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.nav_warp > div.nav_w_left > div.zhuti_w_list > ul > li");
        for (Element element : select) {
            MOE005TVBean bean = new MOE005TVBean();
            String preview = element.select("span.zt_pic > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("span.zt_dep > strong > a").attr("href");
            bean.setUrl(url);
            String description = element.select("span.zt_dep > strong > a").text();
            bean.setDescription(description);
            String date = element.select("span.zt_dep > dl > dt").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
