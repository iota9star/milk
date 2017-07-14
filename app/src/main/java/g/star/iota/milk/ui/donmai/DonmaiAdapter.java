package g.star.iota.milk.ui.donmai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class DonmaiAdapter extends BaseAdapter<DonmaiViewHolder, DonmaiBean> {

    @Override
    public DonmaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DonmaiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booru, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DonmaiViewHolder) holder).bindView(mBeans.get(position));
    }
}
