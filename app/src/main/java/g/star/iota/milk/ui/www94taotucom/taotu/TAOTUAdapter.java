package g.star.iota.milk.ui.www94taotucom.taotu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class TAOTUAdapter extends BaseAdapter<TAOTUViewHolder, TAOTUBean> {

    @Override
    public TAOTUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TAOTUViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TAOTUViewHolder) holder).bindView(mBeans.get(position));
    }
}
