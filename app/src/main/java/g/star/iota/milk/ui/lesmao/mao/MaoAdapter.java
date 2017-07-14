package g.star.iota.milk.ui.lesmao.mao;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MaoAdapter extends BaseAdapter<MaoViewHolder, MaoBean> {

    @Override
    public MaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MaoViewHolder) holder).bindView(mBeans.get(position));
    }
}
