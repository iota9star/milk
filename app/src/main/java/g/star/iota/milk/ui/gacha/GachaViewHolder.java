package g.star.iota.milk.ui.gacha;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;

public class GachaViewHolder extends BaseViewHolder<GachaBean> {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;
    @BindView(R.id.text_view_author)
    TextView mTextViewAuthor;
    @BindView(R.id.text_view_rank)
    TextView mTextViewRank;
    @BindView(R.id.circle_image_avatar)
    CircleImageView mCircleImageViewAvatar;


    public GachaViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final GachaBean bean) {
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
                        .setTitle("是否下载")
                        .setNeutralButton("复制地址", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                copy(bean.getUrl());
                            }
                        })
                        .setNegativeButton("浏览器打开", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getUrl());
                            }
                        })
                        .setPositiveButton("下载", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                download(bean.getUrl(), bean.getPreview(),
                                        Contracts.Menu.MENU_GACHA, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(bean.getUrl(), bean.getPreview(), Contracts.Menu.MENU_GACHA,
                        "作者：" + bean.getUrl() + "\n\n" +
                                "排名：" + bean.getRank() + "\n\n" +
                                "下载地址：" + bean.getRank(), null);
            }
        });
        mTextViewAuthor.setText(bean.getAuthor());
        mTextViewRank.setText(bean.getRank());
    }
}
