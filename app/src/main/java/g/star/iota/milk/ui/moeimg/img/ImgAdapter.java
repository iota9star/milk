package g.star.iota.milk.ui.moeimg.img;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class ImgAdapter extends BaseAdapter<ImgViewHolder, ImgBean> {

    @Override
    public ImgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ImgViewHolder) holder).bindView(mBeans.get(position));
    }
}
