/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package TryCatch;

/**
 *
 * @author nguye
 */
public class Throws {
    
    /* Nếu một phương thức có thể gây ra một ngoại lệ mà nó không xử lý, thì phương
    thức đó phải chỉ định throws để người gọi của phương thức có thể bảo vệ chính mình
    khỏi ngoại lệ đó. Bạn làm điều này bằng cách bao gồm một khai báo throws trong khai
    báo của phương thức. Một khai báo throws liệt kê các loại ngoại lệ mà một phương thức
    có thể gây ra. Điều này là cần thiết cho tất cả các ngoại lệ, ngoại trừ các loại 
    ngoại lệ của kiểu Error hoặc RuntimeException, hoặc bất kỳ lớp con của chúng nào. 
    Tất cả các ngoại lệ khác mà một phương thức có thể gây ra phải được khai báo trong
    khai báo throws. Nếu không, sẽ xảy ra lỗi compile-time.
    Đây là dạng tổng quát của một khai báo phương thức bao gồm một khai báo throws:
        modifier returnType methodName(parameterList) throws exceptionList {
            //body of method
        }
    */
    
    /* Dưới đây là ví dụ về một chương trình sai khi cố gắng ném ra một ngoại lệ mà nó không bắt.
    Bởi vì chương trình không chỉ định một mệnh đề "throws" để khai báo điều này, 
    nên chương trình sẽ không biên dịch được. */
    static void throwOne() {
        System.out.println("Inside throwOne.");
        //throw new IllegalAccessException("demo"); error here
    }
    
    /* Để làm cho ví dụ này biên dịch được, bạn cần thực hiện hai thay đổi. 
    Trước tiên, bạn cần khai báo rằng throwOne() có thể ném ra IllegalAccessException.
    Thứ hai, main() phải định nghĩa một câu lệnh try/catch để bắt lỗi này.

    Đây là ví dụ đã được sửa đúng: 
    Lưu ý: ví dụ dựa trên phương thức throwOne() nhưng cố tình tạo ra một phương thức throwTwo y hệt*/
    static void throwTwo() throws IllegalAccessException {
        System.out.println("Inside throwOne.");
        throw new IllegalAccessException("demo"); 
    }
    public static void main(String[] args) {
        throwOne();
        try {
            throwTwo();
        } catch (IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
    }
    
}
