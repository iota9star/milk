package g.star.iota.milk.ui.mzitu.tu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class TuAdapter extends BaseAdapter<TuViewHolder, TuBean> {

    @Override
    public TuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TuViewHolder) holder).bindView(mBeans.get(position));
    }
}
