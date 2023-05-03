/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package i_CreateGenericMethod;

/*
Hãy bắt đầu với một ví dụ. Chương trình sau định nghĩa một lớp không generic 
được gọi là GenMethDemo và một phương thức generic tĩnh trong lớp đó được gọi là isIn (). 
Phương thức isIn () xác định xem một đối tượng có phải là thành viên của một mảng hay không. 
Nó có thể được sử dụng với bất kỳ loại đối tượng và mảng nào miễn là mảng chứa các đối tượng 
tương thích với loại đối tượng được tìm kiếm.
*/

/*Hãy xem xét isIn () kỹ. Trước hết, hãy lưu ý cách nó được khai báo bởi dòng này:
static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
Các tham số kiểu được khai báo trước kiểu trả về của phương thức. Lưu ý rằng T extends Comparable<T>. 
Comparable là một giao diện được khai báo trong java.lang. Một lớp thực hiện Comparable xác định các 
đối tượng có thể được sắp xếp. Do đó, yêu cầu giới hạn trên Comparable đảm bảo rằng isIn() 
chỉ có thể được sử dụng với các đối tượng có thể được so sánh được. Comparable là một lớp chung, 
và tham số kiểu của nó chỉ định kiểu đối tượng mà nó so sánh. Tham số kiểu của Comparable có tác dụng 
là chỉ định kiểu đối tượng mà đối tượng hiện tại của Comparable có thể so sánh được. 
Ví dụ, nếu một lớp MyObject implements Comparable<MyObject>, thì nó có thể so sánh được 
với các đối tượng khác của kiểu MyObject. Thông qua việc chỉ định tham số kiểu, ta có thể đảm bảo 
rằng chỉ có các đối tượng có kiểu tương tự nhau mới có thể so sánh được với nhau. 
(Sau đây, bạn sẽ thấy cách tạo một giao diện chung.) Tiếp theo, lưu ý rằng kiểu V được giới hạn bởi T. 
Do đó, V phải là cùng kiểu với T hoặc là một lớp con của T. Mối quan hệ này đảm bảo rằng isIn () chỉ 
có thể được gọi với các đối số tương thích với nhau. Hãy lưu ý rằng isIn () là tĩnh, cho phép nó được 
gọi độc lập với bất kỳ đối tượng nào. Tuy nhiên, phương thức chung có thể là tĩnh hoặc không tĩnh. 
Không có hạn chế nào trong vấn đề này.*/
class GenMethDemo {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y){
        for (int i = 0; i < y.length ; i++){
            if(x.equals(y[i])) return true;
        }
        return false;
    }
}
public class example {

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        if(GenMethDemo.isIn(3, nums)){
            System.out.println("3 is in nums");
        }
        String strs[] = {"Hello", "World"};
        if(GenMethDemo.isIn("Hello", strs)){
            System.out.println("Hello is in strs");
        }
        
        Double dnums[] = {1.2, 2.3, 3.5};
        if(GenMethDemo.<Double, Double>isIn(4.3, dnums)){
            System.out.println("4.3 is in dnums");
        }
        
//        String strs2[] = {"Nguyễn", "Thái", "Nguyên"};
//        if(GenMethDemo.isIn(4, strs2)){
//            System.out.println("Phương thức này lỗi!");
//        }

/*Hãy xem đoạn code bị chú thích dưới đây:
Nếu bạn xóa bỏ các chú thích và sau đó cố gắng biên dịch chương trình, bạn sẽ nhận được một lỗi. 
Lý do là tham số kiểu V được giới hạn bởi T trong mệnh đề extends trong khai báo của V. Điều này 
có nghĩa là V phải là kiểu T hoặc là một lớp con của T. Trong trường hợp này, đối số đầu tiên có kiểu Integer, 
làm cho T trở thành Integer, nhưng đối số thứ hai có kiểu String, không phải là một lớp con của Integer. 
Điều này gây ra lỗi không phù hợp kiểu tại thời điểm biên dịch. Khả năng này để áp dụng tính an toàn kiểu 
là một trong những lợi thế quan trọng nhất của các phương thức chung. Cú pháp được sử dụng để tạo ra isIn () 
có thể được tổng quát hóa. Đây là cú pháp cho một phương thức chung:

<type-param-list> ret-type meth-name (param-list) { // ...

Trong tất cả các trường hợp, type-param-list là một danh sách tham số kiểu được phân tách bằng dấu phẩy. 
Lưu ý rằng đối với một phương thức chung, danh sách tham số kiểu đứng trước kiểu trả về.*/
    }
    
}
