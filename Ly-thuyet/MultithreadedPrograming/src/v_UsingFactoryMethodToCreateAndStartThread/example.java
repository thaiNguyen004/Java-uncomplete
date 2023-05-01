/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package v_UsingFactoryMethodToCreateAndStartThread;

/*Trong một số trường hợp, không cần phải tách việc tạo thread ra khỏi bắt đầu thực thi của nó. 
Nói cách khác, đôi khi việc tạo và bắt đầu một thread vào cùng một thời điểm là tiện lợi. 
Một cách để làm điều này là sử dụng một phương thức factory tĩnh. 
Một phương thức factory là một phương thức trả về một đối tượng của một lớp. 
Thông thường, phương thức factory là các phương thức tĩnh của một lớp. 
Chúng được sử dụng cho nhiều mục đích, chẳng hạn như thiết lập một đối tượng đến một trạng thái ban đầu 
trước khi sử dụng, cấu hình một loại đối tượng cụ thể, hoặc trong một số trường hợp, cho phép một đối tượng 
được sử dụng lại. Đối với việc tạo và bắt đầu một thread, một phương thức factory sẽ tạo ra thread, 
gọi start() trên thread, và sau đó trả về một tham chiếu đến thread. 
Với cách tiếp cận này, bạn có thể tạo và bắt đầu một thread thông qua một cuộc gọi 
phương thức duy nhất, giúp tối ưu hóa mã của bạn */
class NewThread implements Runnable {
    Thread t;
    String name;
    
    NewThread (String name){
        this.name = name;
        t = new Thread(this, name);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--){
                System.out.println(name + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e){
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exit");
    }
    //Factory method that create and start thread
    static NewThread createAndStart(String name){
        NewThread o = new NewThread(name);
        o.t.start();
        return o;
    }
}
public class example {
    public static void main(String[] args) {
        NewThread o = NewThread.createAndStart("one");
        
        /* Trong các trường hợp mà bạn không cần giữ một tham chiếu đến thread đang thực thi, 
        bạn có thể đôi khi tạo và bắt đầu một thread chỉ với một dòng mã, mà không cần sử dụng 
        một factory method. Ví dụ, giả sử lại chương trình NewThread, 
        ví dụ sau tạo và bắt đầu một thread NewThread:

        new NewThread().t.start();
        
        Tuy nhiên, trong các ứng dụng thực tế, bạn thường cần giữ một tham chiếu đến thread, 
        vì vậy factory method thường là một lựa chọn tốt.*/
    }
    
}
