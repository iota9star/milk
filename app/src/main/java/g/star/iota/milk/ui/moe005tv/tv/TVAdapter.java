package g.star.iota.milk.ui.moe005tv.tv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class TVAdapter extends BaseAdapter<TVViewHolder, TVBean> {

    @Override
    public TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TVViewHolder) holder).bindView(mBeans.get(position));
    }
}
