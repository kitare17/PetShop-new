package entity;

public class StatisticAge {
    private int age,amount;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public StatisticAge() {
    }

    public StatisticAge(int age, int amount) {
        this.age = age;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "StatisticAge{" + "age=" + age + ", amount=" + amount + '}';
    }
}
