package entity;

public class OrderAccept {
    private String idOrder,username,date,discountId,total,orderStatus;
    private String address,employeeID;



    public OrderAccept() {
    }

    public OrderAccept(String idOrder, String username, String date, String discountId, String total, String orderStatus) {
        this.idOrder = idOrder;
        this.username = username;
        this.date = date;
        this.discountId = discountId;
        this.total = total;
        this.orderStatus = orderStatus;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "OrderAccept{" + "idOrder=" + idOrder + ", username=" + username + ", date=" + date + ", discountId=" + discountId + ", total=" + total + ", orderStatus=" + orderStatus + '}';
    }
}
