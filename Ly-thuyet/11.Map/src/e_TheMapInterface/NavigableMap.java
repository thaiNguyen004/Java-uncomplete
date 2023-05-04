/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package e_TheMapInterface;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
Giao diện NavigableMap mở rộng từ SortedMap và khai báo hành vi của một bản đồ (map) hỗ trợ việc 
lấy các entry dựa trên sự khớp gần nhất với một key hoặc keys cụ thể. NavigableMap 
là một giao diện generic, có khai báo như sau:

    interface NavigableMap<K,V>

Ở đây, K chỉ định kiểu của các keys, và V chỉ định kiểu của các giá trị liên kết với keys. 
Ngoài các phương thức kế thừa từ SortedMap, NavigableMap thêm các phương thức được tóm tắt trong Bảng 19-13. 
Một số phương thức ném ra ngoại lệ ClassCastException khi một đối tượng không tương thích với keys trong map. 
NullPointerException được ném ra nếu cố gắng sử dụng một đối tượng null và null keys không được phép trong tập hợp. 
Một IllegalArgumentException được ném ra nếu sử dụng một đối số không hợp lệ.
*/

/*
1. ceilingEntry(K key): trả về entry có khóa lớn nhất trong map mà lớn hơn hoặc bằng 
key được chỉ định, hoặc null nếu không tìm thấy.

2. ceilingKey(K key): trả về khóa lớn nhất trong map mà lớn hơn hoặc bằng 
key được chỉ định, hoặc null nếu không tìm thấy.

3. descendingMap(): trả về một view của map theo thứ tự ngược lại.

4. firstEntry(): trả về entry có khóa nhỏ nhất trong map, hoặc null nếu map là trống.

5. floorEntry(K key): trả về entry có khóa lớn nhất trong map mà nhỏ hơn hoặc bằng 
key được chỉ định, hoặc null nếu không tìm thấy.

6. floorKey(K key): trả về khóa lớn nhất trong map mà nhỏ hơn hoặc bằng
key được chỉ định, hoặc null nếu không tìm thấy.

7. headMap(K toKey, boolean inclusive): trả về một view của map chỉ chứa các entry 
có khóa nhỏ hơn toKey (kể cả nếu inclusive là true) nếu inclusive là true 
hoặc nhỏ hơn toKey (không bao gồm toKey) nếu inclusive là false.

8. higherEntry(K key): trả về entry có khóa lớn hơn key được chỉ định, hoặc null nếu không tìm thấy.

9. higherKey(K key): trả về khóa lớn hơn key được chỉ định, hoặc null nếu không tìm thấy.

10. lastEntry(): trả về entry có khóa lớn nhất trong map, hoặc null nếu map là trống.

11. lowerEntry(K key): trả về entry có khóa nhỏ hơn key được chỉ định, hoặc null nếu không tìm thấy.

12. lowerKey(K key): trả về khóa nhỏ hơn key được chỉ định, hoặc null nếu không tìm thấy.

13. navigableKeySet(): trả về một set chứa tất cả các khóa trong map theo thứ tự tăng dần.

14. pollFirstEntry(): loại bỏ và trả về entry có khóa nhỏ nhất trong map, hoặc null nếu map là trống.

15. pollLastEntry(): loại bỏ và trả về entry có khóa lớn nhất trong map, hoặc null nếu map là trống.*/

public class NavigableMap {
    
