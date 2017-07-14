package g.star.iota.milk.ui.bcy.ranking;

import android.os.Parcel;
import android.os.Parcelable;

import g.star.iota.milk.base.BaseBean;


public class BCYRankingBean extends BaseBean implements Parcelable {
    private String description;
    private String author;
    private String avatar;
    private String rank;
    private String preview;
    private String url;

    public BCYRankingBean() {
    }

    protected BCYRankingBean(Parcel in) {
        description = in.readString();
        author = in.readString();
        avatar = in.readString();
        rank = in.readString();
        preview = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(author);
        dest.writeString(avatar);
        dest.writeString(rank);
        dest.writeString(preview);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BCYRankingBean> CREATOR = new Creator<BCYRankingBean>() {
        @Override
        public BCYRankingBean createFromParcel(Parcel in) {
            return new BCYRankingBean(in);
        }

        @Override
        public BCYRankingBean[] newArray(int size) {
            return new BCYRankingBean[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
