package g.star.iota.milk.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import g.star.iota.milk.util.ConfigUtils;

public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder unbinder;

    protected Context mContext;
    protected Context aContext;

    protected void handleIntent(Intent intent) {

    }

    private void setScreen() {
        if (setFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    protected void setTheme() {
        int theme = ConfigUtils.getTheme(getApplicationContext());
        this.setTheme(theme);
    }

    protected abstract void init(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme();
        setScreen();
        setContentView(getContentViewId());
        aContext = getApplicationContext();
        mContext = this;
        unbinder = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        init(savedInstanceState);
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        setFirstFragment();
    }

    protected boolean setFullScreen() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected abstract int getContentViewId();

    protected int getFragmentContainerId() {
        return 0;
    }

    protected void setFirstFragment() {

    }

    public void showFragment(BaseFragment fragment) {
        if (fragment != null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction tx = fm.beginTransaction();
            tx.replace(getFragmentContainerId(), fragment);
            tx.commit();
        }
    }

    public void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(getFragmentContainerId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    protected void exit() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            Snackbar.make(findViewById(android.R.id.content), "真的要退出了吗", Snackbar.LENGTH_LONG)
                    .setAction("EXIT", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            System.exit(0);
                        }
                    })
                    .show();
        }
    }

    public void removeFragmentContainerChildrenViews() {
        ((ViewGroup) findViewById(getFragmentContainerId())).removeAllViews();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dealEvent(RVBean rv) {
    }
}
