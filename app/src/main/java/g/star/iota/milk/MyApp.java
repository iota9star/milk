package g.star.iota.milk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okserver.OkDownload;
import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.CrashUtils;
import g.star.iota.milk.util.FileUtils;
import g.star.iota.milk.util.Utils;
import okhttp3.OkHttpClient;


public class MyApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LeakCanary.install(this);
        Utils.init(this);
        CrashUtils.init(FileUtils.getDownloadDir() + "Log");
        initOkGo();
        addCount();
    }

    private void addCount() {
        long openCount = ConfigUtils.getOpenCount(this);
        openCount++;
        ConfigUtils.saveOpenCount(this, openCount);
    }

    private void initOkGo() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.1.2716.5 Safari/537.36");
        OkGo.getInstance().init(this)
                .setOkHttpClient(makeOkHttpClient())
                .setCacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(3)
                .addCommonHeaders(headers);
        OkDownload.getInstance().getThreadPool().setCorePoolSize(ConfigUtils.getDownloadCountConfig(this));
    }

    public static OkHttpClient makeOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(mContext)));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        return builder.build();
    }
}
