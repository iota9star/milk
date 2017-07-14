package g.star.iota.milk.ui.lock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;

import butterknife.BindView;
import butterknife.OnClick;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.util.ConfigUtils;
import g.star.iota.milk.util.SnackbarUtils;


public class SetPinLockActivity extends BaseActivity {

    @BindView(R.id.pin_lock_view)
    PinLockView mPinLockView;
    @BindView(R.id.indicator_dots)
    IndicatorDots mIndicatorDots;
    @BindView(R.id.button_left)
    Button mButtonLeft;
    @BindView(R.id.button_right)
    Button mButtonRight;

    @OnClick({R.id.button_left, R.id.button_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_left:
                if (mStep == STEP_ONE) {
                    finish();
                } else if (mStep == STEP_TWO) {
                    mPinLockView.resetPinLockView();
                    mButtonRight.setVisibility(View.GONE);
                    mButtonLeft.setText(R.string.wait_inut);
                }
                break;
            case R.id.button_right:
                if (mStep == STEP_ONE) {
                    mStep = STEP_TWO;
                    mPinLockView.resetPinLockView();
                    mButtonRight.setVisibility(View.GONE);
                    mButtonLeft.setText(R.string.wait_inut);
                } else if (mStep == STEP_TWO) {
                    ConfigUtils.savePin(aContext, mPinCode);
                    ConfigUtils.setLock(aContext, Contracts.LockType.PIN);
                    finish();
                }
                break;
        }
    }

    private static final int STEP_ONE = 1;
    private static final int STEP_TWO = 2;
    private int mStep = STEP_ONE;

    private String mPinCode;

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        initEvent();
    }

    private void initEvent() {
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                if (mStep == STEP_ONE) {
                    mPinCode = pin;
                    mButtonRight.setText(R.string.continue_str);
                    mButtonRight.setVisibility(View.VISIBLE);
                } else if (mStep == STEP_TWO) {
                    if (mPinCode.equals(pin)) {
                        mButtonRight.setText(R.string.finished);
                        mButtonRight.setVisibility(View.VISIBLE);
                    } else {
                        SnackbarUtils.create(mContext, "前后不一致");
                        mPinLockView.resetPinLockView();
                        mButtonRight.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onEmpty() {

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                if (pinLength < mPinLockView.getPinLength()) {
                    mButtonRight.setVisibility(View.GONE);
                }
                if (pinLength == 0) {
                    if (mStep == STEP_ONE) {
                        mButtonLeft.setText(R.string.cancel);
                    } else if (mStep == STEP_TWO) {
                        mButtonLeft.setText(R.string.wait_inut);
                    }
                } else {
                    if (STEP_ONE == mStep) {
                        mButtonLeft.setText(R.string.cancel);
                        mButtonRight.setText(R.string.continue_str);
                    } else if (STEP_TWO == mStep) {
                        mButtonLeft.setText(R.string.reinput);
                        mButtonRight.setText(R.string.finished);
                    }
                }
            }
        });
    }

    private void initView() {
        mIndicatorDots.setIndicatorType(IndicatorDots.IndicatorType.FILL_WITH_ANIMATION);
        mPinLockView.attachIndicatorDots(mIndicatorDots);
        mButtonRight.setVisibility(View.GONE);
        mButtonLeft.setText(R.string.cancel);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_set_pin_lock;
    }

    @Override
    public void onBackPressed() {
        if (mStep == STEP_ONE) {
            finish();
        } else if (mStep == STEP_TWO) {
            mStep = STEP_ONE;
            mPinCode = "";
            mPinLockView.resetPinLockView();
            mButtonRight.setVisibility(View.GONE);
            mButtonLeft.setText(R.string.cancel);
        }
    }
}
