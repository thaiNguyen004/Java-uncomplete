/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Lớp HashMap mở rộng lớp AbstractMap và triển khai giao diện Map. Nó sử dụng bảng băm 
để lưu trữ các cặp key-value của map. Việc này cho phép thời gian thực thi của các 
phương thức get() và put() không đổi ngay cả với các tập hợp lớn. Lớp HashMap 
là một lớp generic có khai báo như sau:
    class HashMap<K, V>
Ở đây, K chỉ định kiểu của các key và V chỉ định kiểu của các value.

Có các hàm khởi tạo sau được định nghĩa:
    HashMap()
    HashMap(Map<? extends K,? extends V> m)
    HashMap(int capacity)
    HashMap(int capacity, float fillRatio)
Giải thích về các hàm khởi tạo: 
• HashMap(): Hàm khởi tạo không tham số tạo ra một đối tượng HashMap trống với sức chứa 
mặc định là 16 và hệ số lấp đầy mặc định là 0.75.
• HashMap(Map<? extends K, ? extends V> m) nhận vào một tham số là một đối tượng Map 
có kiểu key và value tương ứng với kiểu key và value của HashMap được tạo ra.
Hàm này sẽ khởi tạo một đối tượng HashMap mới với các cặp key-value được sao chép 
từ đối tượng Map được truyền vào. Các phần tử của đối tượng Map này sẽ được thêm 
vào HashMap mới, theo thứ tự được giữ nguyên của đối tượng Map.
• HashMap(int initialCapacity): Hàm khởi tạo này tạo ra một đối tượng HashMap trống với 
sức chứa được chỉ định bởi đối số 'initialCapacity' và hệ số lấp đầy mặc định là 0.75. 
Đối số 'initialCapacity' chỉ định số lượng phần tử tối đa mà HashMap có thể chứa trước khi 
nó phải tăng kích thước bên trong hay nói cách khác là tái cấu trúc (rehashing) tăng sức chứa lên gấp đôi!!
• HashMap(int initialCapacity, float loadFactor): Hàm khởi tạo này tạo ra một đối tượng HashMap 
trống với sức chứa được chỉ định bởi đối số 'initialCapacity' và hệ số lấp đầy được chỉ định bởi đối số 'loadFactor'. 
Đối số 'initialCapacity' chỉ định số lượng phần tử tối đa mà HashMap có thể chứa trước khi nó phải 
tăng kích thước bên trong. 

Trong ngữ cảnh của cấu trúc dữ liệu hash table, sức chứa (capacity) là số lượng phần tử tối đa 
mà hash table có thể chứa trước khi cần phải thực hiện tái cấu trúc (rehashing), tức là tăng kích thước của hash table.

Hệ số lấp đầy (load factor) là một giá trị số thực, thường nằm trong khoảng từ 0 đến 1, mô tả tỷ lệ 
giữa số phần tử thực sự trong hash map và sức chứa của hash map. 
Ví dụ, nếu hệ số lấp đầy của một hash map là 0.75, nghĩa là khi số phần tử thực sự trong hash map đạt tới 
75% sức chứa của nó, thì sẽ có sự thay đổi cấu trúc bên trong để tăng kích thước của hash map.

Điều này đảm bảo rằng sẽ luôn có đủ dung lượng để chứa các phần tử mới, đồng thời cũng đảm bảo rằng 
kích thước của hash map không quá lớn so với số lượng phần tử thực sự, từ đó giúp tối ưu hóa hiệu suất 
truy cập và thao tác trên hash map.
 */
public class a_HashMap {

    //Ở file này cùng học nốt về 2 khái niệm là entrySet và keySet
    public static void main(String[] args) {
        //create a HashMap
        HashMap<String, Double> hm = new HashMap<>();

        //puts elements to the HashMap
        hm.put("Nguyen", 650.14);
        hm.put("Dung", 120.11);
        hm.put("Thao", 191.11);
        hm.put("Linh", 255.14);
        
        //Tập hợp Set chứa các entries
        Set<Map.Entry<String, Double>> set = hm.entrySet(); 
        for (Map.Entry<String, Double> entry : set){
            System.out.println(entry.getKey() +": "+entry.getValue());
        }
        
        //Giả sử Nguyen gửi vào ngân hàng thêm 100$
        double balance = hm.get("Nguyen");
        hm.put("Nguyen", balance + 100);
        
        System.out.println("Tiền gửi mới của Nguyên: "+hm.get("Nguyen"));
        
        /*Chương trình bắt đầu bằng cách tạo một bản đồ băm (hash map) và sau đó 
        thêm các ánh xạ của key vào phần value tương ứng. Tiếp theo, nội dung của bản đồ 
        được hiển thị bằng cách sử dụng một tập hợp xem (set-view) được lấy bằng cách gọi 
        phương thức entrySet(). 
        Các khóa và giá trị được hiển thị bằng cách gọi các phương thức getKey() và getValue() 
        được định nghĩa bởi Map.Entry.

        Chú ý đến cách tiền được gửi vào tài khoản của Nguyen. Phương thức put() 
        sẽ tự động thay thế bất kỳ giá trị nào đã tồn tại được liên kết với khóa 
        được chỉ định bằng giá trị mới. Do đó, sau khi tài khoản của Nguyen được cập nhật, 
        bản đồ băm vẫn chỉ chứa một tài khoản "Nguyen" duy nhất.*/
        
        /*
            Linh: 255.14
            Thao: 191.11
            Nguyen: 650.14
            Dung: 120.11
            Tiền gửi mới của Nguyên: 750.14
        */
        
        /*Lưu ý: HashMap sử dụng cấu trúc bảng băm để lưu trữ phần tử nên sẽ không đảm bảo về 
        thứ tự put vào ban đầu*/
        
        
        //Khởi tạo HashMap với constructor : HashMap()
        HashMap<String, Integer> hmct1 = new HashMap<>();
        //Capacity: 16; fillRadio : 0.75

        //Khởi tạo HashMap với constructor : HashMap(Map<? extends K,? extends V> m)
        HashMap<String, Double> hmct2 = new HashMap<>(hm);
        //Có thể nói hmct2 như một bản sao chép của HashMap hm
        
        //Khởi tạo HashMap với cunstructor : HashMap(int capacity)
        HashMap<String, Integer> hmct3 = new HashMap<>(20);
        //Capacity : 20; fillRadio : 0.75
        
        //Khởi tạo HashMap với constructor : HashMap(int capacity, float fillRatio)
        HashMap<String, Integer> hmct4 = new HashMap<>(20, 80);
        //Capacity : 20; fillRadio : 0.80
    }
}
