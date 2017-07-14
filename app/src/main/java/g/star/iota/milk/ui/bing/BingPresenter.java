package g.star.iota.milk.ui.bing;


import com.google.gson.Gson;

import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class BingPresenter extends StringPresenter<List<BingBean.ImagesBean>> {

    public BingPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<BingBean.ImagesBean> dealResponse(String s) {
        BingBean bean = new Gson().fromJson(s, BingBean.class);
        return bean.getImages();
    }
}
