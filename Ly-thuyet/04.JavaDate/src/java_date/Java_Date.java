/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * Có 2 cách để xử lý thời gian trong java
 * 1: LocalDate (Lớp mới nên sử dụng, thay thế cho java.util.Date lỗi thời)
 * 2: ZonedDateTime (giúp tự động điều chỉnh múi giờ theo vị trí hiện tại)
 * @author nguye
 */
public class Java_Date {
    public static void main(String[] args) {
        //LocalDate
        
        //now
        LocalDate lDate = LocalDate.now();
        //Lấy thời gian hiện tại
        
        //of
        LocalDateTime lDate2 = LocalDateTime.of(2019, 5, 12,12, 00);
        //lDate2 : 2019-05-12T12:00
        System.out.println(lDate2);
        
        //parse
        String str = "2022-05-01T10:30:00";
        LocalDateTime lDate3 = LocalDateTime.parse(str);
        System.out.println(lDate3);
        
        //plus and minus
        LocalDateTime time = LocalDateTime.now();
        //time: 2023-03-30T13:43:03.741565
        LocalDateTime timeNew = time.plusDays(5);
        //timeNew: 2023-04-04T13:43:03.741565
        
        LocalDateTime timeNew2 = time.minusYears(1);
        //timeNew2 : 2022-04-04T13:43:03.741565
        
        
        //format
        /*
        ISO_DATE: Định dạng chuẩn ISO-8601 cho ngày, ví dụ: 2022-05-01

        ISO_LOCAL_DATE: Tương tự như ISO_DATE nhưng không có múi giờ hoặc 
        thông tin về múi giờ, ví dụ: 2022-05-01

        BASIC_ISO_DATE: Định dạng ngày tháng theo chuẩn ISO-8601 nhưng 
        không có ký hiệu đường chéo ("/"), ví dụ: 20220501

        ofPattern(pattern): Định dạng theo cấu trúc pattern của đối tượng 
        DateTimeFormatter được chỉ định. Ví dụ: "dd/MM/yyyy"

        ofLocalizedDate(style): Định dạng theo kiểu địa phương được chỉ định, 
        ví dụ: DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        */
        LocalDateTime lDate4 = LocalDateTime.now();
        //lDate4 : 2023-03-30T13:30:57.635774
        
        String DateFormat1 = lDate4.format(DateTimeFormatter.BASIC_ISO_DATE);
        //DateFormat1 : 20230330
        
        String DateFormat2 = lDate4.format(DateTimeFormatter.ISO_DATE_TIME);
        //DateFormat2 : 2023-03-30T13:32:55.6629522
        
        String DateFormat3 = lDate4.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        //DataFormat3 : 2023/03/30 13:35:02
        
        
        
        
        //ZonedDateTime về cơ bản giống như LocalDateTime nhưng khác nâng cao
        ZonedDateTime zDate = ZonedDateTime.now();
        //zDate: 2023-03-30T13:46:49.359704900+07:00[Asia/Bangkok]
        
        //of
        ZonedDateTime zDate2 = ZonedDateTime.of
        (1999, 01, 31, 12, 12, 12, 12, ZoneId.systemDefault());
        
        //zDate2 : 1999-01-31T12:12:12.000000012+07:00[Asia/Bangkok]
        
        //parse
        ZonedDateTime zDate3 = ZonedDateTime.parse
        ("2020-03-30T13:46:49.359704900+07:00[Asia/Bangkok]");
        String Formater = zDate3.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        //Formater: 2020/03/30 13:46:49
        
        //toLocalDateTime chuyển thành đối tượng LocalDateTime
        ZonedDateTime zDate4 = ZonedDateTime.now();
        LocalDateTime lDateFromZDate4 = zDate4.toLocalDateTime();
        //lDateFromZDate4: 2023-03-30T14:07:37.922278
        
        //withZoneSameInstant - tạo ra một đối tượng mới với khu vực mới 
        ZonedDateTime zDateOld = ZonedDateTime.now();
        //Ban đầu 2023-03-30T14:14:28.344387+07:00[Asia/Bangkok]
        ZonedDateTime zDateNew = zDateOld.withZoneSameInstant(ZoneId.of("Asia/Ho_Chi_Minh"));
        //Sau : 2023-03-30T14:14:28.344387+07:00[Asia/Ho_Chi_Minh]
        
    }
}
