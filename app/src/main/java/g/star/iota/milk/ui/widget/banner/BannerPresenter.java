package g.star.iota.milk.ui.widget.banner;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class BannerPresenter implements BannerContract.Presenter {

    private final BannerContract.View view;

    private final CompositeDisposable mCompositeDisposable;

    public BannerPresenter(BannerContract.View view) {
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getBanner() {
        String url = Contracts.Url.MOEIMG + (int) (Math.random() * 100);
        mCompositeDisposable.add(
                OkGo.<String>get(url)
                        .converter(new StringConvert())
                        .adapt(new ObservableResponse<String>())
                        .subscribeOn(Schedulers.io())
                        .map(new Function<Response<String>, String>() {
                            @Override
                            public String apply(@NonNull Response<String> s) throws Exception {
                                List<String> list = new ArrayList<>();
                                Elements select = Jsoup.parse(s.body()).select("#main-2 > div.post");
                                for (Element element : select) {
                                    String preview = element.select("div.more-field > div > a > img").attr("src");
                                    list.add(preview);
                                }
                                return list.get((int) (Math.random() * list.size()));
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                view.getBannerSuccess(s);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                view.getBannerError();
                            }
                        })
        );
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

}
