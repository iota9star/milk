package g.star.iota.milk.ui.xiuren.ren;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class RenAdapter extends BaseAdapter<RenViewHolder, RenBean> {

    @Override
    public RenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RenViewHolder) holder).bindView(mBeans.get(position));
    }
}
