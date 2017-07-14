package g.star.iota.milk.ui.cosplayla.la;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class LaAdapter extends BaseAdapter<LaViewHolder, LaBean> {

    @Override
    public LaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((LaViewHolder) holder).bindView(mBeans.get(position));
    }
}
