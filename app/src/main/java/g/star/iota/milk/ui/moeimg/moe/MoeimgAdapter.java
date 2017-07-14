package g.star.iota.milk.ui.moeimg.moe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MoeimgAdapter extends BaseAdapter<MoeimgViewHolder, MoeimgBean> {

    @Override
    public MoeimgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoeimgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MoeimgViewHolder) holder).bindView(mBeans.get(position));
    }
}
