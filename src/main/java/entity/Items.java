package entity;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;
import repository.OrderRepository;

import java.text.DecimalFormat;

public class Items {
    private Product product;
    private int ammout;
    DecimalFormat formatter = new DecimalFormat("#,###,###");

    public Items() {
    }

    public Items(Product product, int ammout) {
        this.product = product;
        this.ammout = ammout;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmmout() {
        return ammout;
    }

    public void setAmmout(int ammout) {
        this.ammout = ammout;
    }

    public double getPrice() {
        return product.getProductPrice() * ammout;
    }
    public double getPriceAfterPurchase (String OrderId) {
        for (int i = 0 ; i < 10 ; i ++) {
            System.out.println(OrderId);
            System.out.println(product.getProductId());
            System.out.println("me");
            System.out.println(OrderRepository.getPriceOrdered(OrderId,product.getProductId()));
        }
        return OrderRepository.getPriceOrdered(OrderId,product.getProductId());
    }
    public String getPriceString() {
        return formatter.format(getPrice());

    }

    public boolean equal(Items item) {
        if (this.product.productId.compareToIgnoreCase(item.product.productId) == 0) {
            return true;
        }
        return false;
    }
}
