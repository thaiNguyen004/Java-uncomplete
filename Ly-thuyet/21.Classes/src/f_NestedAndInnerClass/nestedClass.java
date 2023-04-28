/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package f_NestedAndInnerClass;

/* Example01

    Nested class có 2 kiểu là static và non-static 
        ▪ static : Nested class 
        ▪ non-static : Inner Class

    Trong Java bạn có thể định nghĩa một lớp bên trong một lớp khác. Phạm vi của lớp
    bên trong được giới hạn bởi lớp bao quanh nó. Vì vậy, nếu lớp B được định nghĩa 
    trong lớp A, thì B không tồn tại độc lập với A. 
    Một lớp lồng nhau có quyền truy cập vào các thành viên, bao gồm các thành viên 
    riêng tư, của lớp bao quanh. Tuy nhiên, lớp bao quanh không có quyền truy cập vào 
    các thành viên của lớp lồng nhau. Một lớp lồng nhau được khai báo trực tiếp trong
    phạm vi lớp bao quanh của nó là thành viên của lớp bao quanh. Ngoài ra, bạn cũng có
    thể khai báo một lớp lồng nhau là cục bộ trong một khối. 

    Example02
    Ngoài ra, bạn cũng có thể khai báo một lớp lồng nhau là cục bộ trong một khối.
    Một nested class cục bộ là một lớp lồng nhau được khai báo trong phạm vi một 
    khối bên trong một phương thức hoặc khối mã. Lớp lồng nhau này chỉ có thể được truy cập 
    bên trong khối hoặc phương thức mà nó được khai báo. Bên ngoài phạm vi đó, lớp lồng nhau này 
    không còn tồn tại và không thể được truy cập. Việc khai báo lớp lồng nhau cục bộ có thể hữu ích
    khi cần tạo một lớp nhỏ để thực hiện một nhiệm vụ cụ thể mà không cần định nghĩa lớp độc lập.VD-02

    Example03
    Có hai loại lớp lồng nhau: tĩnh và không tĩnh. Một lớp lồng tĩnh là một lớp có từ khóa static được 
    áp dụng. Vì nó là tĩnh, nó phải truy cập vào các thành viên không tĩnh của lớp bao quanh thông qua một 
    đối tượng. Nghĩa là, nó không thể trực tiếp tham chiếu đến các thành viên không tĩnh của lớp bao quanh.
    Do hạn chế này, lớp lồng tĩnh hiếm khi được sử dụng. Còn lớp không tĩnh thì ngược lại có thể truy cập được 
    tất cả các thành viên của lớp bao quanh
 */
class example01 {

    private int outer_x = 10;

    class inner {

        int inner_x = 20;

        //Lớp lồng nhau có thể truy cập vào các thành viên của lớp bao quanh là outer_x
        void displayOuter_x() {
            System.out.println(outer_x);
        }
    }

    void display() {
        //System.out.println(inner_x); error
    }

    //Cách truy cập đơn giản đến inner class
    //Cách 2 ở trong main
    void test() {
        inner inner = new inner();
        inner.displayOuter_x();
    }

    inner Return() {
        return new inner();
    }
}

class example02 {

    static int outer_x = 11;

    /* Ở đây `inner` được tạo bên trong phương thức LocalInner nên nó chỉ được 
       sử dụng bên trong phương thức LocalInner, nó không thể được truy cập từ bên ngoài
       phương thức đó và cũng không truy cập được từ các phương thức khác của lớp bao quanh. 
       Tuy nhiên inner vẫn là một inner class của lớp example02 nên nó vẫn có quyền truy cập vào 
       các thành viên của lớp example02
     */

    void LocalInner() { //methods
        class inner { //class cục bộ trong methods

            void display() {
                System.out.println(outer_x);
            }
        }
        inner in = new inner();
        in.display();
    }

    void loop() {
        for (int i = 0; i < 5; i++) {
            class inner {

                void display() {
                    System.out.println(outer_x);
                }
            }
            inner in = new inner();
            in.display();
        }
    }
}

class example03 {

    int x = 111;
    static int y = 222;

    static class nested {

        void display() {
            //Không trực tiếp truy cập được
            //System.out.println(x); => error 

            //Muốn truy cập x phải thông qua đối tượng
            example03 e = new example03();
            System.out.println(e.x);

            //được phép
            System.out.println(y);
        }
    }
}

public class nestedClass {

    public static void main(String[] args) {
        //Cách khởi tạo tham chiếu tới lớp inner 
        example01 e = new example01(); //khởi tạo đối tượng bao quanh
        example01.inner inner = e.new inner(); //khởi tạo đối tượng lồng nhau thông qua đối tượng bao quanh
        inner.displayOuter_x(); //10

        //Cách truy cập một class được viết trong một hàm hoặc viết trong một khối code
        /* Lưu ý: sẽ không có cách nào hợp lệ để truy cập một class được viết trong một khối code hay một phương thức
        ở phạm vi ngoài cả. Nói cách khác sẽ không thể truy cập từ bên ngoài hay từ một phương thức khác. 
        Giống như cách chúng ta vẫn hay làm với một class bình thường*/
        example02 e2 = new example02(); //khởi tạo đối tượng e2 là lớp bao quanh
       
        e2.LocalInner(); //phương thức LocalInner() đã khởi tạo một đối tượng inner và gọi phương thức display()
        //mọi thứ được diễn ra thông qua lời gọi phương thức LocalInner
        
        e2.loop(); //phương thức loop() đã tạo một vòng lặp và mỗi một lần lặp ta đã tạo một class bên trong
        //đồng thời khởi tạo bằng từ new và sử dụng phương thức display()
        //mọi thứ được diễn ra thông qua lời gọi phương thưc loop()

        
        /*Trong ví dụ 3 ta khởi tạo một nested class hay còn gọi là static inner class
        trong lớp example3 
        Cách khởi nested class không giống như cách khởi tạo một innerclass cục bộ trong hàm
        hay một khối code. Bởi vì một class được viết trong một hàm nó đã bị giới hạn phạm vi
        Tuy nhiên nested class và inner class thì đều có thể được khởi tạo ở bất kì đâu
        nested class có một điểm khác so với inner class
            ▪ nếu như inner class chỉ được khởi tạo với điều kiện là phải khởi tạo class class bao quanh
            thì nested class lại có thể được khởi tạo bình tường thư bao class khác mà không cần phải 
            khởi tạo class bao quanh nhưng phải thông qua `.` xem ví dụ bên dưới
        */
        example03.nested nes = new example03.nested();
        nes.display();
        
        
        //Tóm lại
        //Outer out = new Outer();
        //Outer.Inner inner = out.new Inner(); => Đây là inner class
        
        //Outer.Nested nested = new Outer.Nested(); => đây là nested class
        
        //Còn lại inner cục bộ thì chỉ có thể khởi tạo bình thường trong khối cục bộ đó
    }

}
