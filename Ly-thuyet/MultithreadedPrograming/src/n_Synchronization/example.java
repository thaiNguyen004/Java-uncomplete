/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package n_Synchronization;
/*
Như bạn có thể thấy, bằng cách gọi sleep (), phương thức call () cho phép việc thực 
thi chuyển sang một luồng khác. Điều này dẫn đến việc đầu ra của ba chuỗi thông báo 
bị trộn lẫn. Trong chương trình này, không có gì ngăn cản ba luồng khác nhau từ 
việc gọi cùng một phương thức trên cùng một đối tượng, cùng một lúc. Điều này được 
gọi là tình trạng đua tốc độ, vì ba luồng đang đua với nhau để hoàn thành phương thức. 
Ví dụ này sử dụng sleep () để làm cho hiệu ứng lặp lại và rõ ràng. Trong hầu hết các 
tình huống, tình trạng đua tốc độ là tinh subtile hơn và khó đoán hơn, vì bạn không 
thể chắc chắn khi nào chuyển đổi ngữ cảnh sẽ xảy ra. Điều này có thể làm cho một 
chương trình chạy đúng một lần và sai lần sau.
Để sửa chương trình trước đó, bạn phải tuân thủ quyền truy cập cho phép gọi (). 
Tức là, bạn phải hạn chế quyền truy cập của nó chỉ cho một luồng tại một thời điểm. 
Để làm điều này, bạn chỉ cần đặt từ khóa synchronized trước định nghĩa của 
phương thức call (), như được hiển thị ở đây:
*/
class Callme {
    synchronized void call (String msg){
        System.out.print("[" +msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("] ");
    }
    synchronized void call2 (String msg){
        System.out.println("Call 2: "+msg);
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;
    
    public Caller (Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
    }
    
    @Override
    public void run() {
        target.call(msg);
        target.call2(msg);
    }
    
}
public class example {

    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World3");
        
        //Start the threads
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        
        //wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        /* Điều này ngăn các luồng khác nhập vào call () trong khi một luồng khác 
        đang sử dụng nó. Sau khi synchronized được thêm vào call (), kết quả của 
        chương trình như sau:
            [Hello]
            [Synchronized]
            [World]
        Bất cứ khi nào bạn có một phương thức, hoặc một nhóm các phương thức, mà 
        thao tác với trạng thái nội bộ của một đối tượng trong tình huống đa luồng, 
        bạn nên sử dụng từ khóa synchronized để bảo vệ trạng thái khỏi race condition. 
        Hãy nhớ, một khi một luồng nhập vào bất kỳ phương thức synchronized nào 
        trên một thể hiện, không có luồng nào khác có thể nhập vào bất kỳ phương 
        thức synchronized khác trên cùng một thể hiện. 
        Tuy nhiên, các phương thức không đồng bộ trên thể hiện đó vẫn có thể được gọi.*/
    }
    
}
