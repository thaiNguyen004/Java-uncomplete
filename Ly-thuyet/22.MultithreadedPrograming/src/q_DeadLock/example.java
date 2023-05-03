/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package q_DeadLock;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "entered A.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(name + " try to be call B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}
class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "entered B.bar");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(name + " try to be call A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}

class DeadLock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;

    public DeadLock() {
        Thread.currentThread().setName("Main thread");
        t = new Thread(this, "Racing thread");
    }
    void DeadLockStart(){
        t.start();
        a.foo(b);
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back in other thread");
    }
}

public class example {

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        dl.DeadLockStart();
        /* Bạn thấy rằng Luồng Racing thread sở hữu monitor của B, còn luồng main thì
        sở hữu monitor của A, sau đó luồng Racing thread cố gắng muốn truy cập vào một 
        phương thức đồng bộ hóa mà một luồng khác (luồng main) đang nắm quyền monitor trên lớp đó, 
        khi này luồng sẽ phải đợi, 
        tuy nhiên luồng main cũng muốn yêu cầu truy cập vào phương thức đồng bộ hóa mà luồng Racing thread
        đang nắm giữ khóa của lớp đó và cũng sẽ phải đợi 
        => khi đó sẽ xảy ra deadlock và chương trình sẽ không bao giờ dừng*/
    }
}
