package g.star.iota.milk.ui.main;

import com.google.gson.annotations.SerializedName;

public class JuZiBean {
    @SerializedName("hitokoto")
    private String hitokoto;
    @SerializedName("source")
    private String source;

    public String getHitokoto() {
        return hitokoto;
    }

    public String getSource() {
        return source;
    }

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
