package entity;

import java.text.DecimalFormat;

public class Revenue {

    private String month;
    private double money;

    public Revenue() {
    }

    public Revenue(String month, double money) {
        this.month = month;
        this.money = money;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    DecimalFormat formatter = new DecimalFormat("#,###,###.##");
    public String getMoneyString() {
        return formatter.format(money);

    }
    @Override
    public String toString() {
        return "Revenue{" +
                "month='" + month + '\'' +
                ", money=" + money +
                '}';
    }
}
