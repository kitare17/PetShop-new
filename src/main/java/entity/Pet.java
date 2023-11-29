package entity;

import java.util.ArrayList;

public class Pet extends Product {



//    private String productId;
//    private String productName;
//    private String productType;
//    private double productPrice;

    public Pet() {
    }

    public Pet(String productId, String productName, String productType, double productPrice, int productAmount, ArrayList<Image> listImg, int status) {
        super(productId, productName, productType, productPrice, productAmount, listImg, status);
    }

    @Override
    public String toString() {
        return "Pet{" + "productId=" + productId + ", productName=" + productName + ", productType=" + productType + ", productPrice=" + productPrice + ", productAmount=" + productAmount + '}';
    }
}
