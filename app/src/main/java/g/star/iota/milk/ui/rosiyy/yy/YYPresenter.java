package g.star.iota.milk.ui.rosiyy.yy;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class YYPresenter extends StringPresenter<List<YYBean>> {

    public YYPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YYBean> dealResponse(String s) {
        List<YYBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#content > div.post.postimg > p > a > img");
        for (Element element : select) {
            YYBean bean = new YYBean();
            String url = Contracts.Url.ROSIYY_BASE + element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
