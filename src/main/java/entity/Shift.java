package entity;

public class Shift {
    private String shiftID;
    private String shiftName;
    private String shiftStartTime;
    private String shiftEndTime;
    private int status;
    private int numberOfResponse;
    private String day;
    private String serviceID;
    private int realOfResponse;

    public int getRealOfResponse() {
        return realOfResponse;
    }

    public void setRealOfResponse(int realOfResponse) {
        this.realOfResponse = realOfResponse;
    }

    public Shift() {
    }

    public Shift(String shiftID, String shiftName, String shiftStartTime, String shiftEndTime, int status, int numberOfResponse, String day) {
        this.shiftID = shiftID;
        this.shiftName = shiftName;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
        this.status = status;
        this.numberOfResponse = numberOfResponse;
        this.day = day;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(String shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public String getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(String shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberOfResponse() {
        return numberOfResponse;
    }

    public void setNumberOfResponse(int numberOfResponse) {
        this.numberOfResponse = numberOfResponse;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    public String getTimeToString(){
        return shiftStartTime.substring(0,5)+" - "+shiftEndTime.substring(0,5);
    }
    @Override
    public String toString() {
        return "Shift{" +
                "shiftID='" + shiftID + '\'' +
                ", shiftName='" + shiftName + '\'' +
                ", shiftStartTime='" + shiftStartTime + '\'' +
                ", shiftEndTime='" + shiftEndTime + '\'' +
                ", status=" + status +
                ", numberOfResponse=" + numberOfResponse +
                ", day='" + day + '\'' +
                ", serviceID='" + serviceID + '\'' +
                ", realOfResponse=" + realOfResponse +
                '}';
    }
}
