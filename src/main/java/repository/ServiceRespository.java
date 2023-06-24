package repository;

import config.DBConnect;
import entity.Calendar;
import entity.Shift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServiceRespository {

    public static ArrayList<Shift> getAllShiftByDay(String serviceID, String day) {
        ArrayList<Shift> listShift = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select s.*,x.ServiceID,x.NumberOfResponses,x.SetDay from tblShift s \n" +
                    "left outer join \n" +
                    "(select * from tblCalendar c where c.ServiceID=? and c.SetDay=?) x\n" +
                    " on s.ShiftID=x.ShiftID";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, serviceID);
            stmt.setString(2, day);
            ResultSet rs = stmt.executeQuery();
            listShift = new ArrayList<>();
            while (rs.next()) {
                String shiftID = rs.getString(1);
                String shiftName = rs.getString(2);
                String startTime = rs.getString(3);
                String endTime = rs.getString(4);
                int numberOfResponses = rs.getInt(6);
                int status = (rs.getString(7) == null) ? 0 : 1;
                Shift shift = new Shift();
                shift.setShiftID(shiftID);
                shift.setShiftName(shiftName);
                shift.setShiftStartTime(startTime);
                shift.setShiftEndTime(endTime);
                shift.setServiceID(serviceID);
                shift.setNumberOfResponse(numberOfResponses);
                shift.setStatus(status);
                shift.setDay(day);
                listShift.add(shift);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi getAllShiftByDay o ServiceRespository");
            e.printStackTrace();
        }
        return listShift;
    }

    public static ArrayList<Calendar> getCalendarByMonthYear(String seriveID, int month, int year) {
        ArrayList<Calendar> listCanlendar = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "  select c.*,s.ShiftName,s.ShiftStartTime,s.ShiftEndTime from tblCalendar c\n" +
                    "    join tblShift s on c.ShiftID=s.ShiftID\n" +
                    "    where Month(SetDay)=? and\n" +
                    "    YEAR(SetDay)=? and\n" +
                    "            ServiceID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, month);
            stmt.setInt(2, year);
            stmt.setString(3, seriveID);
            ResultSet rs = stmt.executeQuery();
            listCanlendar = new ArrayList<>();
            while (rs.next()) {
                String shiftID=rs.getString(1);
                String shiftName = rs.getString(5);
                String setDay = rs.getString(4);
                String startTime = rs.getString(6);
                String endTime = rs.getString(7);
                Calendar calendar = new Calendar();
                calendar.setShiftID(shiftID);
                calendar.setShiftName(shiftName);
                calendar.setSetDay(setDay);
                calendar.setStartTime(startTime);
                calendar.setEndTime(endTime);
                listCanlendar.add(calendar);
            }

        } catch (Exception e) {
            System.out.println("loi getALLCalendarByMY() servicerespository");
            e.printStackTrace();
        }
        return listCanlendar;
    }
  public static String getServiceName(String serviceID){
        String serviceName=null;
      try {
          Connection con = DBConnect.getConnection();
          String query = " select ServiceName from tblService where ServiceID=?";
          PreparedStatement stmt = con.prepareStatement(query);
          stmt.setString(1,serviceID);
          ResultSet rs = stmt.executeQuery();

          while (rs.next()) {
              serviceName=rs.getString(1);
          }

      } catch (Exception e) {
          System.out.println("loi getServiceName() servicerespository");
          e.printStackTrace();
      }
      return serviceName;
  }
    public static ArrayList<Shift> updateAmountShift(ArrayList<Shift> listShift){

        for (Shift s: listShift) {
            try {
                Connection con = DBConnect.getConnection();
                String query = " select ShiftID,ServiceID,SetDay,SUM(Amount) as Amount from tblServiceBill\n" +
                        "where StatusBill='1'\n" +
                        "group by ShiftID,ServiceID,SetDay\n" +
                        "having  (ShiftID=? and ServiceID=? and SetDay=?  )";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1,s.getShiftID());
                stmt.setString(2,s.getServiceID());
                stmt.setString(3,s.getDay());

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                   s.setRealOfResponse(rs.getInt(4));
                }

            } catch (Exception e) {
                System.out.println("loi UpdateAmountShift() servicerespository");
                e.printStackTrace();
            }
        }

        return listShift;
    }
    public static int getHandleNumberOfSlot(String serviceID, String shiftID,String setDay) {
        int handleNum = 0;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select NumberOfResponses from tblCalendar where ShiftID=? and ServiceID=? and SetDay=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, shiftID);
            stmt.setString(2, serviceID);
            stmt.setString(3, setDay);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                handleNum = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("===========>Loi getHandleNumberOfSlot trong ServiceRepository");
            e.printStackTrace();
        }
        return handleNum;
    }
    public static int getBookedNumberOfSlot(String serviceID, String shiftID,String setDay) {
        int bookedNum = 0;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select ShiftID,ServiceID,SetDay,SUM(Amount) as Amount from tblServiceBill\n" +
                    "    where StatusBill='1' or StatusBill = '2'\n" +
                    "     group by ShiftID,ServiceID,SetDay \n" +
                    "  having  (ShiftID=? and ServiceID=? and SetDay=?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, shiftID);
            stmt.setString(2, serviceID);
            stmt.setString(3, setDay);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookedNum = rs.getInt(4);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("===========>Loi getBookedNumberOfSlot trong ServiceRepository");
            e.printStackTrace();
        }
        return bookedNum;
    }

    public static boolean createCheckout(String billID,String customerID,String dateCreate,String serviceID, String shiftID,String setDay,int ammount) {

        try {
            Connection con = DBConnect.getConnection();
            String query = "insert into  tblServiceBill(BillID, CustomerID,DateCreate,ServiceID,ShiftID,SetDay,StatusBill,Amount) values (?,?,?,?,?,?,?,?)";

//            String query = "values\n" +
//                    "(?,NULL,?,?,'SH001','S0001','2023-06-13',0,12)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, billID);
            stmt.setString(2, customerID);
            stmt.setString(3, dateCreate);
            stmt.setString(4, serviceID);
            stmt.setString(5, shiftID);
            stmt.setString(6, setDay);
            stmt.setInt(7, 1);
            stmt.setInt(8,ammount);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("===========>Loi createCheckout trong ServiceRepository");
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
//        for (Shift s : getAllShiftByDay("S0001", "2023-06-20")) {
//            System.out.println(s);
//        }
//        for (Calendar c:getCalendarByMonthYear("S0001",6,2023)
//             ) {
//            System.out.println(c);
//        }
//        System.out.println(getServiceName("S0001"));
//        x
//        ArrayList<Shift> listShift= getAllShiftByDay("S0001","2023-06-01");
//        for (Shift s : listShift) {
//            System.out.println(s);
//        }
//        listShift=updateAmountShift(listShift);
//        for (Shift s : listShift) {
//            System.out.println(s);
//        }
//        String query = "insert into tblServiceBill\n" +
//                    "values\n" +
//                    "('WFQGC',NULL\t,'C0001','2023-06-01','SH001','S0001','2023-06-13',0,\t12)"
//        createCheckout("WFQ2GC","C0001","2023-06-20","S0001","SH001","2023-06-13");

    }

}
