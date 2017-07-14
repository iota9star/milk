package g.star.iota.milk.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.CookieStore;

import butterknife.BindView;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.util.SnackbarUtils;
import okhttp3.Cookie;
import okhttp3.HttpUrl;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Override
    protected void init(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void handleIntent(Intent intent) {
        String loginUrl = intent.getStringExtra("login_url");
        if (loginUrl == null || loginUrl.length() < 5) {
            SnackbarUtils.create(mContext, "数据接收有误，请返回重试？");
            return;
        }
        initWebView(loginUrl);
    }

    private void initWebView(String baseUrl) {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setSupportZoom(true);
        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        };
        mWebView.setWebChromeClient(webChromeClient);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://") || url.startsWith("https://"))
                    try {
                        view.loadUrl(url);
                    } catch (Exception e) {
                        SnackbarUtils.create(mContext, "网页加载错误？");
                    }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                CookieManager cookieManager = CookieManager.getInstance();
                String cookies = cookieManager.getCookie(url).trim().replaceAll(" ", "");
                String[] cookiesArr = cookies.split(";");
                HttpUrl httpUrl = HttpUrl.parse(url);
                CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
                Cookie.Builder builder = new Cookie.Builder();
                for (String val : cookiesArr) {
                    String[] c = val.split("=");
                    if (httpUrl != null && c.length == 2) {
                        Cookie cookie = builder.name(c[0]).value(c[1]).domain(httpUrl.host()).build();
                        cookieStore.saveCookie(httpUrl, cookie);
                    }
                }
            }
        });
        try {
            mWebView.loadUrl(baseUrl);
        } catch (Exception e) {
            SnackbarUtils.create(mContext, "加载网址错误？");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_web_login;
    }
}
