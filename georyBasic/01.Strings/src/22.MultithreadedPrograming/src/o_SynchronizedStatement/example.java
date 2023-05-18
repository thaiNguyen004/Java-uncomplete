/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package o_SynchronizedStatement;

/*
Để đồng bộ truy cập đến các đối tượng của một lớp không được thiết kế cho việc truy cập 
đa luồng, không sử dụng các phương thức đồng bộ, bạn cần sử dụng một cách khác để đạt 
được đồng bộ hóa. Ví dụ, lớp đó không phải do bạn tạo ra mà được tạo bởi một bên thứ ba 
và bạn không có quyền truy cập vào mã nguồn. Vậy làm thế nào để đồng bộ truy cập đến 
một đối tượng của lớp đó?

May mắn thay, giải pháp cho vấn đề này khá đơn giản: bạn chỉ cần đặt các cuộc gọi 
đến các phương thức được định nghĩa bởi lớp này trong một khối synchronized.
Đây là cú pháp chung của lệnh synchronized:
    synchronized(obRef) {
      //statements to be synchronized
    }
*/
//Giả sử lớp Callme là lớp bên thứ 3 và không được xây dựng để giải quyết vấn đề
//đồng bộ hóa
class Callme {
    void call (String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller extends Thread {
    String msg;
    Thread t;
    Callme target;
    Caller (Callme targ, String str){
        msg = str;
        target = targ;
        t = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (target) {
            //Synchronized methods
            target.call(msg);
        }
    }
    
}
/* Trong phiên bản này, phương thức run() chứa một khối synchronized. Biến target, 
là tham chiếu đến đối tượng Callme, được sử dụng như một đối tượng đồng bộ hóa cho 
khối synchronized. Khi một thread gọi phương thức run() trên một đối tượng Caller, 
nó sẽ vào khối synchronized và chỉ có thể gọi phương thức call() trên target sau 
khi đã thành công trong việc nhập vào monitor của target.

Việc sử dụng khối synchronized cho phép bạn đồng bộ hóa quy trình truy cập đối tượng 
trong các trường hợp mà bạn không thể tạo ra các phương thức được đồng bộ hóa trực tiếp 
trong các lớp mà bạn không kiểm soát được. */

public class example {

    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
    }
    
}
