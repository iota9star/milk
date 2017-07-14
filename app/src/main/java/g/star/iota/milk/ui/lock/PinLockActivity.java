package g.star.iota.milk.ui.lock;

import android.content.Intent;
import android.os.Bundle;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;
import com.wei.android.lib.fingerprintidentify.base.BaseFingerprint;

import butterknife.BindView;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.ui.main.MainActivity;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.SnackbarUtils;

public class PinLockActivity extends BaseActivity {

    @BindView(R.id.pin_lock_view)
    PinLockView mPinLockView;
    @BindView(R.id.indicator_dots)
    IndicatorDots mIndicatorDots;

    private int mErrorTimes = 0;

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initEvent();
        initFingerprint();
    }

    private void initFingerprint() {
        if (!ConfigUtils.isOpenFingerprint(aContext)) return;
        FingerprintIdentify fingerprintIdentify = new FingerprintIdentify(mContext);
        if (!fingerprintIdentify.isFingerprintEnable()) return;
        fingerprintIdentify.startIdentify(3, new BaseFingerprint.FingerprintIdentifyListener() {
            @Override
            public void onSucceed() {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }

            @Override
            public void onNotMatch(int availableTimes) {
                SnackbarUtils.create(mContext, "指纹识别失败，你还有" + availableTimes + "次机会");
            }

            @Override
            public void onFailed() {
                finish();
            }
        });

    }

    private void initEvent() {
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                if (ConfigUtils.getPin(aContext).equals(pin)) {
                    startActivity(new Intent(mContext, MainActivity.class));
                    finish();
                } else {
                    mPinLockView.resetPinLockView();
                    mErrorTimes++;
                    if (mErrorTimes == 3) {
                        finish();
                    }
                    SnackbarUtils.create(mContext, "解锁失败，你还有" + (3 - mErrorTimes) + "次输入机会");
                }
            }

            @Override
            public void onEmpty() {

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {

            }
        });
    }

    private void initView() {
        mIndicatorDots.setIndicatorType(IndicatorDots.IndicatorType.FILL_WITH_ANIMATION);
        mPinLockView.attachIndicatorDots(mIndicatorDots);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_pin_lock;
    }
}
