/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package UsingObjectAsParameters;

/*
    Cho đến nay, chúng ta chỉ sử dụng các loại đơn giản như tham số cho các phương thức.
    Tuy nhiên, việc truyền các đối tượng vào phương thức là đúng và phổ biến. 
    Ví dụ, xem xét chương trình ngắn sau đây:
*/

class Test {
    int a, b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }
    boolean equalTo(Test o) {
        if (o.a == a && o.b == b) return true;
        else return false;
    }
}

/* Một trong những ứng dụng phổ biến nhất của tham số đối tượng liên quan đến các constructor. 
Thường xuyên, bạn muốn tạo một đối tượng mới để ban đầu nó giống như một đối tượng hiện có nào đó.
Để làm điều này, bạn phải xác định một constructor lấy một đối tượng của lớp của nó làm tham số. 
Ví dụ, phiên bản sau của Box cho phép một đối tượng khởi tạo một đối tượng khác: */
class Box {
    double width;
    double height;
    double depth;
    Box (Box o){ //truyền đối tượng cho constructor
        width = o.width;
        height = o.height;
        depth = o.depth;
    }
    //Constructor được khởi tạo khi tất cả các kích thược được xác định
    Box (double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
    
    Box () {
        width = -1; // sử dụng giá trị -1 để biểu thị
        height = -1; // 
        depth = -1;
    }
    
    double volume(){
        return width * height * depth;
    }    
}
public class example {
    public static void main(String[] args) {
        Test o1 = new Test(100, 200);
        Test o2 = new Test(100, 400);
        Test o3 = new Test(100, 200);
        System.out.println(o1.equalTo(o3)); //true
        System.out.println(o1.equalTo(o2)); //false
        
        //class Box
        Box box1 = new Box(10, 10, 10);
        Box box2 = new Box(box1);
        System.out.println("Diện tích box1 : "+box1.volume());
        System.out.println("Diện tích box2 : "+box2.volume());
        
        /* Như bạn sẽ thấy khi bắt đầu tạo các lớp của riêng mình, việc cung cấp
        nhiều hình thức của constructor thường được yêu cầu để cho phép các đối tượng
        được xây dựng một cách tiện lợi và hiệu quả.*/
    }
    
}
