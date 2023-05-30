package entity;

public class Food extends Product{

    public Food() {
    }

    public Food(String productId, String productName, String productType, double productPrice, int productAmount) {
        super(productId, productName, productType, productPrice, productAmount);
    }

}
