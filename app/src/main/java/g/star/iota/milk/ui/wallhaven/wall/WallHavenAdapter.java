package g.star.iota.milk.ui.wallhaven.wall;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class WallHavenAdapter extends BaseAdapter<WallHavenViewHolder, WallHavenBean> {

    @Override
    public WallHavenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WallHavenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WallHavenViewHolder) holder).bindView(mBeans.get(position));
    }
}
