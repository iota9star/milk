package g.star.iota.milk.ui.booru;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class BooruPresenter extends StringPresenter<List<BooruBean>> {

    public BooruPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<BooruBean> dealResponse(String s) {
        return new Gson().fromJson(s, new TypeToken<List<BooruBean>>() {
        }.getType());
    }
}
