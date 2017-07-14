package g.star.iota.milk.ui.yuriimg;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class YuriImgPresenter extends StringPresenter<List<YuriImgBean>> {


    public YuriImgPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YuriImgBean> dealResponse(String s) {
        List<YuriImgBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#image-box div.image-list");
        for (Element element : select) {
            YuriImgBean bean = new YuriImgBean();
            String preview = element.select("div.image img").attr("data-original");
            bean.setPreview(preview);
            String url = Contracts.Url.YURIIMG_BASE + element.select("div.image img").attr("data-viewersss");
            bean.setUrl(url);
            String description = element.select("div.image img").attr("alt");
            bean.setDescription(description);
            String size = element.select("div.img-control > div.like > a > span").text();
            bean.setSize(size);
            String referer = Contracts.Url.YURIIMG_BASE + element.select("div.image img").attr("data-href");
            bean.setReferer(referer);
            list.add(bean);
        }
        return list;
    }

}
