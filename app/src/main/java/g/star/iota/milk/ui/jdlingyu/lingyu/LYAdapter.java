package g.star.iota.milk.ui.jdlingyu.lingyu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class LYAdapter extends BaseAdapter<LYViewHolder, LYBean> {

    @Override
    public LYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LYViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((LYViewHolder) holder).bindView(mBeans.get(position));
    }
}
