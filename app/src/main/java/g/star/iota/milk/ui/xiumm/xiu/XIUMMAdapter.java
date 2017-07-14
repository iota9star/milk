package g.star.iota.milk.ui.xiumm.xiu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class XIUMMAdapter extends BaseAdapter<XIUMMViewHolder, XIUMMBean> {

    @Override
    public XIUMMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new XIUMMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((XIUMMViewHolder) holder).bindView(mBeans.get(position));
    }
}
