package g.star.iota.milk.ui.splash;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.ui.lock.PinLockActivity;
import g.star.iota.milk.ui.main.MainActivity;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.SnackbarUtils;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;
    @BindView(R.id.text_view_event)
    TextView mTextViewEvent;
    @BindView(R.id.text_view_year)
    TextView mTextViewYear;
    @BindView(R.id.text_view_day)
    TextView mTextViewDay;
    @BindView(R.id.linear_layout_history)
    LinearLayout mLinearLayoutHistoryContainer;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @OnClick({R.id.button_go})
    public void onClick() {
        go();
    }

    private void go() {
        if (ConfigUtils.isLock(aContext) == Contracts.LockType.PIN) {
            startActivity(new Intent(mContext, PinLockActivity.class));
        } else if (ConfigUtils.isLock(aContext) == Contracts.LockType.NONE) {
            startActivity(new Intent(mContext, MainActivity.class));
        }
        finish();
    }

    private SplashPresenter mPresenter;

    @Override
    protected void init(Bundle savedInstanceState) {
        mPresenter = new SplashPresenter(this);
        mPresenter.getImage();
    }

    private void bindPalette(Palette.Swatch swatch) {
        mLinearLayoutHistoryContainer.setBackgroundColor(swatch.getRgb());
        mTextViewDay.setTextColor(swatch.getTitleTextColor());
        mTextViewYear.setTextColor(swatch.getTitleTextColor());
        mTextViewEvent.setTextColor(swatch.getBodyTextColor());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean setFullScreen() {
        return true;
    }

    @Override
    public void getSuccess(HistoryBean bean) {
        if (bean.getYear().trim().replace(" ", "").length() > 3) {
            mLinearLayoutHistoryContainer.setVisibility(View.VISIBLE);
            mTextViewYear.setText(bean.getYear());
            mTextViewDay.setText(bean.getDay());
            mTextViewEvent.setText(bean.getEvent());
            if (mTextViewEvent.getLineCount() > 1) {
                mTextViewEvent.setText(String.format("\u3000\u3000%s", bean.getEvent()));
            }
        }
        endSplash();
    }

    private void endSplash() {
        ObjectAnimator.ofFloat(mImageViewImage, "scaleX", 1f, 1.6f).setDuration(3000).start();
        ObjectAnimator.ofFloat(mImageViewImage, "scaleY", 1f, 1.6f).setDuration(3000).start();
        mImageViewImage.postDelayed(new Runnable() {
            @Override
            public void run() {
                go();
            }
        }, 3600);
    }

    @Override
    public void getSuccess(String url) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(url)
                .transition(withCrossFade())
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Bitmap> target, boolean isFirstResource) {
                        if (e != null) {
                            SnackbarUtils.create(mContext, e.getMessage());
                        }
                        endSplash();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target,
                                                   DataSource dataSource, boolean isFirstResource) {
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                List<Palette.Swatch> swatches = palette.getSwatches();
                                for (Palette.Swatch s : swatches) {
                                    if (s != null) {
                                        bindPalette(s);
                                        return;
                                    }
                                }
                            }
                        });
                        mProgressBar.setVisibility(View.GONE);
                        mPresenter.getHistory();
                        return false;
                    }
                })
                .into(mImageViewImage);
    }

    @Override
    public void getError(String error) {
        SnackbarUtils.create(mContext, error);
        endSplash();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unsubscribe();
        }
    }
}
