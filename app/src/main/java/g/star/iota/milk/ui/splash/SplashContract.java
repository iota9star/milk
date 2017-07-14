package g.star.iota.milk.ui.splash;


public interface SplashContract {
    interface View {
        void getSuccess(HistoryBean bean);

        void getSuccess(String url);

        void getError(String error);
    }

    interface Presenter {
        void getHistory();

        void getImage();

        void unsubscribe();
    }
}
