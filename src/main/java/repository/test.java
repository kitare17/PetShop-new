package repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class test {


    public static void main(String[] args) {
       String thongbao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate homNay = LocalDate.now();//Lấy thời gian hôm nay
        String homNayS = homNay.format(formatter);
        String ngayDat = "2023-06-24";// setDay đấy
        LocalDate ngayDatF = LocalDate.parse(ngayDat, formatter);

        long daysBetween = ChronoUnit.DAYS.between( homNay,ngayDatF);
        if (daysBetween >= 2) {
            System.out.println("ok");
        } else {
            thongbao="Ngày đặt: ("+ngayDat + ") và Hôm nay (" + homNayS + ") phải cách nhau 2 ngày";
            System.out.println(thongbao);
        }

    }

}


