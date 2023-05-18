/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package f_BoundedTypes;

/*
Trong các ví dụ trước đó, các tham số kiểu có thể được thay thế bằng bất kỳ loại lớp nào. 
Điều này là tốt cho nhiều mục đích, nhưng đôi khi nó hữu ích để giới hạn các loại có thể được 
chuyển đến một tham số kiểu. Ví dụ, giả sử bạn muốn tạo một lớp chung chứa một phương thức trả 
về giá trị trung bình của một mảng số. Hơn nữa, bạn muốn sử dụng lớp này để tính giá trị trung bình 
của một mảng bất kỳ loại số nào, bao gồm số nguyên, số dấu phẩy động và số thực. 
Do đó, bạn muốn chỉ định kiểu số theo cách chung, sử dụng một tham số kiểu. 
Để tạo một lớp như vậy, bạn có thể thử một cái gì đó như thế này: 
*/

//Stats cố gắng (không thành công) tạo ra một lớp generic để tính toán giá trị trung bình
//của một mảng số với bất kỳ kiểu dữ liệu nào
class Stats <T> {
    T[] nums; //nums làm một array kiểu T
    Stats (T[] o){
        nums = o;
    }
    
    //Trả về kiểu Double trong tất cả các trường hợp
    double average(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++){
            //sum += nums[i].doubleValue(); lỗi!
        }
        return sum / nums.length;
    }
}

/*Trong Stats, phương thức average() cố gắng lấy giá trị double của mỗi số 
trong mảng nums bằng cách gọi doubleValue(). Bởi vì tất cả các lớp số như 
Integer và Double đều là lớp con của Number, và Number định nghĩa phương thức doubleValue(), 
nên phương thức này có sẵn cho tất cả các lớp bao đóng số. Tuy nhiên, trình biên dịch không 
biết rằng bạn đang có ý tạo các đối tượng Stats bằng cách sử dụng chỉ các kiểu số học. 
Do đó, khi bạn cố gắng biên dịch Stats, một lỗi được báo cáo cho biết phương thức doubleValue() 
không xác định. Để giải quyết vấn đề này, bạn cần một cách nào đó để cho trình biên dịch biết 
rằng bạn có ý chỉ truyền các kiểu số học cho T. Hơn nữa, bạn cần một cách nào đó để đảm bảo rằng 
chỉ có các kiểu số học được truyền thực sự.
Để xử lý các tình huống như vậy, Java cung cấp các kiểu có giới hạn (bounded types). 
Khi chỉ định một tham số kiểu, bạn có thể tạo một giới hạn trên đỉnh, 
xkhai báo lớp cha từ đó tất cả các đối số kiểu phải được xuất phát. 
Điều này được thực hiện thông qua việc sử dụng mệnh đề extends khi chỉ định tham số kiểu, 
như được thể hiện ở đây:  <T extends superclass>    

Điều này chỉ định rằng T chỉ có thể được thay thế bằng superclass, hoặc các subclass của superclass. 
Do đó, superclass xác định một giới hạn trên bao gồm cả nó.
*/

//Thực hiện lại
class Stats2 <T extends Number> {
    T[] nums; //nums làm một array kiểu T extends Number
    Stats2 (T[] o){
        nums = o;
    }
    
    //Trả về kiểu Double trong tất cả các trường hợp
    double average(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i].doubleValue(); //Không lỗi
        }
        return sum / nums.length;
    }
}
public class example {
    public static void main(String[] args) {
        Integer inums[] = {1, 2, 3, 4, 9};
        Stats2<Integer> iob = new Stats2<Integer>(inums);
        System.out.println("Average of Integer: "+iob.average());
    
        Double dnums[] = {1.0, 2.0, 3.0, 4.0, 8.0};
        var dob = new Stats2<Double>(dnums);
        System.out.println("Average of Double: "+dob.average());
        
        String strnums[] = {"1", "2", "3", "4", "5"};
//      var strob = new Stats2<String>(strnums); lỗi! 
//      System.out.println("Average of String: "+strob.average());


/*
Chú ý rằng lớp Stats2 được khai báo bằng dòng này:
class Stats2<T extends Number> {
Bởi vì kiểu T giờ đây được giới hạn bởi lớp Number, trình biên dịch Java biết rằng 
tất cả các đối tượng của kiểu T có thể gọi doubleValue() vì đó là một phương thức được 
khai báo bởi lớp Number. Điều này là một lợi thế quan trọng. Tuy nhiên, như một lợi ích 
bổ sung, việc giới hạn kiểu T cũng ngăn chặn việc tạo ra các đối tượng Stats không phải là 
kiểu số. Ví dụ, nếu bạn thử loại bỏ các comment ở cuối chương trình và sau đó cố gắng biên dịch lại, 
bạn sẽ nhận được lỗi biên dịch vì String không phải là một lớp con của Number.

Ngoài việc sử dụng một kiểu lớp để giới hạn, bạn cũng có thể sử dụng một kiểu giao diện. 
Trong thực tế, bạn có thể chỉ định nhiều giao diện để giới hạn. Hơn nữa, một giới hạn có thể 
bao gồm cả kiểu lớp và một hoặc nhiều giao diện. Trong trường hợp này, kiểu lớp phải được 
chỉ định trước. Khi một giới hạn bao gồm một kiểu giao diện, chỉ các đối số kiểu 
thực hiện giao diện đó mới được phép. Khi chỉ định một giới hạn có một lớp và một giao diện, 
hoặc nhiều giao diện, sử dụng toán tử `&` để kết nối chúng. Điều này tạo ra một kiểu giao cắt 
(intersection type). Ví dụ:
    //Đây chính là kiểu giao cắt (intersection type)
    class Gen<T extends MyClass & MyInterface> { 
        // ...
Ở đây, T được giới hạn bởi một lớp gọi là MyClass và một giao diện gọi là MyInterface. 
Do đó, bất kỳ đối số kiểu nào được truyền vào T đều phải là một lớp con của MyClass
và thực hiện MyInterface. Như một điểm thú vị, bạn cũng có thể sử dụng một kiểu 
giao cắt trong một lệnh ép kiểu.
*/
    }
    
}
