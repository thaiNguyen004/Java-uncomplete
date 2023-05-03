/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package s_SuspendResumeAndStopThread;

/*
Lớp NewThread thực hiện giao diện Runnable, có các thuộc tính và phương thức sau:
- name: tên của luồng.
- t: đối tượng Thread tương ứng với luồng.
- suspendFlag: biến boolean được sử dụng để kiểm soát hoạt động của luồng.

Lớp NewThread có hai phương thức khởi tạo:
- NewThread(String name): khởi tạo một đối tượng NewThread với tên được truyền vào 
và khởi tạo một luồng mới.
- run(): ghi đè phương thức run() của giao diện Runnable. Phương thức này sử dụng 
vòng lặp để đếm ngược từ 10 đến 1, in ra tên của luồng và giá trị đếm. 
Sau đó, phương thức sử dụng synchronized block để kiểm tra giá trị của biến suspendFlag. 
Nếu giá trị là true, phương thức wait() được gọi để tạm dừng hoạt động của luồng. 
Nếu giá trị là false, vòng lặp tiếp tục chạy. 
Cuối cùng, khi vòng lặp kết thúc, thông báo rằng luồng đã kết thúc được in ra.

Lớp NewThread cũng có hai phương thức để kiểm soát luồng:
- mySuspend(): tạm dừng hoạt động của luồng bằng cách đặt giá trị của suspendFlag là true.
- myResume(): tiếp tục hoạt động của luồng bằng cách đặt giá trị của suspendFlag là false 
và gọi phương thức notify() để đánh thức luồng.

Như đã học: 
Trong ví dụ trên, việc kiểm tra giá trị của biến `suspendFlag` phải được thực hiện 
trong một synchronized block, vì nếu không, thì có thể xảy ra race condition giữa các thread.

Khi nhiều thread cùng truy cập vào một biến dữ liệu chia sẻ, việc xử lý không đồng bộ
có thể dẫn đến những lỗi nghiêm trọng. Trong trường hợp này, nếu không sử dụng synchronized block 
để bảo vệ biến `suspendFlag`, thì có thể xảy ra tình huống mà một thread có thể đang đọc 
hoặc cập nhật biến `suspendFlag` trong khi thread khác đang cố gắng thực hiện thao tác tương tự. 
Khi đó, có thể xảy ra tình huống mà một thread thực hiện thao tác trên giá trị cũ của biến, 
hoặc thực hiện thao tác ghi lên biến khi một thread khác đang cố gắng đọc giá trị mới nhất của biến. 
Điều này có thể gây ra lỗi hoặc dẫn đến hành vi không đáng kỳ vọng của chương trình.

Bằng cách sử dụng synchronized block, chúng ta đảm bảo rằng chỉ có một thread có thể truy cập 
vào biến `suspendFlag` tại một thời điểm, đồng thời đảm bảo rằng mọi thay đổi 
trên biến `suspendFlag` đều được cập nhật và đọc đồng bộ.
*/
class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
        suspendFlag = false;
    }

    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(name + i);
                Thread.sleep(400);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(name + " exit");
    }
    synchronized void mySuspend(){
        suspendFlag = true;
    }
    synchronized void myResume(){
        suspendFlag = false;
        notify();
    }

}

public class example {

    public static void main(String[] args) {
        NewThread ob1 = new NewThread("one");
        NewThread ob2 = new NewThread("two");
    
        //start the threads
        ob1.t.start();
        ob2.t.start();
    
        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspend thread one");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resume thread one");
            
            Thread.sleep(1000);
            ob2.mySuspend();
            System.out.println("Suspend thread two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resume thread two");
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
         try {
             ob1.t.join();
             ob2.t.join();
         } catch (InterruptedException e){
             System.out.println("Main interrupted");
         }
         System.out.println("Main exit");
        
        //Bước 1 tạo một luồng mới là luồng t. với tên là name và một biến cờ suspend
        //Bước 2 viết hàm tạo, hàm tạo sẽ cấp phát một đối tượng Thread với đối số target là chính lớp 
        //này (this), đối số thứ hai là tên cho biến `t`
        
        //Bước 3 thực hiện phương thức run, phương thức sẽ được chạy đầu khi start các luồng này
        //trong hàm main
        
        //Trong bước 3, đơn giản cho chạy 1 vòng lặp từ 15 - 1 mỗi lần lặp ngủ 400miliseconds, khi 2 luồng ob1
        //ob2 gọi đến start(), chúng chạy song song chia sẻ CPU, nhưng sau khi ngủ 400miliseconds xong chúng đi vào
        //một phương thức đồng bộ hóa synchronized methods để kiểm tra xem có được tạm dừng không, 
        //nếu chưa có bất kì một lời gọi phương thức mySuspend nào thì phương thức này không wait()
        //nếu có một lời gọi phương thức suspend nào biến suspendFlag chuyển sang true, và lúc đó cùng đấu
        
        //Xây dựng hàm Mysuspend và hàm MyResume 
        //đối với hàm MySuspend được gọi => thay dổi giá trị cho suspendsFlag = true để wait() thực thi
        //và luồng được ngủ 
        
        //đối với hàm MyResume được gọi => thay đổi giá trị cho suspendsFlag = false để không vào wait()
        //đồng thời gọi notify() để đánh thức wait()
        
        
    }

}
