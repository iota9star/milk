package g.star.iota.milk.ui.theme;

public class ThemeBean {
    private final int theme;
    private final int color;
    private final String description;
    private boolean isSelected;

    public ThemeBean(int theme, int color, String description, boolean isSelected) {
        this.theme = theme;
        this.color = color;
        this.description = description;
        this.isSelected = isSelected;
    }

    public int getTheme() {
        return theme;
    }

    public int getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
