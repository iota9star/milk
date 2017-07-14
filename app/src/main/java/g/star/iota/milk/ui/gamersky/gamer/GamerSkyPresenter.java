package g.star.iota.milk.ui.gamersky.gamer;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class GamerSkyPresenter extends StringPresenter<List<GamerSkyBean>> {


    public GamerSkyPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GamerSkyBean> dealResponse(String s) {
        List<GamerSkyBean> list = new ArrayList<>();
        Elements select = Jsoup.parseBodyFragment(s.replaceAll("\\\\", "")).select("li.img > a");
        for (Element element : select) {
            GamerSkyBean bean = new GamerSkyBean();
            String preview = element.select("img").attr("src");
            bean.setPreview(preview);
            String url = element.attr("href");
            bean.setUrl(url);
            String description = element.attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
