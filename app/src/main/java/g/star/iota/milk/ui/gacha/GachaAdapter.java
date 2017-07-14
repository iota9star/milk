package g.star.iota.milk.ui.gacha;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class GachaAdapter extends BaseAdapter<GachaViewHolder, GachaBean> {

    @Override
    public GachaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GachaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gacha, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GachaViewHolder) holder).bindView(mBeans.get(position));
    }
}
