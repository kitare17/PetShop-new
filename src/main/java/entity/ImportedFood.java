package entity;

public class ImportedFood {
    private String foodID;
    private String importName;
    private int importAmount;
    private String importDate;

    public ImportedFood() {
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }



    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public int getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(int importAmount) {
        this.importAmount = importAmount;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public ImportedFood(String foodID, String importName, int importAmount, String importDate) {
        this.foodID = foodID;
        this.importName = importName;
        this.importAmount = importAmount;
        this.importDate = importDate;
    }
    @Override
    public String toString() {
        return "ImportFood{" +
                "foodID='" + foodID + '\'' +
                ", importName='" + importName + '\'' +
                ", importAmount=" + importAmount +
                ", importDate='" + importDate + '\'' +
                '}';
    }
}
