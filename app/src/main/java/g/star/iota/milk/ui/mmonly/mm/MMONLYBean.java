package g.star.iota.milk.ui.mmonly.mm;


import g.star.iota.milk.base.BaseBean;

public class MMONLYBean extends BaseBean {
    private String preview;
    private String url;
    private String description;

    public MMONLYBean() {
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
}
