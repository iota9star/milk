package g.star.iota.milk.ui.lingyu.yu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class YuAdapter extends BaseAdapter<YuViewHolder, YuBean> {

    @Override
    public YuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YuViewHolder) holder).bindView(mBeans.get(position));
    }
}
