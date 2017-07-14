package g.star.iota.milk.ui.xiuren.xiu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class XiuRenPresenter extends StringPresenter<List<XiuRenBean>> {

    public XiuRenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<XiuRenBean> dealResponse(String s) {
        List<XiuRenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main > div.loop > div.content > a");
        for (Element element : select) {
            XiuRenBean bean = new XiuRenBean();
            String preview = element.select("img").attr("src");
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
