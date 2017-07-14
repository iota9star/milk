package g.star.iota.milk.ui.mzitu.mzi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MZITUAdapter extends BaseAdapter<MZITUViewHolder, MZITUBean> {

    @Override
    public MZITUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MZITUViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MZITUViewHolder) holder).bindView(mBeans.get(position));
    }
}
