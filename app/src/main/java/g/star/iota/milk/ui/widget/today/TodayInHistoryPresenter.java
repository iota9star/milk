package g.star.iota.milk.ui.widget.today;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.ui.splash.HistoryBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TodayInHistoryPresenter implements TodayInHistoryContract.Presenter {

    private final TodayInHistoryContract.View view;

    private final CompositeDisposable mCompositeDisposable;

    public TodayInHistoryPresenter(TodayInHistoryContract.View view) {
        this.view = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getToday() {
        mCompositeDisposable.add(
                OkGo.<String>get(Contracts.Url.TODAY_IN_HISTORY)
                        .converter(new StringConvert())
                        .adapt(new ObservableResponse<String>())
                        .subscribeOn(Schedulers.io())
                        .map(new Function<Response<String>, HistoryBean>() {
                            @Override
                            public HistoryBean apply(@NonNull Response<String> s) throws Exception {
                                Element element = Jsoup.parse(s.body()).select("body > div.main > div.banner > div.history").first();
                                String year = element.select("div.hs-year").text();
                                String day = element.select("div.hs-month-day").text();
                                String event = element.select("div.hs-event").text();
                                return new HistoryBean(day, year, event);
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<HistoryBean>() {
                            @Override
                            public void accept(@NonNull HistoryBean historyBean) throws Exception {
                                view.getSuccess(historyBean);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                view.getError();
                            }
                        })
        );
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

}
