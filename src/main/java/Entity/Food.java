package Entity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Food extends Product{
   private String origin;
    private ArrayList<Image> listFoodImage;
    private ArrayList<FoodImported> listFoodImported;

    public String getPriceToString(){
        DecimalFormat df = new DecimalFormat("##,###,###,###,###.##");
        String strNum = df.format(this.getProductPrice());
        return strNum;
    }

    public Food(String productID, String productName, String productType, String origin, double productPrice, String productStatus) {
        super(productID, productName, productType, productPrice, productStatus);
        this.origin = origin;
        listFoodImage=new ArrayList<>();
        listFoodImported=new ArrayList<>();
    }

    public ArrayList<Image> getListFoodImage() {
        return listFoodImage;
    }

    public void setListFoodImage(ArrayList<Image> listFoodImage) {
        this.listFoodImage = listFoodImage;
    }

    public ArrayList<FoodImported> getListFoodImported() {
        return listFoodImported;
    }

    public void setListFoodImported(ArrayList<FoodImported> listFoodImported) {
        this.listFoodImported = listFoodImported;
    }

    @Override
    public String toString() {
        return "Food{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productPrice=" + productPrice +
                ", productStatus='" + productStatus + '\'' +
                "origin='" + origin + '\'' +
                '}';
    }
}
