package g.star.iota.milk.ui.mmonly.mm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MMONLYAdapter extends BaseAdapter<MMONLYViewHolder, MMONLYBean> {

    @Override
    public MMONLYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MMONLYViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MMONLYViewHolder) holder).bindView(mBeans.get(position));
    }
}
