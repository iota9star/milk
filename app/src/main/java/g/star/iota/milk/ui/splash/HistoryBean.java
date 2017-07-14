package g.star.iota.milk.ui.splash;


public class HistoryBean {

    private String day;
    private String year;
    private String event;

    public HistoryBean(String day, String year, String event) {
        this.day = day;
        this.year = year;
        this.event = event;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getEvent() {
        return event;
    }
}
