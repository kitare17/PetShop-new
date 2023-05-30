package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    DecimalFormat formatter = new DecimalFormat("#,###,###");
    protected String productId;
    protected String productName;
    protected String productType;
    protected double productPrice;
    protected int productAmount;
    protected ArrayList<Image> listImg;
    protected int status;
    public Product() {
    }

    public ArrayList<Image> getListImg() {
        return listImg;
    }

    public void setListImg(ArrayList<Image> listImg) {
        this.listImg = listImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Product(String productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(String productId, String productName, String productType, double productPrice, int productAmount, ArrayList<Image> listImg, int status) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.listImg = listImg;
        this.status = status;
    }

    public Product(String productId, String productName, String productType, double productPrice, int productAmount) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getPriceString() {
        return formatter.format(productPrice);

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productType=" + productType + ", productPrice=" + productPrice + ", productAmount=" + productAmount + '}';
    }
}
