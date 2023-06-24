package entity;

public class ServiceBill {
    private String billID;
    private String employeeID;
    private String customerID;
    private String dateCreate;
    private String shiftID;
    private String serviceID;
    private String day;
    private int status;
    private int amount;

    public ServiceBill() {
    }

    public ServiceBill(String billID, String employeeID, String customerID, String dateCreate, String shiftID, String serviceID, String day, int status, int amount) {
        this.billID = billID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.dateCreate = dateCreate;
        this.shiftID = shiftID;
        this.serviceID = serviceID;
        this.day = day;
        this.status = status;
        this.amount = amount;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ServiceBill{" +
                "billID='" + billID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", shiftID='" + shiftID + '\'' +
                ", serviceID='" + serviceID + '\'' +
                ", day='" + day + '\'' +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}
