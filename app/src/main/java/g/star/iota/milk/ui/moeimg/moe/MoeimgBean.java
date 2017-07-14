package g.star.iota.milk.ui.moeimg.moe;


import g.star.iota.milk.base.BaseBean;

public class MoeimgBean extends BaseBean {
    private String preview;
    private String url;
    private String description;
    private String date;

    public MoeimgBean() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
