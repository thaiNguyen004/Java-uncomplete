/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringbuffer;
public class StringBuffer {
    public static void main(String[] args) {
        /*  Lưu ý rằng StringBuffer là một đối tượng được sử dụng để xây dựng và 
            sửa đổi các chuỗi kí tự không thay đổi (immutable) trong Java. Do đó, 
            nó chủ yếu được sử dụng để hiệu chỉnh các chuỗi này, chứ không phải để
            thay đổi các chuỗi trong nó. Nếu bạn muốn thay đổi các chuỗi, hãy sử dụng
            StringBuilder thay vì StringBuffer.
         */
        
        //append 
        java.lang.StringBuffer sbuff = new java.lang.StringBuffer("Nguyễn");
        sbuff.append(" Thái Nguyên");
        System.out.println(sbuff);
        //sbuff sẽ chuyển thành Study tonight ngay lập tức
        
        //insert có thể nhập tất cả các loại dữ liệu vào một stringBuffer
        java.lang.StringBuffer sbuff2 = new java.lang.StringBuffer("I love U ");
        sbuff2.insert(9, true);
        //sbuff2 : I love U true
        
        //replace 
        java.lang.StringBuffer sbuff3 = new java.lang.StringBuffer(
        "Chú mèo dễ thương");
        sbuff3.replace(4, 7, "chó");
        System.out.println(sbuff3);
        //sbuff3 : Chú chó dễ thương
        
        //delete
        java.lang.StringBuffer sbuff4 = new java.lang.StringBuffer(
        "Cơm nay ngon vcl");
        sbuff4.delete(sbuff4.indexOf("vcl"), sbuff4.indexOf("vcl") + 3);
        System.out.println(sbuff4);
        //Cơm nay ngon
        
        //reverse
        java.lang.StringBuffer sbuff5 = new java.lang.StringBuffer(
        "Nguyễn Thái Nguyên");
        sbuff5.reverse();
        //sbuff5 : nêyugN iáhT nễyugN
        
        //capacity
        System.out.println(sbuff5.capacity());
        //sbuff5 có length là 17 nhưng sbuff5.capacity() trả về 34
        /*  Phương thức capacity() sẽ trả về dung lượng hiện tại của đối tượng 
            StringBuffer đó, tức là số ký tự tối đa mà đối tượng StringBuffer đó có 
            thể chứa mà không cần phải tăng kích thước của bộ nhớ.
        */
        
        //ensureCapacity
        /*
            bảo rằng bộ nhớ được cấp phát cho đối tượng StringBuffer đủ lớn để 
            chứa một số ký tự cần thiết, từ đó giúp cải thiện hiệu suất của chương trình.
        */
        java.lang.StringBuffer sbuff6 = new java.lang.StringBuffer();
        sbuff6.ensureCapacity(50);
        //đảm bảo rằng sbuff6 đủ dung lượng để chứa 50 kí tự
        
        //substring(int beginIndex) giống xử lý chuỗi thông thường
        //substring(int beginIndex, int endIndex) giống xử lý chuỗi thông thường
        
        //charAt(int index) giống xử lý chuỗi thông thường

        //length() trả về số lượng kí tự trong chuỗi
        
    }

}
