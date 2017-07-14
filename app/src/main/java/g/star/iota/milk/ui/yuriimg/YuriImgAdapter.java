package g.star.iota.milk.ui.yuriimg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class YuriImgAdapter extends BaseAdapter<YuriImgViewHolder, YuriImgBean> {

    @Override
    public YuriImgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YuriImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YuriImgViewHolder) holder).bindView(mBeans.get(position));
    }
}
