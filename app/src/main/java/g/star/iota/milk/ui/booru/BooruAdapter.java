package g.star.iota.milk.ui.booru;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class BooruAdapter extends BaseAdapter<BooruViewHolder, BooruBean> {

    @Override
    public BooruViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BooruViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booru, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BooruViewHolder) holder).bindView(mBeans.get(position));
    }
}
