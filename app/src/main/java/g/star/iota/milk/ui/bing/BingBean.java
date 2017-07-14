package g.star.iota.milk.ui.bing;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.BaseBean;


public class BingBean {
    @SerializedName("images")
    private List<ImagesBean> images;

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean extends BaseBean {
        @SerializedName("enddate")
        private String enddate;
        @SerializedName("url")
        private String url;
        @SerializedName("copyright")
        private String copyright;

        public String getEnddate() {
            return enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getUrl() {
            return Contracts.Url.BING_BASE + url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }
    }
}
