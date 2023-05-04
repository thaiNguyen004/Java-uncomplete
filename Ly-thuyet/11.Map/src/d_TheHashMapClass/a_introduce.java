/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

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
public class a_introduce {

    //Ở file này cùng học nốt về 2 khái niệm là entrySet và keySet
    public static void main(String[] args) {
        //create a HashMap
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //puts elements to the HashMap
        hm.put("Nguyen", 19);
        hm.put("Dung", 18);
        hm.put("Thao", 19);
        hm.put("Linh", 25);

        /*entrySet method : 
        Trong java, phương thức entrySet được định nghĩa trong các class giao diện Map. 
        Phương thức này trả về một Set chứa tất cả các entries của map, tức là các cặp key-value 
        được lưu trữ trong map dưới dạng các đối tượng Map.Entry<K, V> như đã được học, một phần tử 
        trong Set là một đối tượng Map.Entry<K, V>. Mỗi đối tượng Map.Entry<K, V> biểu diễn một cặp key-value 
        và cung cấp các phương thức getKey() và getValue() để truy cập vào key và value tương ứng của entry đó. 
         */
        //Tạo ra tập hợp các Entry
        Set<Map.Entry<String, Integer>> set = hm.entrySet();

        //Duyệt bằng for-each 
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        //keySet() trả về một tập hợp chứa tất cả các khóa (key) có trong.
        //đây là phương thức định nghĩa của Map, không phải của riêng HashMap
        Set<String> setKey = hm.keySet();
        //Duyệt bằng for-each 
        for (String key : setKey) {
            System.out.println(key);
        }
        //Duyệt bằng forEach 
        setKey.forEach(System.out::print); //duyệt qua tất cả các phần tử của Set 

        //Khởi tạo HashMap với constructor : HashMap()
        HashMap<String, Integer> hmct1 = new HashMap<>();
        //Capacity: 16; fillRadio : 0.75

        //Khởi tạo HashMap với constructor : HashMap(Map<? extends K,? extends V> m)
        HashMap<String, Integer> hmct2 = new HashMap<>(hm);
        //Có thể nói hmct2 như một bản sao chép của HashMap hm
        
        //Khởi tạo HashMap với cunstructor : HashMap(int capacity)
        HashMap<String, Integer> hmct3 = new HashMap<>(20);
        //Capacity : 20; fillRadio : 0.75
        
        //Khởi tạo HashMap với constructor : HashMap(int capacity, float fillRatio)
        HashMap<String, Integer> hmct4 = new HashMap<>(20, 80);
        //Capacity : 20; fillRadio : 0.80
    }
}
