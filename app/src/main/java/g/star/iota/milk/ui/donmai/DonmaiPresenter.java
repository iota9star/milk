package g.star.iota.milk.ui.donmai;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.PVContract;
import g.star.iota.milk.base.StringPresenter;

public class DonmaiPresenter extends StringPresenter<List<DonmaiBean>> {


    private String url;

    public DonmaiPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected String dealUrl(String url) {
        this.url = url;
        return super.dealUrl(url);
    }

    @Override
    protected List<DonmaiBean> dealResponse(String s) {
        List<DonmaiBean> beans = new Gson().fromJson(s, new TypeToken<List<DonmaiBean>>() {
        }.getType());
        for (DonmaiBean bean : beans) {
            if (url.contains("safebooru")) {
                bean.setUrl(Contracts.Url.SAFEBOORU_BASE + bean.getUrl());
                bean.setPreview(Contracts.Url.SAFEBOORU_BASE + bean.getPreview());
            } else if (url.contains("danbooru")) {
                bean.setUrl(Contracts.Url.DANBOORU_BASE + bean.getUrl());
                bean.setPreview(Contracts.Url.DANBOORU_BASE + bean.getPreview());
            }
        }
        return beans;
    }
}
