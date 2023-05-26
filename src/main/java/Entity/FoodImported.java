package Entity;

public class FoodImported {
    private String foodID,
            consignment;
    private int amount;
    private String dateImported;

    public FoodImported() {
    }

    public FoodImported(String foodID, String consignment, int amount, String dateImported) {
        this.foodID = foodID;
        this.consignment = consignment;
        this.amount = amount;
        this.dateImported = dateImported;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getConsignment() {
        return consignment;
    }

    public void setConsignment(String consignment) {
        this.consignment = consignment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateImported() {
        return dateImported;
    }

    public void setDateImported(String dateImported) {
        this.dateImported = dateImported;
    }

    @Override
    public String toString() {
        return "FoodImported{" +
                "foodID='" + foodID + '\'' +
                ", consignment='" + consignment + '\'' +
                ", amount=" + amount +
                ", dateImported='" + dateImported + '\'' +
                '}';
    }
}
