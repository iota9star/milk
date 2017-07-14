package g.star.iota.milk.ui.moe005tv.moe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MOE005TVAdapter extends BaseAdapter<MOE005TVViewHolder, MOE005TVBean> {

    @Override
    public MOE005TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MOE005TVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MOE005TVViewHolder) holder).bindView(mBeans.get(position));
    }
}
