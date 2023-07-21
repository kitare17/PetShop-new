package entity;

public class ServiceBooked {
    private String billID;
    private String serviceName;
    private String dateCreate; //ngay tao don
    private String setDay; //ngay ma dich vu do den hen

    private String startTime;
    private String endTime;
    private int ammount;
    private String priceAtPurchase;
    private int status;

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getSetDay() {
        return setDay;
    }

    public void setSetDay(String setDay) {
        this.setDay = setDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getPriceAtPurchase() {
//        double doubePrice = Double.parseDouble(priceAtPurchase);
//        double realPrice = doubePrice * ammount;
//        return Double.toString(realPrice);
        return  priceAtPurchase;
    }


    public void setPriceAtPurchase(String priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public ServiceBooked(String billID, String serviceName, String dateCreate, String setDay, String startTime, String endTime, int ammount, String priceAtPurchase, int status) {
        this.billID = billID;
        this.serviceName = serviceName;
        this.dateCreate = dateCreate;
        this.setDay = setDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ammount = ammount;
        this.priceAtPurchase = priceAtPurchase;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceBooked{" +
                "billID='" + billID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", setDay='" + setDay + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", ammount=" + ammount +
                ", priceAtPurchase='" + priceAtPurchase + '\'' +
                ", status=" + status +
                '}';
    }
    public String getStatusString() {
        if (this.status == 0 ) {
            return "Đang chờ";
        } else if (this.status == 1) {
            return "Đã thanh toán";
        } else if (this.status == 2) {
            return "Đã thanh toán";
        } else if (this.status == 3) {
            return "Đã hủy";
        } else {
            return "Lỗi";
        }
    }
    public String getTimeToString(){
        return startTime.substring(0,5)+" - "+endTime.substring(0,5);
    }
    public String getPriceAtPurchaseReal() {
        double doubePrice = Double.parseDouble(priceAtPurchase);

        double realPrice = doubePrice * ammount;
        String price =  Double.toString(realPrice);
        return price;
    }
}
