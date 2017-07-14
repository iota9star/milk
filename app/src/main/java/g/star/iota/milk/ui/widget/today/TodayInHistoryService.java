package g.star.iota.milk.ui.widget.today;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Timer;
import java.util.TimerTask;

import g.star.iota.milk.R;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.ui.splash.HistoryBean;
import g.star.iota.milk.ui.widget.banner.BannerContract;
import g.star.iota.milk.ui.widget.banner.BannerPresenter;
import g.star.iota.milk.util.ConfigUtils;


public class TodayInHistoryService extends Service implements TodayInHistoryContract.View, BannerContract.View {

    private TodayInHistoryPresenter mTodayInHistoryPresenter;
    private BannerPresenter mBannerPresenter;
    private Timer mTimer;
    private boolean todayIsRunning = false;
    private boolean bannerIsRunning = false;
    private Context mContext;

    private TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            getToday();
            getBanner();
        }
    };

    private RefreshReceiver mRefreshReceiver;
    private Context aContext;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void getToday() {
        if (todayIsRunning) return;
        todayIsRunning = true;
        mTodayInHistoryPresenter.getToday();
    }

    private void getBanner() {
        if (bannerIsRunning) return;
        bannerIsRunning = true;
        mBannerPresenter.getBanner();
    }


    private static final String ACTION_REFRESH = "star.iota.widget.today.in.history.refresh";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        aContext = getApplicationContext();
        IntentFilter filter = new IntentFilter(ACTION_REFRESH);
        registerReceiver(mRefreshReceiver = new RefreshReceiver(), filter);
        mTodayInHistoryPresenter = new TodayInHistoryPresenter(this);
        mBannerPresenter = new BannerPresenter(this);
        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(mTask, 0, 1000 * 60 * ConfigUtils.getTodayInHistroyInterval(aContext));
    }

    @Override
    public void getSuccess(HistoryBean bean) {
        todayIsRunning = false;
        updateToday(bean);
    }

    private void updateToday(HistoryBean bean) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_today_in_history_with_banner);
        if (bean.getYear().trim().replaceAll(" ", "").length() < 3) {
            views.setTextViewText(R.id.text_view_today_in_history, "今天天气应该不错吧");
        } else {
            views.setTextViewText(R.id.text_view_today_in_history, bean.getEvent() + "\u3000>>>\u3000" + bean.getDay() + " : " + bean.getYear());
        }
        Intent playIntent = new Intent(ACTION_REFRESH);
        PendingIntent refresh = PendingIntent.getBroadcast(mContext, 0, playIntent, 0);
        views.setOnClickPendingIntent(R.id.image_view_banner, refresh);
        ComponentName componentName = new ComponentName(mContext, TodayInHistoryWidgetProvider.class);
        appWidgetManager.updateAppWidget(componentName, views);
    }

    @Override
    public void getError() {
        todayIsRunning = false;
    }

    @Override
    public void getBannerSuccess(String url) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(url)
                .placeholder(R.drawable.bg_default_banner)
                .error(R.drawable.bg_default_banner)
                .fallback(R.drawable.bg_default_banner)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        bannerIsRunning = false;
                        return true;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        updateBanner(resource);
                        bannerIsRunning = false;
                        return true;
                    }
                })
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    private void updateBanner(Bitmap resource) {
        if (resource == null) return;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_today_in_history_with_banner);
        views.setImageViewBitmap(R.id.image_view_banner, resource);
        Intent intent = new Intent(ACTION_REFRESH);
        PendingIntent refresh = PendingIntent.getBroadcast(mContext, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.image_view_banner, refresh);
        ComponentName componentName = new ComponentName(mContext, TodayInHistoryWidgetProvider.class);
        appWidgetManager.updateAppWidget(componentName, views);
    }

    @Override
    public void getBannerError() {
        bannerIsRunning = false;
    }

    public class RefreshReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals(ACTION_REFRESH)) {
                getToday();
                getBanner();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTodayInHistoryPresenter != null) {
            mTodayInHistoryPresenter.unsubscribe();
        }
        if (mBannerPresenter != null) {
            mBannerPresenter.unsubscribe();
        }
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        unregisterReceiver(mRefreshReceiver);
    }
}
