/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package v_practices;

class MyClass {
    int cout = 0;
    boolean valueTest = false;
    void get(String nameThr) {
        try {
            System.out.println(nameThr + " đang lấy dữ liệu");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(nameThr+ "Interrupted");
        }
        System.out.println(nameThr +" exiting");
        synchronized (this) {
            cout++;
            notifyAll();
            /*Khi phương thức get gọi đến notifyAll thì chỉ có các luồng 
            đang ở trạng thái wait() trên đối tượng ob hoặc MyClass mới được đánh thức. 
            Các luồng đang chạy trên các đối tượng khác thì không ảnh hưởng gì. 
            Bởi vì phương thức notifyAll chỉ có tác dụng trên các luồng đang wait() 
            trên cùng một đối tượng được sở hữu bởi cùng một luồng sử dụng synchronized(this) 
            hoặc synchronized(object) trong phương thức của đối tượng đó.*/
        }
    }
    
    synchronized void handle(String nameThr) {
        while(!valueTest) {
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        try {
            System.out.println(nameThr+" đang xử lý dữ liệu ...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(nameThr+" exiting");
    }
}

class NewThread implements Runnable {
    Thread t;
    MyClass ob;
    String str;
    NewThread(MyClass o, String name) {
        str = name;
        t = new Thread(this, str);
        ob = o;
    }

    @Override
    public void run() {
        ob.get(str);
        ob.handle(str);
    }
}

public class Ex1 {

    public static void main(String[] args) {
        //Khởi tạo đối tượng MyClass
        MyClass ob = new MyClass();

        NewThread thr = new NewThread(ob, "Luồng 1");
        NewThread thr2 = new NewThread(ob, "Luồng 2");
        NewThread thr3 = new NewThread(ob, "Luồng 3");
        //Cả 3 luồng đều có đối số chung là ob

        thr.t.start();
        thr2.t.start();
        thr3.t.start();
        synchronized (ob) {
            while(ob.cout < 3){
                try {
                    ob.wait(); //Luồng main giải phóng khóa đối tượng ob và luồng khác tiếp tục thực thi
                } catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            }
            ob.valueTest = true;
            ob.notifyAll();
        }
        /*Khi một đối tượng của một class gọi phương thức wait(), nó sẽ tạm dừng 
        thực thi và giải phóng khóa của đối tượng đó, cho phép các luồng khác sử dụng 
        đối tượng đó.

        Khi một đối tượng của một class gọi phương thức notify() hoặc notifyAll(), 
        nó sẽ đánh thức một hoặc tất cả các luồng đang chờ trên đối tượng đó, 
        để chúng có thể tiếp tục thực thi.

        Các phương thức wait(), notify() và notifyAll() phải được gọi trên một đối 
        tượng đang giữ khóa của lớp đó. Nếu không, một ngoại lệ IllegalMonitorStateException 
        sẽ được ném ra.*/
    }
}
