package g.star.iota.milk.ui.bcy.ing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class IngAdapter extends BaseAdapter<IngViewHolder, IngBean> {

    @Override
    public IngViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IngViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((IngViewHolder) holder).bindView(mBeans.get(position));
    }
}
