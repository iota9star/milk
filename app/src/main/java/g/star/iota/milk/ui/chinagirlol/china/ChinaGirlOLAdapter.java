package g.star.iota.milk.ui.chinagirlol.china;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class ChinaGirlOLAdapter extends BaseAdapter<ChinaGirlOLViewHolder, ChinaGirlOLBean> {

    @Override
    public ChinaGirlOLViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChinaGirlOLViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChinaGirlOLViewHolder) holder).bindView(mBeans.get(position));
    }
}
