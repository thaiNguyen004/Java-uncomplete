/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package f_MainThread;

public class example {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        
        System.out.println("Current Thread: "+t); //main
        
        //Thay đổi tên của thread
        t.setName("My Thread");
        System.out.println("Sau khi đổi tên: "+t); //My Thread
        
        try {
            for(int i = 5; i > 0 ; i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        /* Trong chương trình này, một tham chiếu đến luồng hiện tại 
        (luồng chính, trong trường hợp này) được lấy bằng cách gọi phương thức 
        currentThread(), và tham chiếu này được lưu trữ trong biến cục bộ t. 
        Tiếp theo, chương trình hiển thị thông tin về luồng. 
        Sau đó, chương trình gọi setName() để thay đổi tên nội bộ của luồng. 
        Thông tin về luồng được hiển thị lại. Tiếp theo, một vòng lặp đếm ngược 
        từ năm được thực hiện, mỗi lần nghỉ một giây giữa các dòng. 
        Việc nghỉ làm bằng phương thức sleep(). Đối số cho sleep() chỉ định thời gian 
        trì hoãn tính bằng mili giây. Lưu ý khối try / catch xung quanh vòng lặp này. 
        Phương thức sleep() trong lớp Thread có thể ném ra một InterruptedException. 
        Điều này sẽ xảy ra nếu một luồng khác muốn gián đoạn luồng đang ngủ. 
        Ví dụ này chỉ in một thông báo nếu nó bị gián đoạn. Trong một chương trình 
        thực tế, bạn sẽ cần xử lý điều này khác. 
        Dưới đây là đầu ra được tạo ra bởi chương trình này:
            Current thread : Thread[main,5,main]
            Sau khi đổi tên: Thread[My Thread,5,main]
            5
            4
            3
            2
            1
        */
        
        /* Lưu ý đầu ra được tạo ra khi t được sử dụng làm đối số cho println(). 
        Điều này hiển thị theo thứ tự: tên của luồng, độ ưu tiên và tên của nhóm. 
        Theo mặc định, tên của luồng chính là main. Độ ưu tiên của nó là 5, đây là giá trị mặc định, 
        và main cũng là tên của nhóm các luồng mà luồng này thuộc về. 
        Một nhóm luồng là một cấu trúc dữ liệu điều khiển trạng thái của một tập hợp 
        các luồng như một thể. Sau khi tên của luồng đã được thay đổi, t được đưa ra đầu ra một lần nữa. 
        Lần này, tên mới của luồng được hiển thị.*/
        
        /* Hãy xem xét kỹ hơn các phương thức được định nghĩa bởi Thread được sử dụng trong chương trình. 
        Phương thức sleep() gây tạm ngừng thực thi của luồng gọi nó trong khoảng thời gian 
        được chỉ định theo đơn vị mili giây. Dưới đây là dạng chung của phương thức này:
        
            static void sleep (long miliseconds) throws InterruptedException
        
        Số mili giây để tạm ngừng được chỉ định trong phương thức sleep() ở dạng đơn vị mili giây. 
        Phương thức này có thể ném ra một ngoại lệ InterruptedException.
        
        Phương thức sleep() có một dạng thứ hai, được hiển thị tiếp theo, cho phép bạn chỉ định 
        thời gian dưới dạng mili giây và nanosecond:
        
            static void sleep(long milliseconds, int nanoseconds) throws
            InterruptedException
        
        Dạng thứ hai này chỉ hữu ích trong các môi trường cho phép các khoảng thời gian đo bằng nanosecond.
        Như chương trình trước đó đã cho thấy, bạn có thể đặt tên cho một luồng bằng cách sử dụng setName(). 
        Bạn có thể lấy tên của một luồng bằng cách gọi getName() 
        (nhưng lưu ý rằng điều này không được hiển thị trong chương trình).
        
        Các phương thức này là thành viên của lớp Thread và được khai báo như sau:
        final void setName(String threadName)
        final String getName()
        Ở đây, threadName chỉ định tên của luồng.
        */
    }
    
}
