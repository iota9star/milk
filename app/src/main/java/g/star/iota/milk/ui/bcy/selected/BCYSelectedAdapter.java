package g.star.iota.milk.ui.bcy.selected;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class BCYSelectedAdapter extends BaseAdapter<BCYSelectedViewHolder, BCYSelectedBean> {

    @Override
    public BCYSelectedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BCYSelectedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bcy_selected, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BCYSelectedViewHolder) holder).bindView(mBeans.get(position));
    }
}
