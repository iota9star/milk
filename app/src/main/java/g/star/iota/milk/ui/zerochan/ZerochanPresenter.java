package g.star.iota.milk.ui.zerochan;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class ZerochanPresenter extends StringPresenter<List<ZerochanBean>> {

    public ZerochanPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ZerochanBean> dealResponse(String s) {
        List<ZerochanBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#thumbs2 > li > a > img");
        for (Element element : select) {
            ZerochanBean bean = new ZerochanBean();
            String description = element.attr("alt");
            bean.setDescription(description);
            String info = element.attr("title");
            bean.setInfo(info);
            String preview = element.attr("src");
            bean.setPreview(preview);
            String url = preview.replace("s3", "static").replace(".240.", ".full.");
            bean.setUrl(url);
            list.add(bean);
        }
        return list;
    }
}
