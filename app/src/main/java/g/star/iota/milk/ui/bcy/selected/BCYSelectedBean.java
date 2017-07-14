package g.star.iota.milk.ui.bcy.selected;

import android.os.Parcel;
import android.os.Parcelable;

import g.star.iota.milk.base.BaseBean;


public class BCYSelectedBean extends BaseBean implements Parcelable {
    private String description;
    private String preview;
    private String url;

    BCYSelectedBean() {
    }

    protected BCYSelectedBean(Parcel in) {
        description = in.readString();
        preview = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(preview);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BCYSelectedBean> CREATOR = new Creator<BCYSelectedBean>() {
        @Override
        public BCYSelectedBean createFromParcel(Parcel in) {
            return new BCYSelectedBean(in);
        }

        @Override
        public BCYSelectedBean[] newArray(int size) {
            return new BCYSelectedBean[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
