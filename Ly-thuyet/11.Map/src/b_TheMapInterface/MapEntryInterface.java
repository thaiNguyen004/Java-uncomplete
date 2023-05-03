/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_TheMapInterface;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Interface Map.Entry cho phép bạn làm việc với một cặp key-value trong một map. 
Ví dụ, phương thức entrySet() được khai báo bởi interface Map trả về một Set chứa các entry trong map. 
Mỗi phần tử trong set này là một đối tượng Map.Entry.
Map.Entry là một generic interface và được khai báo như sau:

    interface Map.Entry<K, V>

Ở đây, K chỉ định kiểu của key và V chỉ định kiểu của value. Bảng dưới đây tóm tắt các phương thức
không phải static được khai báo bởi Map.Entry. 
Nó cũng có hai phương thức static. 
Phương thức đầu tiên là comparingByKey(), trả về một Comparator so sánh các entry theo key. 
Phương thức thứ hai là comparingByValue(), trả về một Comparator so sánh các entry theo value.
*/

/*
1. boolean equals(Object obj) : Trả về true nếu đối tượng được chỉ định bằng với entry.
2. K getKey() : Trả về key cho entry này.
3. V getValue() : Trả về value cho entry này.
4. int hashCode() : Trả về mã băm cho entry này.
5. V setValue(V value) : Đặt giá trị cho entry này và trả về giá trị trước đó được liên kết với nó.
nhưng được cung cấp trong các lớp triển khai của interface này ví dụ như SimpleEntry class
6. static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K, V>> comparingByKey()	
Trả về một Comparator so sánh các entry bằng key.
7. static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValue()	
Trả về một Comparator so sánh các entry bằng value.
*/
public class MapEntryInterface {

    public static void main(String[] args) {
        /*Lớp SimpleEntry 
            SimpleEntry là một lớp đơn giản dùng để tạo ra một đôi key-value (entry) của một Map. 
            Nó có constructor nhận vào key và value, và có thể được tạo ra thông qua việc khởi tạo 
            đối tượng SimpleEntry<K, V> với key và value tương ứng
        */
        
        List<Map.Entry<String, Integer>> listEn = Arrays.asList(
                new AbstractMap.SimpleEntry<>("one", 1),
                new AbstractMap.SimpleEntry<>("two", 2),
                new AbstractMap.SimpleEntry<>("three", 3)
        );
        
        //1 equals và getKey()
        Map.Entry<String, Integer> o = new AbstractMap.SimpleEntry<>("one", 1);
        for (Map.Entry<String, Integer> entry : listEn){
            if(entry.equals(o)){
                System.out.println("Tồn tại "+ entry.getKey()); //Tồn tại one
            }
        }
        //3 getValue tương tự
        
        //setValue : Đặt giá trị cho entry này và trả về giá trị trước đó được liên kết với nó.
        List<Map.Entry<String, Integer>> listEn2 = Arrays.asList(
                new AbstractMap.SimpleEntry<>("one", 1),
                new AbstractMap.SimpleEntry<>("two", 2),
                new AbstractMap.SimpleEntry<>("three", 3)
        );
        
        System.out.println(listEn2.get(2).setValue(5)); //giá trị trước đó là 3 nên hàm trả về 3
        
        
        //4 comparingByKey thì key phải có khả năng so sánh với chính nó
        //Không sử dụng comparator
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("b", 2);
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        
        list.forEach((e) -> System.out.println("K: "+ e.getKey() + " V: " + e.getValue()));
        //Trả về sắp xếp tăng dần
        
        //5 comparingByValue thì value phải có khả năng so sánh với chính nó
        //Sử dụng comparator trong comparator
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.put("c", 3);
        map2.put("b", 2);
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>(map2.entrySet());
        list2.sort(Map.Entry.comparingByValue((o2,o1) -> o1.compareTo(o2)));
        list2.forEach((e) -> System.out.println("K: "+ e.getKey() + " V: " + e.getValue()));
    }
    
}
