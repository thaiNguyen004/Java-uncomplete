/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package g_CreatingThread;

public class ExtendingThread {
    class NewThread extends Thread {

        public NewThread() {
            super ("Demo Thread");
            System.out.println("Child Thread: " + this);
        }

        @Override
        public void run() {
            try {
                for (int i = 5; i > 0; i--){
                    System.out.println("Child Thread: "+i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e){
                System.out.println("Child interrupted");
            }
            System.out.println("Exit Child Thread");
        }
        
    }
    public static void main(String[] args) {
        var obj = new ExtendingThread();
        var newThread = obj.new NewThread();
        
        newThread.start();
        
        try {
            for(int i = 5; i > 0; i--){
                System.out.println("Main thread: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Main interrupted");
        }
        System.out.println("Exit main Thread");
    }
    
}
