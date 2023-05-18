/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numberformatt;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Trước khi đọc thì phải hiểu tác dụng của NumberFormat
 * NumberFormat là một lớp giúp định dạng số theo tiền tệ hoặc là định dạng
 * phần trăm, set chữ số sau dấu thập phân
 * @author nguye
 */
public class NumberFormatt {
    public static void main(String[] args) {
        //getInstance
        NumberFormat nf = NumberFormat.getInstance();
        int number1 = 100000000;
        String numbernf = nf.format(number1);
        //output: 100,000,000
        
        //getCurrencyInstance 
        /*
            Vì locale ở getCurrencyInstance không hỗ trợ vùng VietNam
            => Gọi đến đối tượng Locale
        */
        Locale lc = new Locale("vn", "VN");
        NumberFormat nf2 = NumberFormat.getCurrencyInstance(lc);
        int numbernf2 = 500000;
        String current = nf2.format(numbernf2);
        //output: ₫ 500,000
        
        //parse và doubleValue, intValue, floatValue
        NumberFormat nf3 = NumberFormat.getInstance();
        String numberString = "1,324,111";
        try {
            double parseNumber = nf3.parse(numberString).doubleValue();
            System.out.println(parseNumber);
        } catch (Exception e) {
            System.out.println("Unable parse to string");
        }
        
        //isParseIntegerOnly
        
        
    }
    
}
