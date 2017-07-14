package g.star.iota.milk.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private View mContainerView;
    private Unbinder unbinder;
    protected Context mContext;
    protected Context aContext;

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    public void changeRecyclerViewSpanCount() {
    }

    public void scrollToTop() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aContext = getActivity().getApplicationContext();
        mContext = getActivity();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContainerView == null) {
            mContainerView = inflater.inflate(getLayoutId(), container, false);
        }
        unbinder = ButterKnife.bind(this, mContainerView);
        init(savedInstanceState);
        return mContainerView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dealEvent(RVBean rv) {
        if (rv.isChangeSpanCount()) {
            changeRecyclerViewSpanCount();
        }
        if (rv.isTouchToTop()) {
            scrollToTop();
        }
    }
}