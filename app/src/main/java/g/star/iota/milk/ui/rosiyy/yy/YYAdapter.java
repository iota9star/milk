package g.star.iota.milk.ui.rosiyy.yy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class YYAdapter extends BaseAdapter<YYViewHolder, YYBean> {

    @Override
    public YYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YYViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YYViewHolder) holder).bindView(mBeans.get(position));
    }
}
