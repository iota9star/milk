package g.star.iota.milk.ui.gamersky.sky;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class SkyAdapter extends BaseAdapter<SkyViewHolder, SkyBean> {

    @Override
    public SkyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SkyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SkyViewHolder) holder).bindView(mBeans.get(position));
    }
}
