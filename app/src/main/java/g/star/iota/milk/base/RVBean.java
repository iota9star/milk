package g.star.iota.milk.base;


public class RVBean {
    private final boolean isChangeSpanCount;
    private final boolean isTouchToTop;

    public RVBean(boolean isChangeSpanCount, boolean isTouchToTop) {
        this.isChangeSpanCount = isChangeSpanCount;
        this.isTouchToTop = isTouchToTop;
    }

    public boolean isChangeSpanCount() {
        return isChangeSpanCount;
    }

    public boolean isTouchToTop() {
        return isTouchToTop;
    }
}
