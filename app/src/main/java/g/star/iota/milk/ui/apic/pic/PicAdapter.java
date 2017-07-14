package g.star.iota.milk.ui.apic.pic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class PicAdapter extends BaseAdapter<PicViewHolder, PicBean> {

    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PicViewHolder) holder).bindView(mBeans.get(position));
    }
}
