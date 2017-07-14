package g.star.iota.milk.ui.main;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.base.RVBean;
import g.star.iota.milk.broadcast.NetStatusBroadcastReceiver;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.ui.download.DownloadManagerActivity;
import g.star.iota.milk.ui.menu.MenuCosplayFragment;
import g.star.iota.milk.ui.menu.MenuIllustrationFragment;
import g.star.iota.milk.ui.menu.MenuMeiziFragment;
import g.star.iota.milk.ui.menu.MenuPhotographyFragment;
import g.star.iota.milk.ui.moeimg.moe.MoeimgFragment;
import g.star.iota.milk.ui.more.MoreActivity;
import g.star.iota.milk.ui.settings.SettingsActivity;
import g.star.iota.milk.ui.theme.ThemeActivity;
import g.star.iota.milk.util.ConfigUtils;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    @BindView(R.id.frame_layout_fragment_container)
    FrameLayout mFrameLayoutFragmentContainer;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;


    private Drawer drawer;
    private NetStatusBroadcastReceiver mNetStatusBroadcastReceiver;

    private MainActivityPresenter mPresenter;

    private boolean isRunning;
    private TextView mTextViewHitokoto;
    private TextView mTextViewHitokotoSrc;
    private BaseFragment currentFragment;

    private void initNetBroadcastReceiver() {
        mNetStatusBroadcastReceiver = new NetStatusBroadcastReceiver();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetStatusBroadcastReceiver, mFilter);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initNetBroadcastReceiver();
        init();
        initDrawer();
        initDrawerEvent();
    }

    private void init() {
        setSupportActionBar(mToolbar);
        mPresenter = new MainActivityPresenter(this);
        isRunning = false;
    }

    @Override
    protected void setFirstFragment() {
        if (!ConfigUtils.getR(aContext)) {
            currentFragment = MoeimgFragment.newInstance(Contracts.Url.MOEIMG_H);
        } else {
            currentFragment = MoeimgFragment.newInstance(Contracts.Url.MOEIMG);
        }
        showFragment(currentFragment);
        setTitle(Contracts.Menu.MENU_MOEIMG);
    }

    private void initDrawer() {
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withItemAnimator(new LandingAnimator())
                .withHeader(R.layout.drawer_header_view)
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        if (isRunning) return;
                        isRunning = true;
                        mPresenter.get();
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                })
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_ILLUSTRATION).withIdentifier(Contracts.Menu.MENU_ILLUSTRATION_ID).withIcon(R.drawable.ic_menu_illustration).withSelectable(false),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_MEIZI).withIdentifier(Contracts.Menu.MENU_MEIZI_ID).withIcon(R.drawable.ic_menu_meizhi).withSelectable(false),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_COSPLAY).withIdentifier(Contracts.Menu.MENU_COSPLAY_ID).withIcon(R.drawable.ic_menu_cosplay).withSelectable(false),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_PHOTOGRAPHY).withIdentifier(Contracts.Menu.MENU_PHOTOGRAPHY_ID).withIcon(R.drawable.ic_menu_photography).withSelectable(false),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_THEME).withIdentifier(Contracts.Menu.MENU_THEME_ID).withIcon(R.drawable.ic_menu_theme).withSelectable(false),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_SETTINGS).withIdentifier(Contracts.Menu.MENU_SETTINGS_ID).withIcon(R.drawable.ic_menu_settings).withSelectable(false),
                        new PrimaryDrawerItem().withName(Contracts.Menu.MENU_ABOUT).withIdentifier(Contracts.Menu.MENU_ABOUT_ID).withIcon(R.drawable.ic_menu_more).withSelectable(false)
                )
                .withSelectedItem(-1)
                .build();
        View header = drawer.getHeader();
        KenBurnsView banner = header.findViewById(R.id.ken_burns_view_banner);
        GlideApp.with(mContext)
                .load(ConfigUtils.getBanner(aContext))
                .placeholder(R.drawable.bg_default_banner)
                .error(R.drawable.bg_default_banner)
                .fallback(R.drawable.bg_default_banner)
                .into(banner);
        mTextViewHitokoto = header.findViewById(R.id.text_view_hitokoto_bilibilijj);
        mTextViewHitokotoSrc = header.findViewById(R.id.text_view_hitokoto_source);
    }

    private void initDrawerEvent() {
        drawer.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem dItem) {
                switch ((int) dItem.getIdentifier()) {
                    case Contracts.Menu.MENU_THEME_ID:
                        startActivity(new Intent(mContext, ThemeActivity.class));
                        finish();
                        break;
                    case Contracts.Menu.MENU_SETTINGS_ID:
                        startActivity(new Intent(mContext, SettingsActivity.class));
                        break;
                    case Contracts.Menu.MENU_ABOUT_ID:
                        startActivity(new Intent(mContext, MoreActivity.class));
                        break;
                    case Contracts.Menu.MENU_ILLUSTRATION_ID:
                        currentFragment = new MenuIllustrationFragment();
                        setTitle(Contracts.Menu.MENU_ILLUSTRATION);
                        break;
                    case Contracts.Menu.MENU_MEIZI_ID:
                        currentFragment = new MenuMeiziFragment();
                        setTitle(Contracts.Menu.MENU_MEIZI);
                        break;
                    case Contracts.Menu.MENU_COSPLAY_ID:
                        currentFragment = new MenuCosplayFragment();
                        setTitle(Contracts.Menu.MENU_COSPLAY);
                        break;
                    case Contracts.Menu.MENU_PHOTOGRAPHY_ID:
                        currentFragment = new MenuPhotographyFragment();
                        setTitle(Contracts.Menu.MENU_PHOTOGRAPHY);
                        break;
                }
                showFragment(currentFragment);
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_download_manager:
                startActivity(new Intent(this, DownloadManagerActivity.class));
                break;
            case R.id.action_change_span_count:
                EventBus.getDefault().postSticky(new RVBean(true, false));
                break;
            case R.id.action_touch_to_top:
                EventBus.getDefault().postSticky(new RVBean(false, true));
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mNetStatusBroadcastReceiver != null) {
            unregisterReceiver(mNetStatusBroadcastReceiver);
        }
        if (mPresenter != null) {
            mPresenter.unsubscribe();
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.frame_layout_fragment_container;
    }

    @Override
    public void getSuccess(JuZiBean juzi) {
        bindHitokoto(juzi);
        isRunning = false;
    }

    private void bindHitokoto(JuZiBean bean) {
        mTextViewHitokoto.setText(bean.getHitokoto());
        if (mTextViewHitokoto.getLineCount() > 1) {
            mTextViewHitokoto.setText(String.format("\u3000\u3000%s", bean.getHitokoto()));
        }
        mTextViewHitokotoSrc.setText(bean.getSource());
    }

    @Override
    public void onBackPressed() {
        exit();
    }
}
