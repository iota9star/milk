package g.star.iota.milk.ui.watch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;
import com.john.waveview.WaveView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadListener;
import com.lzy.okserver.download.DownloadTask;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import butterknife.BindView;
import butterknife.OnClick;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.util.FileUtils;
import g.star.iota.milk.util.SnackbarUtils;


public class WatchActivity extends BaseActivity {

    @BindView(R.id.button_download)
    Button mButtonDownload;
    @BindView(R.id.photo_view_image)
    PhotoView mPhotoViewImage;
    @BindView(R.id.wave_view_loading)
    WaveView mWaveViewLoading;
    @BindView(R.id.text_view_progress)
    TextView mTextViewProgress;
    @BindView(R.id.frame_layout_progress)
    FrameLayout mFrameLayoutProgress;
    @BindView(R.id.linear_layout_bottom_sheet)
    LinearLayout mLinearLayoutBottomSheet;
    @BindView(R.id.image_view_indicator)
    ImageView mImageViewIndicator;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.scroll_view_container)
    ScrollView mScrollViewContainer;

    private BottomSheetBehavior<LinearLayout> mBehavior;
    private DownloadListener mDownloadListener;
    private DownloadTask mDownloadTask;
    private boolean isDownload;
    private boolean isClick;
    private OkDownload mOkDownload;
    private String mTag;


    private void exchangeBehavior() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        init();
    }

    @OnClick({R.id.button_download, R.id.image_view_indicator})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_download:
                isClick = true;
                mButtonDownload.setEnabled(false);
                mButtonDownload.setClickable(false);
                mButtonDownload.setText("正在下载");
                break;
            case R.id.image_view_indicator:
                exchangeBehavior();
                break;
        }
    }

    private void init() {
        mContext = WatchActivity.this;
        isClick = false;
        mBehavior = BottomSheetBehavior.from(mLinearLayoutBottomSheet);
        mOkDownload = OkDownload.getInstance();
        mTag = UUID.randomUUID().toString();
    }

    @Override
    protected boolean setFullScreen() {
        return true;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_watch;
    }

    @Override
    protected void handleIntent(Intent intent) {
        String description = intent.getStringExtra("image_description");
        String url = intent.getStringExtra("image_url");
        String preview = intent.getStringExtra("image_preview");
        String folder = intent.getStringExtra("image_source");
        Map<String, String> headers = (Map<String, String>) intent.getSerializableExtra("request_headers");
        mTextViewDescription.setText(description);
        mDownloadListener = new DownloadListener(mTag) {
            @Override
            public void onStart(Progress progress) {

            }

            @Override
            public void onProgress(Progress progress) {
                mWaveViewLoading.setProgress(100 - (int) (progress.fraction * 100));
                mTextViewProgress.setText(String.valueOf((int) (progress.fraction * 100) + " %"));
            }

            @Override
            public void onError(Progress progress) {

            }

            @Override
            public void onFinish(final File file, Progress progress) {
                mFrameLayoutProgress.setVisibility(View.GONE);
                if (isClick) {
                    mButtonDownload.setText("已下载");
                }
                if (file != null && file.exists()) {
                    GlideApp.with(mContext)
                            .asBitmap()
                            .load(file)
                            .dontAnimate()
                            .listener(new RequestListener<Bitmap>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                    if (e != null) {
                                        SnackbarUtils.create(mContext, e.getMessage());
                                    }
                                    GlideApp.with(mContext)
                                            .load(file)
                                            .dontAnimate()
                                            .into(mPhotoViewImage);
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                                    mPhotoViewImage.setImageBitmap(bitmap);
                                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                        @Override
                                        public void onGenerated(Palette palette) {
                                            showInfo(palette);
                                        }
                                    });
                                    return false;
                                }
                            })
                            .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                }
            }

            @Override
            public void onRemove(Progress progress) {

            }
        };
        if (mOkDownload.hasTask(url)) {
            if (isClick) {
                mButtonDownload.setText("正在下载");
            }
            mDownloadTask = mOkDownload.getTask(url);
            mDownloadTask.start();
        } else {
            GetRequest<File> request = OkGo.<File>get(url);
            if (headers != null) {
                for (Map.Entry<String, String> val : headers.entrySet()) {
                    request.headers(val.getKey(), val.getValue());
                }
            }
            mDownloadTask = OkDownload.request(url, request)
                    .extra1(preview)
                    .extra2(folder)
                    .folder(FileUtils.getDownloadDir() + folder)
                    .save();
            mDownloadTask.start();
        }
        mDownloadTask.register(mDownloadListener);
    }

    @Override
    protected void onResume() {
        mDownloadTask.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (mDownloadListener != null) {
            mDownloadTask.unRegister(mDownloadListener);
        }
        if (!isDownload) {
            mDownloadTask.remove(true);
        }
        super.onDestroy();
    }

    private void showInfo(Palette palette) {
        List<Palette.Swatch> swatches = palette.getSwatches();
        if (swatches.size() > 0) {
            for (Palette.Swatch swatch : swatches) {
                if (swatch != null) {
                    mTextViewDescription.setTextColor(swatch.getBodyTextColor());
                    mScrollViewContainer.setBackgroundColor(swatch.getRgb());
                    return;
                }
            }
        }
    }

}
