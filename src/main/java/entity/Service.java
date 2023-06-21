package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Service {
    DecimalFormat formatter = new DecimalFormat("#,###,###");
    private String serviceID,   serviceName;
    private  double   servicePrice;
    private String description;
    private ArrayList<Image> listImg;
    private int status;
    public Service() {
    }

    public Service(String serviceID, String serviceName, double servicePrice, String description) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.description = description;
    }

    public Service(String serviceID, String serviceName, double servicePrice , int status, String description, ArrayList<Image> listImg) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.description = description;
        this.listImg = listImg;
        this.status = status;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public String getPriceString() {
        return formatter.format(servicePrice);

    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", servicePrice=" + servicePrice + ", description=" + description + '}';
    }

}
