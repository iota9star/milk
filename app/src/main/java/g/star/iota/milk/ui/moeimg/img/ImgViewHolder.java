package g.star.iota.milk.ui.moeimg.img;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;

public class ImgViewHolder extends BaseViewHolder<ImgBean> {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;

    public ImgViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final ImgBean bean) {
        mImageViewImage.setAdjustViewBounds(true);
        GlideApp.with(mContext)
                .load(bean.getUrl())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_load_error)
                .fallback(R.drawable.ic_load_error)
                .into(mImageViewImage);
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
                                download(bean.getUrl(), bean.getUrl()
                                        , Contracts.Menu.MENU_MOEIMG, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(bean.getUrl(), bean.getUrl(), Contracts.Menu.MENU_MOEIMG,
                        "下载地址：" + bean.getUrl(), null);
            }
        });
    }
}
