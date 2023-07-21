package entity;

public class Preferential {

    private String id;
    private String preferentialName;
    private String startDay;
    private String endDay;
    private double rate;

    public Preferential() {
    }

    public Preferential(String id, String preferentialName, String startDay, String endDay, double rate) {
        this.id = id;
        this.preferentialName = preferentialName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreferentialName() {
        return preferentialName;
    }

    public void setPreferentialName(String preferentialName) {
        this.preferentialName = preferentialName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    @Override
    public String toString() {
        return "Preferential{" +
                "id='" + id + '\'' +
                ", preferentialName='" + preferentialName + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                '}';
    }
}
