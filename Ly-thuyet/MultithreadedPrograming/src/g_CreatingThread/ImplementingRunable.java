/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package g_CreatingThread;

/**
 * ImplementingRunable
 * @author nguye
 */

class NewThread implements Runnable {
    Thread t;
    
    NewThread (){
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: "+t);
    }
    
    
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--){
                System.out.println("Child Thread: "+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child interrupted");
        }
        System.out.println("Exit child thread");
    }
    
}
public class ImplementingRunable {

    public static void main(String[] args) {
        NewThread newThread = new NewThread(); //tạo một thread
        
        newThread.t.start(); //Bắt đầu chạy thread (start the thread)
        
        try {
            for (int i = 5; i > 0; i--){
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Main interrupted");
        }
        System.out.println("Exit main thread");
        
        //Chi tiết giải thích xem ở file Ly-thuyet-ImplementingRunable
    }
    
}
