package k_Varargs;


/**
 * Lưu ý về varargs : bạn cũng có thể nạp chồng phương thức với kiểu varargs bình thường.
 * void vaTest (double ... v)
 * void vaTest (String str, double ... v )
 * void vaTest (int a, double ... v)
 * Ví dụ trên về nạp chồng 
 */
public class varargs {
    /* Trong ví dụ này, chúng ta đã định nghĩa một phương thức printNumbers sử dụng varargs.
    Điều đó có nghĩa là chúng ta có thể truyền vào bất kỳ số lượng tham số nào, thậm chí có
    thể không truyền vào bất kỳ tham số nào. */
    static void vaTest(int ... v){
        System.out.println("Number of args: "+v.length +" contents");
        for(int n : v){
            System.out.println(n + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        vaTest(1);
        vaTest(1,2);
        vaTest(1,2,3);
        
        /* Đầu ra từ chương trình là giống với phiên bản ban đầu.
        Có hai điều quan trọng cần lưu ý về chương trình này. 
        • Thứ nhất, như đã giải thích, bên trong vaTest(), v được xử lý như một mảng. 
        Điều này là vì v là một mảng. Cú pháp ... chỉ đơn giản là cho biết với trình biên dịch
        rằng một số lượng biến số đối số sẽ được sử dụng và các đối số này sẽ được lưu trữ trong
        mảng được tham chiếu bởi v.
        • Thứ hai, trong main(), vaTest() được gọi với số lượng đối số khác nhau, 
        bao gồm không có đối số nào cả. Các đối số được tự động đưa vào một mảng và được chuyển đến v. 
        Trong trường hợp không có đối số, độ dài của mảng là không. 
        */
        
        /* Một phương thức có thể có các tham số "bình thường" cùng với một tham số có độ dài biến.
        Tuy nhiên, tham số có độ dài biến phải là tham số cuối cùng được khai báo bởi phương thức. */
        //Chập nhận => int dolt (int a, double b, int ... v)
        //Không chính xác => void dolt (int a, int ... v, boolean c)
        
        //Có một hạn chế khác cần lưu ý: chỉ có một tham số varargs
        //Chập nhận => int dolt (int a, double b, int ... v)
        //Không chính xác => void dolt (int a, int ... v, double ... v2)
        
        //Một vài ví dụ minh họa
        dolt("Argument String", 1.1, 2.2, 3.3);
    }
    static void dolt (String str, double ... v){
        System.out.println("String arg: "+str);
        for(double x : v){
            System.out.println(x + " ");
        }
        System.out.println();
    }
}
