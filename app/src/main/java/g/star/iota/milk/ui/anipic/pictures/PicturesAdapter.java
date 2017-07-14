package g.star.iota.milk.ui.anipic.pictures;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class PicturesAdapter extends BaseAdapter<PicturesViewHolder, PicturesBean> {

    @Override
    public PicturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicturesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PicturesViewHolder) holder).bindView(mBeans.get(position));
    }
}
