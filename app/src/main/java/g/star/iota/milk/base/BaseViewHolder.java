package g.star.iota.milk.base;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import butterknife.ButterKnife;
import g.star.iota.milk.ui.watch.WatchActivity;
import g.star.iota.milk.util.FileUtils;
import g.star.iota.milk.util.SnackbarUtils;


public abstract class BaseViewHolder<B extends BaseBean> extends RecyclerView.ViewHolder {
    protected Context mContext;
    protected Context aContext;

    protected BaseViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        aContext = mContext.getApplicationContext();
        ButterKnife.bind(this, itemView);
    }

    public abstract void bindView(B beans);

    protected void open(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        mContext.startActivity(intent);
    }

    protected void copy(String url) {
        ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newPlainText("image_url", url));
    }

    protected void download(String url, String preview, String folder, Map<String, String> headers) {
        if (OkDownload.getInstance().hasTask(url)) {
            SnackbarUtils.create(mContext, "任务已存在");
        } else {
            GetRequest<File> request = OkGo.<File>get(url);
            if (headers != null) {
                for (Map.Entry<String, String> val : headers.entrySet()) {
                    request.headers(val.getKey(), val.getValue());
                }
            }
            OkDownload.request(url, request)
                    .extra1(preview)
                    .extra2(folder)
                    .folder(FileUtils.getDownloadDir() + folder)
                    .save()
                    .start();
            SnackbarUtils.create(mContext, "开始下载：" + url);
        }
    }

    protected void sendData(String url, String preview, String source, String description, Map<String, String> headers) {
        Intent intent = new Intent(mContext, WatchActivity.class);
        intent.putExtra("image_url", url);
        intent.putExtra("image_preview", preview);
        intent.putExtra("image_source", source);
        intent.putExtra("image_description", description);
        intent.putExtra("request_headers", (Serializable) headers);
        mContext.startActivity(intent);
    }
}
