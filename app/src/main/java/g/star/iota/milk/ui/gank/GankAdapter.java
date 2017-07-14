package g.star.iota.milk.ui.gank;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class GankAdapter extends BaseAdapter<GankViewHolder, GankBean.ResultsBean> {

    @Override
    public GankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GankViewHolder) holder).bindView(mBeans.get(position));
    }
}
