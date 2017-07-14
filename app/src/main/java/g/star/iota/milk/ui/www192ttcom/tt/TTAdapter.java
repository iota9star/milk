package g.star.iota.milk.ui.www192ttcom.tt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class TTAdapter extends BaseAdapter<TTViewHolder, TTBean> {

    @Override
    public TTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TTViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TTViewHolder) holder).bindView(mBeans.get(position));
    }
}
