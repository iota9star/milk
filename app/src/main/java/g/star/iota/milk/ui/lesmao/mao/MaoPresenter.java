package g.star.iota.milk.ui.lesmao.mao;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;


public class MaoPresenter extends StringPresenter<List<MaoBean>> {

    public MaoPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MaoBean> dealResponse(String s) {
        List<MaoBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#thread-pic > ul > li > img");
        for (Element element : select) {
            MaoBean bean = new MaoBean();
            String url = element.attr("src");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
