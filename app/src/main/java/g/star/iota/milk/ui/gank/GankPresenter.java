package g.star.iota.milk.ui.gank;


import com.google.gson.Gson;

import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class GankPresenter extends StringPresenter<List<GankBean.ResultsBean>> {

    public GankPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GankBean.ResultsBean> dealResponse(String s) {
        return new Gson().fromJson(s, GankBean.class).getResults();
    }
}
