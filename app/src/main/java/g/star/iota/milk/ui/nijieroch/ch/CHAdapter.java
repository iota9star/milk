package g.star.iota.milk.ui.nijieroch.ch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class CHAdapter extends BaseAdapter<CHViewHolder, CHBean> {

    @Override
    public CHViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CHViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CHViewHolder) holder).bindView(mBeans.get(position));
    }
}
