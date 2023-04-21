/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String regex = "0[0-9]{9,10}";  // bắt đầu 0 và các số 0 - 9
        String regex2 = "[xyz]{1,10}";  // mọi kí tự x y z
        String regex3 = "\\d{1,10}";    // \d 1-9 
        String regex4 = "\\D{1,10}";    // \D ngược lại của \d chứa kí tự đặc biệt và chữ
        String regex5 = "\\w{1,10}";    // \w 1-9a-zA-Z_
        String regex6 = "\\W{1,10}";    // \W kí tự đặc biệt
        String regex7 = "\\s";          // xuống dòng, khoảng trắng, lùi đầu dòng, tab
        String regex8 = "^[0-9]{1,10}"; //^ bắt đầu bằng 
        String regex9 = ".{1,10}";      // . số, kí tự đặc biệt, chữ
        
        //{M,N} ít nhất M kí tự, nhiều nhất N kí tự
        //{N} phải nhập chính xác N kí tự
        //? [0-1]
        //* [0-N]
        //+ [1-N]
        // | hoặc
        // ^ mở đầu regex
        // $ kết thúc regex
        // \s bất kì kí tự khoảng trắng nào
        String regexSoThapPhan = "[+-]?(\\d+(\\.\\d+)?)";
        
        String regexBienSoXe = "5\\d-[A-Z]\\d-(\\d{4})|(\\d{3}\\.\\d{2})";
        
        String regexWebsite = "http://www\\.\\w+\\.\\w{2,4}";
        
        String regexSDT = "^((09|03|07|08|05)[0-9]{8})\\s+$";
        String regexEmail = "^[A-Za-z0-9\\._+-]+@[A-Za-z0-9-]+\\.[A-Za-z0-9\\.]+$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(new Scanner(System.in).nextLine());
        if(matcher.matches()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    
}
