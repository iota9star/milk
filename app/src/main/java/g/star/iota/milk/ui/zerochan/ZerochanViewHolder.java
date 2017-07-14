package g.star.iota.milk.ui.zerochan;


import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;

public class ZerochanViewHolder extends BaseViewHolder<ZerochanBean> {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.text_view_tag)
    TextView mTextViewTag;


    public ZerochanViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final ZerochanBean bean) {
        mImageViewImage.setAdjustViewBounds(true);
        GlideApp.with(mContext)
                .load(bean.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        bean.setUrl(bean.getUrl().replace(".jpg", ".png"));
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
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
                                download(bean.getUrl(), bean.getPreview(),
                                        Contracts.Menu.MENU_ZEROCHAN, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(bean.getUrl(), bean.getPreview(), Contracts.Menu.MENU_ZEROCHAN,
                        "描述：" + bean.getDescription() + "\n\n" +
                                "信息：" + bean.getInfo() + "\n\n" +
                                "下载地址：" + bean.getUrl(), null);
            }
        });
        mTextViewDescription.setText(bean.getDescription());
        mTextViewTag.setText(bean.getInfo());
    }
}
