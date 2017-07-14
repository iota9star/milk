package g.star.iota.milk.ui.moeimg.img;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class ImgPresenter extends StringPresenter<List<ImgBean>> {

    public ImgPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ImgBean> dealResponse(String s) {
        List<ImgBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main-2 > div.post > div.box > a > img");
        for (Element element : select) {
            ImgBean bean = new ImgBean();
            String url = element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
