/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_TheMapInterface;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*SortedMap là một interface mở rộng của Map. Nó đảm bảo rằng các entry được giữ 
và sắp xếp theo thứ tự tăng dần dựa trên các key. SortedMap là generic và được khai báo như sau:

    interface SortedMap<K, V>

Ở đây, K chỉ định kiểu của keys, và V chỉ định kiểu của values.
Các phương thức được khai báo bởi SortedMap được tóm tắt trong Bảng 19-12. 
Một số phương thức ném ra một ngoại lệ NoSuchElementException khi không có mục nào trong map. 
Một ClassCastException được ném ra khi một đối tượng không tương thích với các phần tử trong map. 
Một NullPointerException được ném ra nếu một nỗ lực được thực hiện để sử dụng một đối tượng null 
khi null không được phép trong map. 
Một IllegalArgumentException được ném ra nếu một đối số không hợp lệ được sử dụng.
*/

/*
1. Comparator<? super K> comparator() : Trả về bộ so sánh sử dụng để so sánh các key trong map. 
Nếu map được sắp xếp theo thứ tự tự nhiên của các key, null được trả về.
2. K firstKey() : Trả về key đầu tiên trong map
3. K lastKey() : Trả về key cuối cùng trong map.
4. SortedMap<K, V> headMap(K toKey) : Trả về một SortedMap bao gồm tất cả các mapping 
trong SortedMap gọi phương thức, chứa tất cả các phần tử với key < toKey.
5. SortedMap<K, V> subMap(K fromKey, K toKey) : Trả về một SortedMap bao gồm tất cả các mapping 
trong SortedMap gọi phương thức, chứa tất cả các phần tử với key >= fromKey và < toKey.
6. SortedMap<K, V> tailMap(K fromKey) :  Trả về một SortedMap bao gồm tất cả các mapping 
trong SortedMap gọi phương thức, chứa tất cả các phần tử với key >= fromKey.
7. default SortedMap<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5): 
Trả về một SortedMap chứa năm cặp key-value, được sắp xếp theo thứ tự tăng dần của các key.
8. default SortedMap<K,V> ofEntries(Map.Entry<? extends K,? extends V>... entries): 
Trả về một SortedMap được khởi tạo từ các entry đã cho, được sắp xếp theo thứ tự tăng dần của các key.
*/
public class SortedMapInterface {
    static SortedMap<String, Integer> createMap (SortedMap<String, Integer> originalMap){
        originalMap = new TreeMap<String, Integer>();
        originalMap.put("a", 5); //first key
        originalMap.put("f", 4);
        originalMap.put("c", 3);
        originalMap.put("e", 2);
        originalMap.put("k", 1);
        return originalMap;
    }
    public static void main(String[] args) {
        //1 Sử dụng một Comparator tùy chỉnh để so sánh các phần tử theo một tiêu chí khác nhau.
        //Cách thực hiện trong constructor không có tham số
        SortedMap<String, Integer> newMap = new TreeMap<String, Integer>(Collections.reverseOrder());
        newMap = createMap(newMap);
        System.out.println("ReverseOrder");
        newMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        
        //Cách thực hiện khác
        Comparator<String> valueComparator = Comparator.naturalOrder();
        newMap = new TreeMap<>(valueComparator);
        System.out.println("NaturalOrder");
        newMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        
        /*
        • Bạn chưa thấy gì khác nhau trong kết quả vì khi bạn tạo TreeMap với Comparator 
        là naturalOrder hoặc reverseOrder thì chúng sẽ tạo ra TreeMap với cùng một cấu trúc như nhau. 
        Sự khác biệt ở đây là cách TreeMap sắp xếp các phần tử trong nó. 
        • Với Comparator naturalOrder, TreeMap sẽ sắp xếp các phần tử theo thứ tự tăng dần của key 
        (các key được sắp xếp theo thứ tự từ điển).
        • Với Comparator reverseOrder, TreeMap sẽ sắp xếp các phần tử theo thứ tự giảm dần của key 
        (các key được sắp xếp theo thứ tự từ điển, nhưng đảo ngược).
        •Vì vậy, nếu bạn chèn các phần tử vào TreeMap bằng cách sử dụng put() và sau đó duyệt TreeMap 
        để in ra các phần tử, bạn sẽ không thấy sự khác biệt nào giữa hai Comparator này, 
        bởi vì chúng sẽ hiển thị các phần tử theo cùng một thứ tự, chỉ khác nhau về thứ tự sắp xếp bên trong TreeMap.
        • Về cơ bản thì Interface SortedMap này đã sắp xếp tăng dần của key vì dùng cấu trúc TreeMap rồi
        */
        
        //2 Sử dụng để lấy key đầu tiên
        SortedMap<String, Integer> firstMap = new TreeMap<String, Integer>();
        firstMap = createMap(firstMap);
        firstMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        System.out.println("Key đầu tiên : "+firstMap.firstKey());
        
        //2 Sử dụng để lấy key cuối cùng
        SortedMap<String, Integer> lastMap = new TreeMap<String, Integer>();
        lastMap = createMap(lastMap);
        lastMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        System.out.println("Key cuối cùng : "+lastMap.lastKey());
        
        
        //4 Phương thức headMap(K toKey) của interface SortedMap<K,V> trả về một 
        //SortedMap chứa tất cả các phần tử với key nhỏ hơn toKey.
        SortedMap<String, Integer> newMap3 = new TreeMap<String, Integer>();
        newMap3 = createMap(newMap3);
        SortedMap<String, Integer> headMap = newMap3.headMap("w");
        System.out.println("headMap");
        headMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        
        //5 Phương thức subMap(K toKey) của interface SortedMap<K,V> trả về một 
        //SortedMap chứa tất cả các phần tử với key >= fromKey và < toKey.
        SortedMap<String, Integer> newMap4 = new TreeMap<String, Integer>();
        newMap4 = createMap(newMap4);
        SortedMap<String, Integer> subMap = newMap4.subMap("a", "e");
        System.out.println("subMap");
        subMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        
        //6 Phương thức tailMap(K toKey) của interface SortedMap<K,V> trả về một 
        //SortedMap chứa tất cả các phần tử với key >= fromKey và < toKey.
        SortedMap<String, Integer> newMap5 = new TreeMap<String, Integer>();
        newMap5 = createMap(newMap5);
        SortedMap<String, Integer> tailMap = newMap5.tailMap("e");
        System.out.println("tailMap");
        tailMap.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        
        //7 Trong SortedMap không có phương thức of nên phải sử dụng Comparator của TreeMap trong SortedMap như sau:
        SortedMap<String, Integer> methOf = new TreeMap<>(
                Map.of("one", 1, "two", 2, "three", 3, "four", 4));
        
        //8 Cách 1 Map.ofEntries(). Phương thức này yêu cầu đầu vào là một mảng các đối tượng kiểu Map.Entry
        List<Map.Entry<String, Integer>> list = Arrays.asList(
                new AbstractMap.SimpleEntry<>("one", 1),
                new AbstractMap.SimpleEntry<>("two", 2),
                new AbstractMap.SimpleEntry<>("three", 3)
        );
        /*Trong trường hợp này, phương thức toArray cần một mảng Object[] làm tham số đầu vào. 
        Tuy nhiên, Map.Entry là một kiểu dữ liệu riêng biệt và không phải là kiểu dữ liệu đơn giản như Object. 
        Do đó, chúng ta cần chuyển đổi các phần tử trong danh sách List<Map.Entry<String, Integer>> sang kiểu 
        Map.Entry[] trước khi truyền chúng vào phương thức toArray().*/
        //Sử dụng stream
        SortedMap<String, Integer> methOfEntry = new TreeMap<>(
                Map.ofEntries(list.stream().
                        collect(Collectors.toSet()).toArray(Map.Entry[]::new)));
        //Không sử dụng stream
        SortedMap<String, Integer> methOfEntry2 = new TreeMap<>(
                Map.ofEntries(list.toArray(Map.Entry[]::new)));
        
        
        
        //Mô tả riêng getOrDefault của Map chung không liên quan tới các phương thức của interface SortedMap
        SortedMap<Integer, String> newMap6 = new TreeMap<>();
        System.out.println(newMap6.getOrDefault(100, "Không có"));
        
        // Mô tả riêng replaceAll và replace của Map chung không liên quan tới các phương thức của interface SortedMap
        SortedMap<String, Integer> newMap7 = new TreeMap<String, Integer>();
        newMap7 = createMap(newMap7);
        System.out.println("ReplaceAll");
//        System.out.println(newMap7.replace("y", 5));  // trả về index nếu thay thế được ngược lại trả về null
//        System.out.println(newMap7.replace("e", 7, 21)); // trả về true nếu tt được ngược lại trả về false
        newMap7.replaceAll((k, v) -> v + 10); //Thay thế tất cả các value theo lambda, vì là void nên không cho vào println được
        newMap7.forEach((k,v) -> System.out.println("K: "+k+" V: "+v));
        
        //9 NavigableMap descendingMap để dùng phương thức descendingMap thì lại phải học về interface NavigableMap
        
        
    }
    
}
