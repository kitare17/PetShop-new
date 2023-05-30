package entity;

public class Pet extends Product {
    private String petColor;


//    private String productId;
//    private String productName;
//    private String productType;
//    private double productPrice;

    public Pet() {
    }

    public Pet(String productId, String productName, String productType, double productPrice, int productAmount, String petColor) {
        super(productId, productName, productType, productPrice, productAmount);
        this.petColor = petColor;
    }


    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    @Override
    public String toString() {
        return "Pet{" + "productId=" + productId + ", productName=" + productName + ", productType=" + productType + ", productPrice=" + productPrice + ", productAmount=" + productAmount + "petColor=" + petColor + '}';
    }
}
