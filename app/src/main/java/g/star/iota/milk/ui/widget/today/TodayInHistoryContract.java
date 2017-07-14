package g.star.iota.milk.ui.widget.today;


import g.star.iota.milk.ui.splash.HistoryBean;

public interface TodayInHistoryContract {
    interface View {
        void getSuccess(HistoryBean bean);

        void getError();
    }

    interface Presenter {
        void getToday();

        void unsubscribe();
    }
}
