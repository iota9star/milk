package g.star.iota.milk.ui.booru;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import g.star.iota.milk.Contracts;
import g.star.iota.milk.R;
import g.star.iota.milk.base.BaseViewHolder;
import g.star.iota.milk.glide.GlideApp;
import g.star.iota.milk.util.ConfigUtils;


public class BooruViewHolder extends BaseViewHolder<BooruBean> {

    @BindView(R.id.text_view_tag)
    TextView mTextViewTag;
    @BindView(R.id.image_view_rating)
    ImageView mImageViewRating;
    @BindView(R.id.image_view_image)
    ImageView mImageViewImage;

    public BooruViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final BooruBean bean) {
        mImageViewImage.setAdjustViewBounds(true);
        mTextViewTag.setText(bean.getSize());
        String r = bean.getRating();
        if (ConfigUtils.getR(aContext)) {
            switch (r == null ? "o" : r) {
                case "s":
                    GlideApp.with(mContext)
                            .load(bean.getPreview())
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
                                                    Contracts.Menu.MENU_YANDE + "_" + Contracts.Menu.MENU_KONACHAN + "_" + Contracts.Menu.MENU_LOLIBOORU, null);
                                        }
                                    })
                                    .show();
                            return true;
                        }
                    });
                    mImageViewImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendData(bean.getUrl(), bean.getPreview(), Contracts.Menu.MENU_YANDE + "_" + Contracts.Menu.MENU_KONACHAN + "_" + Contracts.Menu.MENU_LOLIBOORU,
                                    "作者：" + bean.getAuthor() + "\n\n" +
                                            "评级：" + bean.getRating() + "\n\n" +
                                            "分辨率：" + bean.getSize() + "\n\n" +
                                            "来源：" + bean.getSource() + "\n\n" +
                                            "标签：" + bean.getTags() + "\n\n" +
                                            "文件大小：" + Formatter.formatFileSize(mContext, bean.getFileSize()) + "\n\n" +
                                            "得分：" + bean.getScore(), null);
                        }
                    });
                    break;
                case "q":
                    GlideApp.with(mContext)
                            .load(R.drawable.ic_r15)
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_load_error)
                            .fallback(R.drawable.ic_load_error)
                            .into(mImageViewImage);
                    mImageViewImage.setOnClickListener(null);
                    mImageViewImage.setOnLongClickListener(null);
                    break;
                case "e":
                    GlideApp.with(mContext)
                            .load(R.drawable.ic_r18)
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_load_error)
                            .fallback(R.drawable.ic_load_error)
                            .into(mImageViewImage);
                    mImageViewImage.setOnClickListener(null);
                    mImageViewImage.setOnLongClickListener(null);
                    break;
                default:
                    GlideApp.with(mContext)
                            .load(R.drawable.ic_r_unknown)
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_load_error)
                            .fallback(R.drawable.ic_load_error)
                            .into(mImageViewImage);
                    mImageViewImage.setOnClickListener(null);
                    mImageViewImage.setOnLongClickListener(null);
                    break;
            }
        } else {
            GlideApp.with(mContext)
                    .load(bean.getPreview())
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
                                            Contracts.Menu.MENU_YANDE + "_" + Contracts.Menu.MENU_KONACHAN + "_" + Contracts.Menu.MENU_LOLIBOORU, null);
                                }
                            })
                            .show();
                    return true;
                }
            });
            mImageViewImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendData(bean.getUrl(), bean.getPreview(), Contracts.Menu.MENU_YANDE + "_" + Contracts.Menu.MENU_KONACHAN + "_" + Contracts.Menu.MENU_LOLIBOORU,
                            "作者：" + bean.getAuthor() + "\n\n" +
                                    "评级：" + bean.getRating() + "\n\n" +
                                    "分辨率：" + bean.getSize() + "\n\n" +
                                    "来源：" + bean.getSource() + "\n\n" +
                                    "标签：" + bean.getTags() + "\n\n" +
                                    "文件大小：" + Formatter.formatFileSize(mContext, bean.getFileSize()) + "\n\n" +
                                    "得分：" + bean.getScore() + "\n\n" +
                                    "下载地址：" + bean.getUrl(), null);
                }
            });
        }
        switch (r == null ? "o" : r) {
            case "s":
                mImageViewRating.setImageResource(R.drawable.ic_bookmark_green_24dp);
                break;
            case "q":
                mImageViewRating.setImageResource(R.drawable.ic_bookmark_yellow_24dp);
                break;
            case "e":
                mImageViewRating.setImageResource(R.drawable.ic_bookmark_red_24dp);
                break;
            default:
                mImageViewRating.setImageResource(R.drawable.ic_bookmark_blue_24dp);
                break;
        }
    }
}
