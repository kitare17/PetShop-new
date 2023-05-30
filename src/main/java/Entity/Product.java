package Entity;

public class Product {
    protected String productID,
            productName,
            productType;
    protected double productPrice;
    protected String productStatus;
    protected int productAmount;

    public Product(String productID, String productName, String productType, double productPrice, String productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productPrice=" + productPrice +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }
}

