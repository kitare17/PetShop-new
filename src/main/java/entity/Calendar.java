package entity;



public class Calendar {

    private String shiftID;
    private String shiftName;
    private String setDay;
    private int numberOfResponse;
    private String startTime;
    private String endTime;
    private String serviceID;
    private String serviceName;

    public Calendar() {
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

    public String getSetDay() {
        return setDay;
    }

    public void setSetDay(String setDay) {
        this.setDay = setDay;
    }

    public int getNumberOfResponse() {
        return numberOfResponse;
    }

    public void setNumberOfResponse(int numberOfResponse) {
        this.numberOfResponse = numberOfResponse;
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

    @Override
    public String toString() {
        return "Calendar{" +

                ", shiftID='" + shiftID + '\'' +
                ", shiftName='" + shiftName + '\'' +
                ", setDay='" + setDay + '\'' +
                ", numberOfResponse=" + numberOfResponse +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
