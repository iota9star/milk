package g.star.iota.milk.ui.www94taotucom.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class WWW94TAOTUCOMAdapter extends BaseAdapter<WWW94TAOTUCOMViewHolder, WWW94TAOTUCOMBean> {

    @Override
    public WWW94TAOTUCOMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WWW94TAOTUCOMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WWW94TAOTUCOMViewHolder) holder).bindView(mBeans.get(position));
    }
}
