/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package p_InterthreadCommunication;

/* Các phương thức này được khai báo trong Object, như được hiển thị ở đây:
    final void wait() throws InterruptedException
    final void notify()
    final void notifyAll()
Có các dạng khác của wait() cho phép bạn chỉ định một khoảng thời gian chờ.
Trước khi tiếp tục với ví dụ minh họa về giao tiếp giữa các luồng, cần phải lưu ý 
một điểm quan trọng. Mặc dù wait() thường chờ đợi cho đến khi notify() hoặc notifyAll() được gọi, 
nhưng có khả năng rất hiếm gặp rằng luồng đang chờ sẽ được đánh thức do một sự thức tỉnh không mong muốn. 
Trong trường hợp này, một luồng đang chờ đợi sẽ tiếp tục thực thi mà không có notify() hoặc notifyAll() 
đã được gọi (tức là, luồng tiếp tục thực thi mà không có lý do rõ ràng). Vì khả năng này rất hiếm gặp, 
tài liệu API của Java khuyến khích các cuộc gọi wait() nên được thực hiện trong một vòng lặp kiểm tra điều kiện 
mà luồng đang chờ đợi. Ví dụ sau đây cho thấy kỹ thuật này.
Bây giờ chúng ta sẽ làm việc qua một ví dụ sử dụng wait() và notify(). 
Để bắt đầu, hãy xem chương trình mẫu sau đây mà thực hiện không chính xác một dạng đơn giản 
của vấn đề sản xuất / tiêu thụ. Nó bao gồm bốn lớp: 
    Q, hàng đợi mà bạn đang cố gắng đồng bộ hóa; 
    Producer, đối tượng theo luồng đang sản xuất các mục hàng đợi; 
    Consumer, đối tượng theo luồng đang tiêu thụ các mục hàng đợi; và 
    PC, lớp nhỏ tạo ra Q, Producer và Consumer duy nhất.
 */

//An incorrect implementation of a producer and consumer
class Q {

    int n;

    synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }

    synchronized void push(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}

class Producer implements Runnable {

    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.push(i++);
        }
    }
}

class Consumer implements Runnable {

    Q q;
    Thread t;

    public Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

public class example {

    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

//        producer.t.start();
//        consumer.t.start();
        Q2 q2 = new Q2();
        Producer2 producer2 = new Producer2(q2);
        Consumer2 consumer2 = new Consumer2(q2);

        producer2.t.start();
        consumer2.t.start();

        
    }
    /* Mặc dù các phương thức put () và get () trên Q được đồng bộ hóa, nhưng 
    không có gì ngăn chặn nhà sản xuất khỏi việc vượt qua người tiêu thụ, 
    cũng như không có gì ngăn chặn người tiêu thụ tiêu thụ cùng một giá trị hàng đợi hai lần. 
    Do đó, bạn nhận được đầu ra sai lầm được hiển thị ở đây 
    (đầu ra chính xác sẽ thay đổi với tốc độ bộ xử lý và tải nhiệm vụ): 
        Put: 1
        Got: 1
        Got: 1
        Got: 1
        Got: 1
        Got: 1
        Put: 2
        Put: 3
        Put: 4
        Put: 5
        Put: 6
        Put: 7
        Got: 7
    Như bạn có thể thấy, sau khi producer push 1, consumer bắt đầu và get 1 giá trị năm lần liên tiếp. 
    Sau đó, producer tiếp tục sản xuất từ 2 đến 7 mà không cho consumer có cơ hội tiêu thụ chúng.

    Cách đúng để viết chương trình này trong Java là sử dụng wait() và notify() 
    để đồng bộ hóa theo cả hai hướng, như được thể hiện ở đây:
     */
}
//Correct implementation

class Q2 {

    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException Caught");
        }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void push(int n) {
        while (valueSet)
            try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException Caught");
        }
        this.n = n;
        valueSet = true; 
        /* khi có dữ liệu thì valueSet sẽ thay đổi thành true để thông báo rằng có dữ liệu
        để lấy và gọi notify() báo hiệu cho lớp Consumer và có thể lấy dữ liệu*/
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer2 implements Runnable {

    Q2 q;
    Thread t;

    public Producer2(Q2 q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.push(i++);
        }
    }
}

class Consumer2 implements Runnable {

    Q2 q;
    Thread t;

    public Consumer2(Q2 q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
