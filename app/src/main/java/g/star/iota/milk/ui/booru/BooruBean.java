package g.star.iota.milk.ui.booru;


import com.google.gson.annotations.SerializedName;

import g.star.iota.milk.base.BaseBean;

public class BooruBean extends BaseBean {

    @SerializedName("file_url")
    private String url;
    @SerializedName("preview_url")
    private String preview;
    @SerializedName("rating")
    private String rating;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("tags")
    private String tags;
    @SerializedName("author")
    private String author;
    @SerializedName("source")
    private String source;
    @SerializedName("score")
    private int score;
    @SerializedName("file_size")
    private int fileSize;

    private String size;

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
        if (url.contains("http")) return url;
        else return "https:" + url;
    }

    public String getPreview() {
        if (preview.contains("http")) return preview;
        else return "https:" + preview;
    }

    public String getRating() {
        return rating;
    }

    public String getSize() {
        return width + "*" + height;
    }
}
