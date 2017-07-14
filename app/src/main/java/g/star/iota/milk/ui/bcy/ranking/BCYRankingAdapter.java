package g.star.iota.milk.ui.bcy.ranking;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class BCYRankingAdapter extends BaseAdapter<BCYRankingViewHolder, BCYRankingBean> {

    @Override
    public BCYRankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BCYRankingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bcy_ranking, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BCYRankingViewHolder) holder).bindView(mBeans.get(position));
    }
}
