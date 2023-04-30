package k_isAlive_join_methods;
class NewThread implements Runnable {
    Thread t;
    String threadName;
    public NewThread(String name) {
        this.threadName = name;
        t = new Thread(this, threadName);
        System.out.println("New thread: "+threadName);
    }
    
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--){
                System.out.println(threadName + i);
                t.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(threadName + " interrupted");
        }
    }
}

public class example {
    public static void main(String[] args) {
        NewThread thread1 = new NewThread("one");
        NewThread thread2 = new NewThread("two");
        NewThread thread3 = new NewThread("three");
        NewThread thread4 = new NewThread("four");
        
        thread1.t.start();
        thread2.t.start();
        thread3.t.start();
        thread4.t.start();
        
        System.out.println(thread1.t.isAlive());
        System.out.println(thread2.t.isAlive());
        System.out.println(thread3.t.isAlive());
        System.out.println(thread4.t.isAlive());
        
        try {
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
//            thread4.t.join();
        }catch(InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println(thread1.t.isAlive());
        System.out.println(thread2.t.isAlive());
        System.out.println(thread3.t.isAlive());
        System.out.println(thread4.t.isAlive());
        /* Thread 1,2,3,4 cùng chạy start(). Thread1,2,3 join()
        Tức là main sẽ vị block bởi thread1, 2, 3 khi nào 3 thread này thực 
        thi xong thì main mới được thực thi. và thread4 thì vẫn thực thi xong xong 
        với main thread, chẳng qua là thread main bị chặn
        
        Khi 3 thread chạy xong thì thread main lập tức được chạy và không cần phải đợi thread4
        vì thread4 không join() tuy nhiên nếu thread4 cũng join() thì ngay sau khi câu lệnh join()
        biên dịch thì main bị chặn và main sẽ thực thi sau khi cả 4 thread trên kết thúc*/
    }
}
