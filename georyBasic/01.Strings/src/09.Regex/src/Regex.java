/**
 * Nguyễn Thái Nguyên
 * 
 * ^ tương tự như \A, chỉ định bắt đầu của chuỗi
 * \s bất kì kí tự nào trừ khoảng trắng
 * \@ bất kì kí tự nào trừ @
 * [] chỉ định một tập hợp kí tự khợp với chỉ định
 * @ ở bên ngoài thì chỉ định nhập kí tự @
 * + qui định kiểm tra được nhiều số vd: \w+ :nhập được các kí tự A-Za-z1-9_ nhiều lần 
 * \. chỉ định kí tự .. Các ký tự đặc biệt như . sẽ được thoát ra bằng cách sử dụng dấu gạch chéo trước chúng (\)
 * $ chỉ định kết thúc của chuỗi vd: $com yêu cầu cuối phải có "com"
 * . bất kì kí tự nào ngoại trừ xuống dòng
 * 
 */
package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nguye
 */
public class Regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
            Pattern là đối tượng để xử lý biểu thức chính quy
            Matcher giúp thực hiện so khớp chuỗi với biểu thức chính quy,
            sau khi biểu thức chính quy đã được biên dịch thành đối tượng Pattern
            A. Method của Matcher-------
            1.matches() kiểm tra xem chuỗi có khớp với biểu thức chính quy không
            2.group() truy xuất đến các chuỗi khớp với biểu thức chính quy
            B. Method của Pattern
            1.compile() giúp biến một chuỗi regex thành đối tượng Pattern
        */
        String regex = "([A-Z0-9]\\w+|\\w+[A-Z0-9]\\w+|\\w+[A-Z0-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sc.nextLine());
        if(matcher.matches()){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    
}
