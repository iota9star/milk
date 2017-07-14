package g.star.iota.milk.ui.rosiyy.rosi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class ROSIYYAdapter extends BaseAdapter<ROSIYYViewHolder, ROSIYYBean> {

    @Override
    public ROSIYYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ROSIYYViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ROSIYYViewHolder) holder).bindView(mBeans.get(position));
    }
}
