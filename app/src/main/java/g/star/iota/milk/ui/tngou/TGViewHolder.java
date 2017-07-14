package g.star.iota.milk.ui.tngou;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.util.FileUtils;

public class TGViewHolder extends BaseViewHolder<TGBean.TngouBean> {

    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;

    public TGViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final TGBean.TngouBean bean) {
        mImageViewImage.setAdjustViewBounds(true);
        GlideApp.with(mContext)
                .load(bean.getImg())
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
                                copy(bean.getImg());
                            }
                        })
                        .setNegativeButton("浏览器打开", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getImg());
                            }
                        })
                        .setPositiveButton("下载", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                download(bean.getImg(), bean.getImg(),
                                        Contracts.Menu.MENU_TNGOU, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(bean.getImg(), bean.getImg(), Contracts.Menu.MENU_TNGOU,
                        "标题：" + bean.getTitle() + "\n\n" +
                                "下载地址：" + bean.getImg(), null);
            }
        });
        mTextViewDescription.setText(bean.getTitle());
    }
}
