package entity;

import java.util.ArrayList;

public class Food extends Product{
   private String origin;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Food() {
    }

//    public Food(String productId, String productName, String productType, double productPrice, int productAmount) {
//        super(productId, productName, productType, productPrice, productAmount);
//    }

    public Food(String productId, String productName, String productType, double productPrice, int productAmount, ArrayList<Image> listImg, int status, String origin) {
        super(productId, productName, productType, productPrice, productAmount, listImg, status);
        this.origin = origin;
    }
}
