package g.star.iota.milk.ui.nijieroch.nijiero;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class NijieroCHAdapter extends BaseAdapter<NijieroCHViewHolder, NijieroCHBean> {

    @Override
    public NijieroCHViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NijieroCHViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NijieroCHViewHolder) holder).bindView(mBeans.get(position));
    }
}
