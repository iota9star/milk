package g.star.iota.milk.ui.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;
import com.xw.repo.BubbleSeekBar;

import java.io.File;
import java.util.List;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.ui.lock.SetPinLockActivity;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.FileUtils;
import g.star.iota.milk.util.SnackbarUtils;

public class SettingsActivity extends BaseActivity {
    @BindView(R.id.text_view_interval_juzi)
    TextView mTextViewIntervalJuzi;
    @BindView(R.id.text_view_interval_today_in_history)
    TextView mTextViewIntervalTodayInHistory;
    @BindView(R.id.bubble_seek_bar_span_count)
    BubbleSeekBar mBubbleSeekBarSpanCount;
    @BindView(R.id.bubble_seek_bar_download_count)
    BubbleSeekBar mBubbleSeekBarDownloadCount;
    @BindView(R.id.text_view_rx)
    TextView mTextViewRx;
    @BindView(R.id.text_view_tx)
    TextView mTextViewTx;
    @BindView(R.id.text_view_cache_size)
    TextView mTextViewCacheSize;
    @BindView(R.id.text_view_open_count)
    TextView mTextViewOpenCount;
    @BindViews({R.id.image_view_delete_cache, R.id.image_view_fingerprint, R.id.image_view_pin, R.id.image_view_download, R.id.image_view_upload})
    List<ImageView> mImageViews;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @OnClick({R.id.linear_layout_juzi, R.id.linear_layout_today_in_history, R.id.linear_layout_open_count, R.id.linear_layout_cache, R.id.linear_layout_fingerprint_lock, R.id.linear_layout_pin_lock})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_layout_cache:
                clearCache();
                return;
            case R.id.linear_layout_open_count:
                SnackbarUtils.create(mContext, "清空历史打开次数", "嗯", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ConfigUtils.saveOpenCount(aContext, 0);
                    }
                });
                return;
            case R.id.linear_layout_juzi:
                final MaterialNumberPicker juzi = getNumberPicker(1);
                new AlertDialog.Builder(this)
                        .setTitle("刷新间隔（分钟）")
                        .setView(juzi)
                        .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int value = juzi.getValue();
                                ConfigUtils.saveJuziInterval(aContext, value);
                                bindJuziInterval(value);
                            }
                        })
                        .show();
                break;
            case R.id.linear_layout_today_in_history:
                final MaterialNumberPicker today = getNumberPicker(2);
                new AlertDialog.Builder(this)
                        .setTitle("刷新间隔（分钟）")
                        .setView(today)
                        .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int value = today.getValue();
                                ConfigUtils.saveTodayInHistroyInterval(aContext, value);
                                bindTodayInHistoryInterval(value);
                            }
                        })
                        .show();
                break;
            case R.id.linear_layout_pin_lock:
                if (ConfigUtils.isLock(aContext) != Contracts.LockType.PIN) {
                    startActivity(new Intent(mContext, SetPinLockActivity.class));
                } else {
                    new AlertDialog.Builder(mContext)
                            .setTitle("操作")
                            .setPositiveButton("关闭 PIN", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ConfigUtils.setLock(aContext, Contracts.LockType.NONE);
                                    ConfigUtils.savePin(aContext, "");
                                }
                            })
                            .setNegativeButton("重新设置", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(mContext, SetPinLockActivity.class));
                                }
                            })
                            .show();
                }
                return;
            case R.id.linear_layout_fingerprint_lock:
                if (ConfigUtils.isLock(aContext) == Contracts.LockType.NONE) {
                    SnackbarUtils.create(mContext, "请先设置至少一种解锁方式");
                    return;
                }
                FingerprintIdentify fingerprintIdentify = new FingerprintIdentify(mContext);
                if (!fingerprintIdentify.isHardwareEnable()) {
                    SnackbarUtils.create(mContext, "您的设备可能不支持指纹解锁");
                    return;
                }
                if (!fingerprintIdentify.isRegisteredFingerprint()) {
                    SnackbarUtils.create(mContext, "您可能还没有设置指纹，是否前往设置", "嗯", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(Settings.ACTION_SECURITY_SETTINGS));
                        }
                    });
                    return;
                }
                final boolean isOpen = ConfigUtils.isOpenFingerprint(aContext);
                new AlertDialog.Builder(mContext)
                        .setTitle(isOpen ? "关闭指纹识别支持" : "开启指纹识别支持")
                        .setPositiveButton("嗯", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (isOpen) {
                                    ConfigUtils.openFingerprint(aContext, false);
                                } else {
                                    ConfigUtils.openFingerprint(aContext, true);
                                }
                            }
                        })
                        .show();
                return;
        }
    }

    private MaterialNumberPicker getNumberPicker(int type) {
        TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        return new MaterialNumberPicker.Builder(mContext)
                .minValue(1)
                .maxValue(Integer.MAX_VALUE)
                .defaultValue(type == 1 ? ConfigUtils.getJuziInterval(aContext) : ConfigUtils.getTodayInHistroyInterval(aContext))
                .separatorColor(typedValue.data)
                .textColor(typedValue.data)
                .textSize(20)
                .enableFocusability(true)
                .wrapSelectorWheel(true)
                .build();
    }

    private void clearCache() {
        SnackbarUtils.create(mContext, "清空缓存", "嗯", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File cacheDir = mContext.getExternalCacheDir();
                if (cacheDir != null && cacheDir.exists() && cacheDir.isDirectory()) {
                    if (!FileUtils.deleteDirsFiles(cacheDir)) {
                        SnackbarUtils.create(mContext, "已清空");
                    } else {
                        SnackbarUtils.create(mContext, "可能部分缓存文件未被清除，请稍后再试");
                    }
                }
                bindCacheSize();
            }
        });
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mBubbleSeekBarSpanCount.setProgress(ConfigUtils.getSpanCountConfig(aContext));
        mBubbleSeekBarSpanCount.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                ConfigUtils.saveSpanCountConfig(mContext, progress);
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });
        mBubbleSeekBarDownloadCount.setProgress(ConfigUtils.getDownloadCountConfig(aContext));
        mBubbleSeekBarDownloadCount.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int i, float v) {
                ConfigUtils.saveDownloadCountConfig(mContext, i);
            }

            @Override
            public void getProgressOnActionUp(int i, float v) {

            }

            @Override
            public void getProgressOnFinally(int i, float v) {

            }
        });
        bindTrafficInfo();
        bindCacheSize();
        bindOpenCount();
        setTintToImageViews(mImageViews);
        bindJuziInterval(ConfigUtils.getJuziInterval(aContext));
        bindTodayInHistoryInterval(ConfigUtils.getTodayInHistroyInterval(aContext));
    }

    private void bindTodayInHistoryInterval(int todayInHistroyInterval) {
        mTextViewIntervalTodayInHistory.setText(intervalDeal(todayInHistroyInterval));
    }

    private void bindJuziInterval(int juziInterval) {
        mTextViewIntervalJuzi.setText(intervalDeal(juziInterval));
    }

    private String intervalDeal(int minutes) {
        int hour = 60;
        int day = hour * 24;
        Log.i("value", "intervalDeal: " + minutes / day + ":" + minutes / hour + ":" + minutes);
        if (minutes / day >= 1) {
            int d = minutes / day;
            int d_rem = minutes % day;
            if (d_rem == 0) return d + "天";
            if (d_rem / hour >= 1) {
                int h = d_rem / hour;
                int h_rem = minutes % hour;
                if (h_rem == 0) {
                    return d + "天" + h + "小时";
                } else {
                    return d + "天" + h + "小时" + h_rem + "分钟";
                }
            } else {
                return d + "天" + d_rem + "分钟";
            }
        }
        if (minutes / hour >= 1) {
            int h = minutes / hour;
            int h_rem = minutes % hour;
            if (h_rem == 0) {
                return h + "小时";
            } else {
                return h + "小时" + h_rem + "分钟";
            }
        }
        return minutes + "分钟";
    }

    private void bindOpenCount() {
        mTextViewOpenCount.setText(String.format("%s 次", String.valueOf(ConfigUtils.getOpenCount(aContext))));
    }

    private void bindCacheSize() {
        File cacheDir = mContext.getExternalCacheDir();
        if (cacheDir != null && cacheDir.exists() && cacheDir.isDirectory()) {
            mTextViewCacheSize.setText(FileUtils.getFileSize(FileUtils.getFolderSize(cacheDir)));
        }
    }

    private void setTintToImageViews(List<ImageView> views) {
        for (ImageView view : views) {
            setTintToImageView(view);
        }
    }

    private void setTintToImageView(ImageView view) {
        Drawable modeDrawable = view.getDrawable().mutate();
        Drawable temp = DrawableCompat.wrap(modeDrawable);
        TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        ColorStateList colorStateList = ColorStateList.valueOf(typedValue.data);
        DrawableCompat.setTintList(temp, colorStateList);
        view.setImageDrawable(temp);
    }

    private void bindTrafficInfo() {
        try {
            ApplicationInfo applicationInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
            int uid = applicationInfo.uid;
            long uidRxBytes = TrafficStats.getUidRxBytes(uid);
            long uidTxBytes = TrafficStats.getUidTxBytes(uid);
            mTextViewRx.setText(FileUtils.getFileSize(uidRxBytes));
            mTextViewTx.setText(FileUtils.getFileSize(uidTxBytes));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_settings;
    }

}
