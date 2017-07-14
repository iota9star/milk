package g.star.iota.milk.ui.wallhaven.haven;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class HavenAdapter extends BaseAdapter<HavenViewHolder, HavenBean> {

    @Override
    public HavenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HavenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HavenViewHolder) holder).bindView(mBeans.get(position));
    }
}
