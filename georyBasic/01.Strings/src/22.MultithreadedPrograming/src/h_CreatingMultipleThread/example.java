/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package h_CreatingMultipleThread;

/* Cho đến nay, bạn đã chỉ sử dụng hai luồng: luồng chính và một luồng con. 
Tuy nhiên, chương trình của bạn có thể tạo ra nhiều luồng tùy ý. 
Ví dụ, chương trình sau đây tạo ba luồng con. */

class MultipleThread implements Runnable {
    String threadName;
    Thread t;

    public MultipleThread(String name) {
        threadName = name;
        t = new Thread(this, threadName);
        System.out.println("New Thread: "+ t);
    }
    
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--){
                System.out.println(threadName+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(threadName+" interrupted");
        }
        System.out.println("Exit "+threadName);
    }
    
}

public class example {

    public static void main(String[] args) {
        MultipleThread thread1 = new MultipleThread("one");
        MultipleThread thread2 = new MultipleThread("two");
        MultipleThread thread3 = new MultipleThread("three");
        
        //start threads
        thread1.t.start();
        thread2.t.start();
        thread3.t.start();
        
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("main interrupted");
        }
        System.out.println("Exit main thread");
    }
    /* Như bạn có thể thấy, khi bắt đầu, tất cả ba luồng con sẽ chia sẻ CPU. 
    Lưu ý cuộc gọi đến sleep(10000) trong hàm main(). Điều này làm cho luồng chính ngủ trong mười giây 
    và đảm bảo nó sẽ kết thúc cuối cùng.*/
}
