package g.star.iota.milk.ui.bcy.ranking;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.ui.bcy.ing.IngFragment;

public class BCYRankingViewHolder extends BaseViewHolder<BCYRankingBean> {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;
    @BindView(R.id.text_view_author)
    TextView mTextViewAuthor;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.text_view_rank)
    TextView mTextViewRank;
    @BindView(R.id.circle_image_avatar)
    CircleImageView mCircleImageViewAvatar;

    public BCYRankingViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final BCYRankingBean bean) {
        mImageViewImage.setAdjustViewBounds(true);
        GlideApp.with(mContext)
                .load(bean.getPreview())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_load_error)
                .fallback(R.drawable.ic_load_error)
                .into(mImageViewImage);
        GlideApp.with(mContext)
                .load(bean.getAvatar())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_load_error)
                .fallback(R.drawable.ic_load_error)
                .into(mCircleImageViewAvatar);
        mImageViewImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("从浏览器打开")
                        .setNegativeButton("嗯", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getUrl());
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                return true;
            }
        });
        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) mContext).addFragment(IngFragment.newInstance(bean.getUrl()));
            }
        });
        mTextViewAuthor.setText(bean.getAuthor());
        mTextViewRank.setText(bean.getRank());
        mTextViewDescription.setText(bean.getDescription());
    }
}
