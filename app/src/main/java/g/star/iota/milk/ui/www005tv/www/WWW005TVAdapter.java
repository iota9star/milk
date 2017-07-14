package g.star.iota.milk.ui.www005tv.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class WWW005TVAdapter extends BaseAdapter<WWW005TVViewHolder, WWW005TVBean> {

    @Override
    public WWW005TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WWW005TVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_with_subtitle_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WWW005TVViewHolder) holder).bindView(mBeans.get(position));
    }
}