    public static void main(String[] args) {
        List<Map.Entry<String, Integer>> list = Arrays.asList(
                new AbstractMap.SimpleEntry<>("a", 1),
                new AbstractMap.SimpleEntry<>("d", 2),
                new AbstractMap.SimpleEntry<>("c", 3),
                new AbstractMap.SimpleEntry<>("f", 4)
        );
        java.util.NavigableMap<String, Integer> navMap = new TreeMap<>(
                Map.ofEntries(list.toArray(new Map.Entry[list.size()])));
        
        /*1. ceilingEntry(K key): trả về entry có khóa nhỏ nhất trong map mà lớn hơn hoặc bằng 
        key được chỉ định, hoặc null nếu không tìm thấy.*/
        System.out.println(navMap.ceilingEntry("b")); 
        //Chú ý output mặc định trả ra một Entry có dạng viết như sau: c-3
        //Nếu muốn rõ ràng chúng ta có thể viết như sau: 
        Map.Entry tmp = navMap.ceilingEntry("b");
        System.out.println("Key: "+tmp.getKey() + " Value: "+tmp.getValue());
        //Output sau khi format lại: Key: c Value: 3
        System.out.println(navMap.ceilingEntry("w")); 
        //Nếu không tìm thấy thì trả về null
        
        /*2. ceilingKey(K key): trả về khóa nhỏ nhất trong map mà lớn hơn hoặc bằng 
        key được chỉ định, hoặc null nếu không tìm thấy.
        Chú ý rằng ceilingKey cách hoạt động giống như ceilingEntry nhưng thay vì trả về một 
        Entry nó lại trả về key tương ứng*/
        
        System.out.println(navMap.ceilingKey("e")); 
        // >= e => e, f, ... nhưng trong navMap chỉ có f nên trả về f
        //output: f
        System.out.println(navMap.ceilingKey("w")); 
        //Nếu không tìm thấy thì trả về null
        
        /*3. descendingMap(): trả về một view của map theo thứ tự ngược lại.
        Lưu ý quan trọng: Khi bạn sử dụng phương thức descendingMap() để tạo ra một 
        NavigableMap mới, thì các phương thức của NavigableMap mới sẽ hoạt động theo 
        thứ tự ngược lại với NavigableMap cũ. Ví dụ, khi bạn gọi phương thức firstEntry() 
        trên NavigableMap mới, nó sẽ trả về entry có key lớn nhất trong NavigableMap mới, 
        Nếu như trong NavigableMap cũ giá trị lớn nhất và 'e' thì firstEntry sẽ trả về entry có khóa 'e'.*/
        java.util.NavigableMap<String, Integer> descendingDemo = navMap.descendingMap();
        descendingDemo.forEach((k, v) -> System.out.println("K: "+k + " V: "+v));
        /*output sau khi duyệt qua descendingDemo :
            K: f V: 4
            K: d V: 2
            K: c V: 3
            K: a V: 1 */
        
        /*4. firstEntry(): trả về entry có khóa nhỏ nhất trong map, hoặc null nếu map là trống*/
        System.out.println(navMap.firstEntry());
        /*output : a-1 . Vì phương thức này trả về một entry có key nhỏ nhất trong map*/
        
        //!!! Nhưng đối với một Navigable descending thì ngược lại
        System.out.println(descendingDemo.firstEntry()); 
        /*output: f-4 . Vì phương thức này trên một Navigable mới này sẽ trả về entry có key lớn nhất*/
        
        /*5. floorEntry(K key): trả về entry có khóa lớn nhất trong map mà nhỏ hơn hoặc bằng 
        key được chỉ định, hoặc null nếu không tìm thấy
        Ví dụ sau đây áp dụng trên Map `navMap`*/
        System.out.println(navMap.floorEntry("b")); 
        //output: a-1
        
        //Trường hợp ngược lại đối với một NavigableMap được sinh ra từ phương thức descending
        /*floorEntry(K key):(descending) = ceilingEntry(K key)*/
        System.out.println(descendingDemo.floorEntry("b"));
        //output: c-3 -> giống với navMap.ceilingEntry("b"); 

        /*6. floorKey(K key): trả về khóa lớn nhất trong map mà nhỏ hơn hoặc bằng
        key được chỉ định, hoặc null nếu không tìm thấy.*/
        System.out.println(navMap.floorKey("b")); //output: a
        
        //descending thì ngược lại
        System.out.println(descendingDemo.floorKey("b")); //output: c
        
        /*7. headMap(K toKey, boolean inclusive): trả về một view của map chỉ chứa các entry 
        có khóa nhỏ hơn toKey (kể cả nếu inclusive là true) nếu inclusive là true 
        hoặc nhỏ hơn toKey (không bao gồm toKey) nếu inclusive là false.*/
        java.util.NavigableMap<String, Integer> headMapDemo1 = navMap.headMap("d", true);
        java.util.NavigableMap<String, Integer> headMapDemo2 = navMap.headMap("d", false);
        /*Ở ví dụ trên ta thấy và headMapDemo2 có sự khác nhau về đối số inclusive
        inclusive = true thì phương thức này sẽ trả về một NavigableMap với các Entry có key <= toKey
        inclusive = false thì phương thức này sẽ trả về một NavigableMap với các Entry có key < toKey*/
        
        headMapDemo1.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        /*      K: a V: 1
                K: c V: 3
                K: d V: 2
        Các Entry có key <= d nên sẽ bao gồm cả d
                
        */
        headMapDemo2.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        /*
                K: a V: 1
                K: c V: 3
        Các Entry có key < d nên sẽ không bao gồm d
        */
        
        /*Lưu ý quan trọng về headMap : đó là headMap sẽ không đảo ngược với Navigable Map bình thường
        như là descending*/
        
        /*8. higherEntry(K key): trả về entry có khóa lớn hơn (>) key được chỉ định, hoặc null nếu không tìm thấy.*/
        System.out.println(headMapDemo1.higherEntry("c"));
        //output: d-2
        
        /*9. higherKey(K key): trả về khóa lớn hơn key được chỉ định, hoặc null nếu không tìm thấy.*/
        System.out.println(headMapDemo1.higherKey("c"));
        
        /*10. lastEntry(): trả về entry có khóa lớn nhất trong map, hoặc null nếu map là trống.
        Ngược lại với firstEntry*/
        System.out.println(headMapDemo1.lastEntry()); //output: d-2 vì d là key lớn nhất
        
        /*lastKey() tương tự*/
        
        /*11. lowerEntry(K key): trả về entry có khóa nhỏ hơn (<) key được chỉ định, hoặc null nếu không tìm thấy.*/
        System.out.println(headMapDemo1.lowerEntry("c"));
        //output: a-1
        
        /*12. lowerKey(K key) tương tự */
        
        /*13. navigableKeySet(): trả về một set chứa tất cả các khóa trong map theo thứ tự tăng dần.*/
        List<Map.Entry<Integer, String>> list2 = Arrays.asList(
                new AbstractMap.SimpleEntry<>(5, "five"),
                new AbstractMap.SimpleEntry<>(2, "two"),
                new AbstractMap.SimpleEntry<>(4, "four"),
                new AbstractMap.SimpleEntry<>(1, "one"),
                new AbstractMap.SimpleEntry<>(3, "three")
        );
        java.util.NavigableMap<Integer, String> demoKeySet = new TreeMap<>(
                Map.ofEntries(list2.toArray(new Map.Entry[list2.size()]))
        );
        demoKeySet.forEach((k,v) -> System.out.println("K: "+k +" V: "+v));
        /*Vì xử dụng lớp TreeMap nên mặc định Navigable sẽ được sắp xếp theo thứ tự tăng dần*/
        Set<Integer> navigableKeySet = demoKeySet.navigableKeySet();
        navigableKeySet.forEach(e -> System.out.println(e));
        /*
            1
            2
            3
            4
            5
        */
        
        /*14. pollFirstEntry(): loại bỏ và trả về entry có khóa nhỏ nhất trong map, hoặc null nếu map là trống.
        Ví dụ trên demoKeySet: 
        */
        Map.Entry<Integer, String> EntryKeyMin = demoKeySet.pollFirstEntry();
        /*Phương thức trên trả về một Entry có khóa nhỏ nhất đồng thời xóa entry đó ra khỏi NavigableMap*/
        System.out.println(EntryKeyMin); //output: 1=one
        //Kiểm tra NavigableMap gốc xem đã mất Entry nhỏ nhất chưa
        demoKeySet.forEach((k,v) -> System.out.println("K: "+k+" V:"+v));
        /*
            K: 2 V:two
            K: 3 V:three
            K: 4 V:four
            K: 5 V:five
        */
        
        /*15. pollLastEntry(): loại bỏ và trả về entry có khóa lớn nhất trong map, hoặc null nếu map là trống.
        Ví dụ trên demoKeySet: 
        Hãy lưu ý dòng code trước đó đã làm thay đổi NavigableMap demoKeySet: 
            demoKeySet hiện tại: 
                K: 2 V:two
                K: 3 V:three
                K: 4 V:four
                K: 5 V:five
        */
        Map.Entry<Integer, String> EntryKeyMax = demoKeySet.pollLastEntry();
        /*Phương thức trên trả về một Entry có khóa lớn nhất đồng thời xóa entry đó ra khỏi NavigableMap*/
        System.out.println(EntryKeyMax); //output: 5=five
        //Kiểm tra NavigableMap gốc xem đã mất Entry nhỏ nhất chưa
        demoKeySet.forEach((k,v) -> System.out.println("K: "+k+" V:"+v));
        /*
            K: 2 V:two
            K: 3 V:three
            K: 4 V:four
        */
        
    }
    
}
