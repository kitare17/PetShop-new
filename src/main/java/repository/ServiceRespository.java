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


    public static void main(String[] args) {
//        for (Shift s : getAllShiftByDay("S0001", "2023-06-20")) {
//            System.out.println(s);
//        }
        for (Calendar c:getCalendarByMonthYear("S0001",6,2023)
             ) {
            System.out.println(c);
        }
    }

}
