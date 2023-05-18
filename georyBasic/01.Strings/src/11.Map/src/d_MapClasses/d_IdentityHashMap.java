/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_MapClasses;

/*
Lớp IdentityHashMap mở rộng AbstractMap và triển khai giao diện Map. Nó tương tự như HashMap, 
tuy nhiên nó sử dụng tính bằng tham chiếu khi so sánh các phần tử. IdentityHashMap là một lớp 
generic với khai báo như sau:

class IdentityHashMap<K, V>

Ở đây, K chỉ ra kiểu của khóa và V chỉ ra kiểu của giá trị. Tài liệu API rõ ràng chỉ
ra rằng IdentityHashMap không dành cho việc sử dụng chung chung.
Điều này có nghĩa là, IdentityHashMap không phải là một lớp đại diện cho một cấu trúc
dữ liệu bình thường, phổ biến được sử dụng trong lập trình Java. Thay vào đó, 
nó được thiết kế để giải quyết các vấn đề cụ thể, như khi cần so sánh các đối tượng
theo định danh của chúng thay vì so sánh theo giá trị. Trong hầu hết các trường hợp, 
HashMap hoặc TreeMap sẽ là những lựa chọn tốt hơn cho các tác vụ phổ biến hơn.

*/
public class d_IdentityHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
