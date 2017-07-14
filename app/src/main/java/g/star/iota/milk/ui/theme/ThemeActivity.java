package g.star.iota.milk.ui.theme;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.ui.main.MainActivity;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.SnackbarUtils;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

public class ThemeActivity extends BaseActivity {

    @BindView(R.id.ken_burns_view_banner)
    KenBurnsView mKenBurnsViewBanner;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.button_set)
    Button mButtonSet;
    @BindView(R.id.edit_text_url)
    EditText mEditTextUrl;

    @OnClick(R.id.button_set)
    public void onClick() {
        String url = mEditTextUrl.getText().toString().trim().replace(" ", "");
        if (url.length() > 5) {
            ConfigUtils.saveBanner(aContext, url);
            SnackbarUtils.create(this, "已保存地址");
            loadBanner(url);
        } else {
            SnackbarUtils.create(this, "地址太短了吧");
        }
    }

    private void loadBanner(String url) {
        if (url.length() > 5) {
            GlideApp.with(mContext)
                    .load(url)
                    .dontAnimate()
//                    .listener(new RequestListener<Drawable>() {
//                        @Override
//                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                            SnackbarUtils.create(ThemeActivity.this, "无法加载BANNER图片，请确保地址的正确性以及图片大小的合适性");
//                            return true;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            return true;
//                        }
//                    })
                    .placeholder(R.drawable.bg_default_banner)
                    .error(R.drawable.bg_default_banner)
                    .fallback(R.drawable.bg_default_banner)
                    .into(mKenBurnsViewBanner);
        }
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        init();
        initRecyclerView();
        loadBanner(ConfigUtils.getBanner(aContext));
    }

    private void initRecyclerView() {
        mRecyclerView.setItemAnimator(new LandingAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ThemeAdapter adapter = new ThemeAdapter();
        mRecyclerView.setAdapter(adapter);
        adapter.add(initTheme());
    }

    private List<ThemeBean> initTheme() {
        List<ThemeBean> themes = new ArrayList<>();
        themes.add(new ThemeBean(R.style.ThemeRed, R.color.ThemeRed, "红色/Red", false));
        themes.add(new ThemeBean(R.style.ThemePink, R.color.ThemePink, "粉色/Pink", false));
        themes.add(new ThemeBean(R.style.ThemePurple, R.color.ThemePurple, "紫色/Purple", false));
        themes.add(new ThemeBean(R.style.ThemeDeepPurple, R.color.ThemeDeepPurple, "深紫/Deep Purple", false));
        themes.add(new ThemeBean(R.style.ThemeIndigo, R.color.ThemeIndigo, "靛蓝/Indigo", false));
        themes.add(new ThemeBean(R.style.ThemeBlue, R.color.ThemeBlue, "蓝色/Blue", false));
        themes.add(new ThemeBean(R.style.ThemeLightBlue, R.color.ThemeLightBlue, "亮蓝/Light Blue", false));
        themes.add(new ThemeBean(R.style.ThemeCyan, R.color.ThemeCyan, "青色/Cyan", false));
        themes.add(new ThemeBean(R.style.ThemeTeal, R.color.ThemeTeal, "鸭绿/Teal", false));
        themes.add(new ThemeBean(R.style.ThemeGreen, R.color.ThemeGreen, "绿色/Green", false));
        themes.add(new ThemeBean(R.style.ThemeLightGreen, R.color.ThemeLightGreen, "亮绿/Light Green", false));
        themes.add(new ThemeBean(R.style.ThemeLime, R.color.ThemeLime, "酸橙/Lime", false));
        themes.add(new ThemeBean(R.style.ThemeYellow, R.color.ThemeYellow, "黄色/Yellow", false));
        themes.add(new ThemeBean(R.style.ThemeAmber, R.color.ThemeAmber, "琥珀/Amber", false));
        themes.add(new ThemeBean(R.style.ThemeOrange, R.color.ThemeOrange, "橙色/Orange", false));
        themes.add(new ThemeBean(R.style.ThemeDeepOrange, R.color.ThemeDeepOrange, "暗橙/DeepOrange", false));
        themes.add(new ThemeBean(R.style.ThemeBrown, R.color.ThemeBrown, "棕色/Brown", false));
        themes.add(new ThemeBean(R.style.ThemeGrey, R.color.ThemeGrey, "灰色/Grey", false));
        themes.add(new ThemeBean(R.style.ThemeBlueGrey, R.color.ThemeBlueGrey, "蓝灰/Blue Grey", false));
        themes.add(new ThemeBean(R.style.ThemeBiliBili, R.color.ThemeBiliBili, "哔哩哔哩/BiliBili", false));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            themes.add(new ThemeBean(R.style.ThemeBlack, R.color.ThemeBlack, "黑色/Black", false));
        }
        themes.add(new ThemeBean(R.style.ThemeDarkBlack, R.color.ThemeDarkBlack, "夜间/Night", false));

        for (ThemeBean theme : themes) {
            if (theme.getTheme() == ConfigUtils.getTheme(aContext)) {
                theme.setSelected(true);
            }
        }
        return themes;
    }

    private void init() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_theme;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
