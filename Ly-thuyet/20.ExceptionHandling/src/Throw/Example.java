/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package Throw;

/**
 *
 * @author nguye
 */
public class Example {

    /* Đến nay, bạn chỉ bắt các ngoại lệ được ném bởi hệ thống chạy Java. Tuy nhiên,
        chương trình của bạn có thể ném một ngoại lệ một cách rõ ràng bằng cách sử dụng
        câu lệnh throw. Định dạng chung của throw được hiển thị ở đây: 
        
        throw ThrowableInstance;

     */
 /* Ở đây, ThrowableInstance phải là một đối tượng thuộc loại Throwable hoặc một 
        lớp con của Throwable. Các kiểu nguyên thủy, như int hoặc char, cũng như các lớp
        không phải Throwable, như String và Object, không thể được sử dụng như các ngoại lệ. 
        Có hai cách để bạn có thể lấy một đối tượng Throwable: 
            • Sử dụng tham số trong mệnh đề catch 
            • Hoặc tạo một đối tượng mới bằng toán tử new.
        Luồng thực thi ngừng ngay sau câu lệnh throw; 
        bất kỳ câu lệnh tiếp theo sẽ không được thực thi. Khối try bao quanh gần nhất được kiểm tra
        để xem nó có câu lệnh catch phù hợp với loại ngoại lệ hay không. Nếu tìm thấy phù hợp, 
        điều khiển được chuyển đến câu lệnh đó. Nếu không, thì khối try bao quanh kế tiếp được kiểm tra
        và tiếp tục như vậy. Nếu không tìm thấy catch phù hợp nào, thì bộ xử lý ngoại lệ mặc định 
        dừng chương trình và in ra đám xếp ngăn xếp (stack trace).
        Đây là một chương trình mẫu
        tạo và ném một ngoại lệ. Các trình xử lý bắt ngoại lệ sẽ ném lại ngoại lệ đó cho trình xử lý bên ngoài.*/
    static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Caught inside demoproc()");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Recaught : " + e);
        }
    }
    /* Chương trình này được cơ hội để xử lý cùng một lỗi hai lần. Đầu tiên, main() 
    thiết lập một ngữ cảnh ngoại lệ và sau đó gọi đến demoproc(). Phương thức 
    demoproc() sau đó thiết lập một ngữ cảnh xử lý ngoại lệ khác và ngay lập tức ném ra 
    một trường hợp mới của NullPointerException, được bắt được trên dòng kế tiếp. 
    Sau đó, ngoại lệ được ném lại. Đây là kết quả đầu ra:
        Caught inside demoproc.
        Recaught: java.lang.NullPointerException: demo
    Chương trình cũng minh họa cách tạo ra một số đối tượng ngoại lệ tiêu chuẩn của Java. 
    Hãy chú ý đến dòng này:
    throw new NullPointerException("demo");
    Ở đây, từ khóa "new" được sử dụng để xây dựng một trường hợp của NullPointerException.
    Nhiều ngoại lệ run-time được tích hợp sẵn của Java có ít nhất hai bộ tạo: 
    một không có tham số và một nhận một tham số chuỗi. Khi sử dụng dạng thứ hai, đối số chỉ định
    một chuỗi mô tả ngoại lệ. Chuỗi này được hiển thị khi đối tượng được sử dụng làm đối số cho print()
    hoặc println(). Nó cũng có thể được lấy bằng cách gọi getMessage(), được định nghĩa bởi Throwable.*/
}
