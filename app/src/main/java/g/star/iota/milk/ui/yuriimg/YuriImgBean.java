package g.star.iota.milk.ui.yuriimg;


import g.star.iota.milk.base.BaseBean;

public class YuriImgBean extends BaseBean {
    private String preview;
    private String url;
    private String description;
    private String size;
    private String referer;

    YuriImgBean() {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }
}
