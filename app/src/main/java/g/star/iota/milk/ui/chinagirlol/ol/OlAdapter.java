package g.star.iota.milk.ui.chinagirlol.ol;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class OlAdapter extends BaseAdapter<OlViewHolder, OlBean> {

    @Override
    public OlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OlViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((OlViewHolder) holder).bindView(mBeans.get(position));
    }
}
