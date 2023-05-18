/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_UnderstandingStatic;

/**
 *
 * @author nguye
 */
public class example {
    class Inner {
        static int a = 10;
        int b = 5;
        static void increment(){
            a++;
            //b++; error bởi bị phương thức static thì chỉ truy cập được các biến static
        }
        static {
            System.out.println("Khối static khởi tạo");
        }
    }
    
    public static void main(String[] args) {
        example.Inner inner = new example().new Inner();
        System.out.println("Giá trị ban đầu của biến a: "+inner.a); //10
        
        //Khởi tạo ra các bản sao của lớp inner
        example.Inner inner2 = new example().new Inner();
        inner2.increment();
        example.Inner inner3 = new example().new Inner();
        inner3.increment();
        
        System.out.println("Giá trị sau của biến a: "+inner.a); //12 => bị thay đổi bởi các bản sao
        
        //Khối static, phương thức static, biến static thường được ứng dụng vào việc dùng chung cho các
        //instance đối tượng được được khởi tạo với nhiều phiên bản 
        //chính vì vậy ở các bản sao inner2 và inner3 thực thi phương thức increment làm tăng giá
        //trị của biến static a
        //và a sẽ được tăng ở tất cả các bản sao đối tượng instance
    }
    
}
