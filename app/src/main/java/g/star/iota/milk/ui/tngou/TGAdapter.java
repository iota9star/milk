package g.star.iota.milk.ui.tngou;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class TGAdapter extends BaseAdapter<TGViewHolder, TGBean.TngouBean> {

    @Override
    public TGViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TGViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TGViewHolder) holder).bindView(mBeans.get(position));
    }
}
