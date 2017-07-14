package g.star.iota.milk.ui.anipic.anime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseAdapter;


public class AnimePictureAdapter extends BaseAdapter<AnimePictureViewHolder, AnimePictureBean> {

    @Override
    public AnimePictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimePictureViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AnimePictureViewHolder) holder).bindView(mBeans.get(position));
    }
}
