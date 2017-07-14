package g.star.iota.milk.ui.tngou;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class TGClassifyPresenter extends StringPresenter<List<ClassifyBean.TngouBean>> {

    public TGClassifyPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ClassifyBean.TngouBean> dealResponse(String s) {
        return new Gson().fromJson(s, new TypeToken<List<ClassifyBean.TngouBean>>() {
        }.getType());
    }
}
