package g.star.iota.milk.ui.xiumm.mm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MMAdapter extends BaseAdapter<MMViewHolder, MMBean> {

    @Override
    public MMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MMViewHolder) holder).bindView(mBeans.get(position));
    }
}
