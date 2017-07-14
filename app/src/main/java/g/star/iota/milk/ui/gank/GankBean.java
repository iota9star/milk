package g.star.iota.milk.ui.gank;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import g.star.iota.milk.base.BaseBean;


public class GankBean {

    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends BaseBean {
        @SerializedName("desc")
        private String desc;
        @SerializedName("url")
        private String url;

        public ResultsBean() {
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
