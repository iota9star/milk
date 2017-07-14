package g.star.iota.milk.ui.magmoe.mag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MagAdapter extends BaseAdapter<MagViewHolder, MagBean> {

    @Override
    public MagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MagViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_with_subtitle, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MagViewHolder) holder).bindView(mBeans.get(position));
    }
}
