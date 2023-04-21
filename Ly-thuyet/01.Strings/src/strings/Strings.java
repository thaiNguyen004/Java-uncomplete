/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package strings;

public class Strings {
    public static void main(String[] args) {
        //contains
        String str1 = "FPT Polytechnic";
        str1.contains("P"); //return true
        
        //indexOf 1
        String str2 = "FPT Polytechnic";
        str2.indexOf("FPT"); //return index 0 vì tìm thấy chữ FPT ở vtri 0
        
        //indexOf2
        str2.lastIndexOf("FPT", 1); 
        //return -1, tìm từ vị trí bắt đầu tới vị trí fromIndex
     
        //split 1
        String str3 = "Ngành công nghệ thông tin";
        String[] arrSplit = str3.split(" ");
        //arrSplit : ["Ngành", "công", "nghệ", "thông", "tin"]
        
        //split 2
        String[] arrSplit2 = str3.split(" ", 4);
        //arrSplit2: ["Ngành", "công", "nghệ", "thông tin"]
        
        //charAt
        String str4 = "Tôi muốn lấy chữ A";
        char a = str4.charAt(17);
        //a = A
        
        //subString
        String str5 = "Hello my friends";
        String subStr5 = str5.substring(9, 15);
        //subStr5 : friends cắt từ vị trí 9 đến vị trí 15 trong str5
        
        //equals and equalsIgnoreCase
        /*
            equals có phân biệt chữ hoa/ thường
            equalsIgnoreCase không phân biệt chữ hoa/ thường
        */
        String b = "Con chó";
        String c = "Con CHó";
        boolean bool1 = b.equals(c);
        //bool1 = false
        boolean bool2 = b.equalsIgnoreCase(c);
        //bool2 = true
        
        //replace
        String str6 = "Con mèo mướp";
        String str6RePlace = str6.replace("ướ", "ú");
        //Thay đổi các chuỗi ướ thành ú output: Con mèo múp
        
        //trim 
        String noTrim = " Nguyễn Thái Nguyên ";
        noTrim.trim();
        //output: "Nguyễn Thái Nguyên"
        
        //startsWith
        String str7 = "Trường lỏ FPT";
        boolean bool3 = str7.startsWith("Trường", 2);
        //bool3 = false
        /*  Tìm kiếm từ vị trí toffset đến hết chuỗi kiểm tra có str prefix không
            mặc định không khai báo toffset thì toffset = 0
        */
        
        //endsWith
        String str8 = "FileDeTai.pdf";
        boolean isPDF = str8.endsWith("PDF");
        //isPDF = true
        //Tìm kiếm từ cuối chuỗi kiểm tra có chuỗi "PDF" không (boolean)
        
        //concat 
        String str9 = "Cắt nội dung sau: Nội dung";
        String str10 = "Cắt nội dung sau: Nội dung";
        String str11 = str9.concat(str10);
        System.out.println(str11);
        //Nối chuỗi str9 với chuỗi str10 và gán cho str11
        
        //toLowerCase - chuyển sang viết thường
        String notToLowerCase = "NGUYỄN THÁI NGUYÊN";
        String toLowerCase = notToLowerCase.toLowerCase();
        //toLowerCase = nguyễn thái nguyên
        
        //toUpperCase - chuyển sang viết hoa
        String nottoUpperCase = "nguyễn THái NguyÊn";
        String toUpperCase = nottoUpperCase.toUpperCase();
        //toUpperCase = NGUYỄN THÁI NGUYÊN
       
        
    }

}
