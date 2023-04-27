/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package CreatingYourOwnException;
/*
    Exception định nghĩa 4 hàm khởi tạo công khai. Hai trong số đó hỗ trợ việc 
    xử lý ngoại lệ được liên kết (chained exceptions) sẽ được mô tả sau. Hai phần khác
    được mô tả ngay bên dưới là Exception() và Exception(String msg)
    Hàm khởi tạo đầu tiên tạo ra một ngoại lệ không có mô tả. Hàm khởi tạo thứ hai cho phép bạn
    chỉ định một mô tả cho ngoại lệ. 
    Mặc dù việc chỉ định một mô tả khi tạo ra một ngoại lệ thường hữu ích, đôi khi tốt hơn là ghi đè
    lên phương thức toString( ). Lý do là phiên bản toString( ) được định nghĩa bởi Throwable 
    (và được kế thừa bởi Exception) đầu tiên hiển thị `tên ngoại lệ` theo sau là `dấu hai chấm`, 
    tiếp theo là `mô tả của bạn`. Bằng cách ghi đè phương thức toString( ), bạn có thể ngăn tên ngoại lệ
    và dấu hai chấm từ việc được hiển thị. Điều này tạo ra một đầu ra sạch sẽ, điều mà mong muốn 
    trong một số trường hợp.
    Ví dụ sau định nghĩa một lớp con mới của Exception và sau đó sử dụng lớp con đó để báo hiệu 
    một điều kiện lỗi trong một phương thức. Nó ghi đè phương thức toString( ), cho phép
    một mô tả được chỉnh sửa cẩn thận của ngoại lệ được hiển thị.
*/
class MyException extends Exception {
    private int detail;

    MyException (int a){
        detail = a;
    }
    MyException (){
    }
    public String toString(){
        return "MyException ["+ detail +"]";
    }
}
public class example{
    static void compute(int a) throws MyException {
        System.out.println("Giá trị của a: "+ a );
        if(a > 10) {
            throw new MyException(a);
        }
        System.out.println("Thoát bình thường");

    }
    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Caught: "+e);
        }
        /*
            Giá trị của a: 1
            Thoát bình thường
            Giá trị của a: 20
            Caught: MyException [20]
        Trong đó `MyException [20]` là nội dung được qui định trong phương thức toString()
        */
    }
    
}
