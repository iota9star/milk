package g.star.iota.milk.ui.mangadrawing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class MangaDrawingAdapter extends BaseAdapter<MangaDrawingViewHolder, MangaDrawingBean> {

    @Override
    public MangaDrawingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MangaDrawingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MangaDrawingViewHolder) holder).bindView(mBeans.get(position));
    }
}
