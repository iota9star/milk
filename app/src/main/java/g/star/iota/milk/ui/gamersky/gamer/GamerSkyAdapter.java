package g.star.iota.milk.ui.gamersky.gamer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class GamerSkyAdapter extends BaseAdapter<GamerSkyViewHolder, GamerSkyBean> {

    @Override
    public GamerSkyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GamerSkyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GamerSkyViewHolder) holder).bindView(mBeans.get(position));
    }
}
