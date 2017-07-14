package g.star.iota.milk.ui.www192ttcom.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class WWW192TTCOMAdapter extends BaseAdapter<WWW192TTCOMViewHolder, WWW192TTCOMBean> {

    @Override
    public WWW192TTCOMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WWW192TTCOMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WWW192TTCOMViewHolder) holder).bindView(mBeans.get(position));
    }
}
