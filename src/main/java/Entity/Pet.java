package Entity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pet extends Product{
    private ArrayList<Image> listPetImage;
    public Pet(String productID, String productName, String productType, double productPrice, String productStatus) {
        super(productID, productName, productType, productPrice, productStatus);
        listPetImage=new ArrayList<>();
    }
    public String getPriceToString(){
        DecimalFormat df = new DecimalFormat("##,###,###,###,###.##");
        String strNum = df.format(this.getProductPrice());
        return strNum;
    }
    public ArrayList<Image> getListPetImage() {
        return listPetImage;
    }

    public void setListPetImage(ArrayList<Image> listPetImage) {
        this.listPetImage = listPetImage;
    }

}
