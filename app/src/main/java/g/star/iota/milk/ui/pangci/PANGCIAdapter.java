package g.star.iota.milk.ui.pangci;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class PANGCIAdapter extends BaseAdapter<PANGCIViewHolder, PANGCIBean> {

    @Override
    public PANGCIViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PANGCIViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PANGCIViewHolder) holder).bindView(mBeans.get(position));
    }
}
