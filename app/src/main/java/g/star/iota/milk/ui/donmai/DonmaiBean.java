package g.star.iota.milk.ui.donmai;


import com.google.gson.annotations.SerializedName;

import g.star.iota.milk.base.BaseBean;

public class DonmaiBean extends BaseBean {

    @SerializedName("file_url")
    private String url;
    @SerializedName("preview_file_url")
    private String preview;
    @SerializedName("rating")
    private String rating;
    @SerializedName("image_width")
    private int width;
    @SerializedName("image_height")
    private int height;
    @SerializedName("tag_string")
    private String tags;
    @SerializedName("uploader_name")
    private String author;
    @SerializedName("source")
    private String source;
    @SerializedName("score")
    private int score;
    @SerializedName("file_size")
    private int fileSize;

    private String size;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }

    public int getScore() {
        return score;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getUrl() {
        return url;
    }

    public String getPreview() {
        return preview;
    }

    public String getRating() {
        return rating;
    }

    public String getSize() {
        return width + "*" + height;
    }
}
