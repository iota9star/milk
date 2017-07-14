package g.star.iota.milk.ui.jdlingyu.jd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class JDLINGYUAdapter extends BaseAdapter<JDLINGYUViewHolder, JDLINGYUBean> {

    @Override
    public JDLINGYUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JDLINGYUViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((JDLINGYUViewHolder) holder).bindView(mBeans.get(position));
    }
}
