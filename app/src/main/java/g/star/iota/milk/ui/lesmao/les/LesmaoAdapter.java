package g.star.iota.milk.ui.lesmao.les;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class LesmaoAdapter extends BaseAdapter<LesmaoViewHolder, LesmaoBean> {

    @Override
    public LesmaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LesmaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((LesmaoViewHolder) holder).bindView(mBeans.get(position));
    }
}
