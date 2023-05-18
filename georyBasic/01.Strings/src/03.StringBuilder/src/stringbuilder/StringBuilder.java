/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringbuilder;

/**
 *
 * @author nguye
 */
public class StringBuilder {
    public static void main(String[] args) {
        // Về API thì StringBuilder giống như StringBuffer
        
        //append
        java.lang.StringBuilder sbuild1 = new java.lang.StringBuilder("Nguyễn");
        sbuild1.append(" Thái Nguyên");
        System.out.println(sbuild1);
        //sbuild1 : Nguyễn Thái Nguyên
        
        //insert có thể nhập tất cả các loại dữ liệu vào một stringBuilder
        java.lang.StringBuilder sbuild2 = new java.lang.StringBuilder("I love U ");
        sbuild2.insert(9, true);
        //sbuild2 : I love U true
        
        //replace 
        java.lang.StringBuilder sbuild3 = new java.lang.StringBuilder(
        "Chú mèo dễ thương");
        sbuild3.replace(4, 7, "chó");
        //sbuild3 : Chú chó dễ thương
        
        /*
        Các method của StringBuilder không được đồng bộ hóa (non-synchronized),
        trong khi các method của StringBuffer được đồng bộ hóa (synchronized). 
        Điều này có nghĩa là nếu bạn cần sử dụng lớp StringBuilder hoặc StringBuffer
        trong một ứng dụng đa luồng (multithreaded application), bạn nên sử dụng 
        StringBuffer để tránh các vấn đề liên quan đến bộ nhớ và xung đột.

        Ngoài ra, StringBuilder được giới thiệu từ phiên bản Java 5, trong khi 
        StringBuffer đã có từ phiên bản Java 1.0. Do đó, StringBuilder có thể 
        nhanh hơn so với StringBuffer trong một số trường hợp.
        */
    }
    
}
