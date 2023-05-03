/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package t_ThreadsState;

class NewThread implements Runnable {

    String name;
    Thread t;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(name + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
    }

}

public class example {

    public static void main(String[] args) {
        Thread ob1 = new Thread(new NewThread("one")); //NEW
        NewThread ob2 = new NewThread("two");
        ob1.start(); // RUNNABLE
        ob2.t.start();
        //Hàm main chạy song song và thực hiện kiểm tra trạng thái của thread : newState
        Thread.State st = ob1.getState();
        Thread.State st2 = ob2.t.getState();
        try {
            Thread.sleep(6000);
            if (st == Thread.State.RUNNABLE) {
                System.out.println(ob1.getName() +"Vẫn đang chạy");
            }
            if(st2 == Thread.State.RUNNABLE){
                System.out.println(ob2.t.getName() + " Vẫn đang chạy");
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        } 
    }

}
