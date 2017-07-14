package g.star.iota.milk.ui.magmoe.moe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MoeAdapter extends BaseAdapter<MoeViewHolder, MoeBean> {

    @Override
    public MoeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MoeViewHolder) holder).bindView(mBeans.get(position));
    }
}
