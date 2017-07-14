package g.star.iota.milk.ui.anipic.pictures;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class PicturesPresenter extends StringPresenter<List<PicturesBean>> {


    public PicturesPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<PicturesBean> dealResponse(String s) {
        List<PicturesBean> list = new ArrayList<>();
        Element select = Jsoup.parse(s).select("#rating > a.download_icon").first();
        PicturesBean bean = new PicturesBean();
        String url = Contracts.Url.ANIME_PICTURES_BASE + select.attr("href");
        bean.setUrl(url);
        list.add(bean);
        return list;
    }
}
