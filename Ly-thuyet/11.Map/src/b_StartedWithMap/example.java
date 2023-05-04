/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMap;

import java.util.Map;
import java.util.TreeMap;

/*
1. V put(K key, V value): Thêm một entry mới vào Map. Nếu key đã tồn tại trong Map, value sẽ được cập nhật.
2. V get(Object key): Trả về value tương ứng với key được chỉ định hoặc null nếu key không tồn tại.
3. boolean containsKey(Object key): Trả về true nếu Map chứa key được chỉ định.
4. boolean containsValue(Object value): Trả về true nếu Map chứa value được chỉ định.
5. boolean isEmpty(): Trả về true nếu Map không chứa bất kỳ entry nào.
6. void clear(): Xóa toàn bộ các entry khỏi Map.
7. V remove(Object key): Xóa entry tương ứng với key được chỉ định và trả về value của entry đó. Nếu key không tồn tại, trả về null.
8. int size(): Trả về số lượng entry trong Map.
9. void putAll(Map<? extends K, ? extends V> m): Thêm tất cả các entry trong Map m vào Map hiện tại.
10. Collection<V> values(): Trả về tập hợp các value trong Map.
11. Set<Map.Entry<K,V>> entrySet(): Trả về tập hợp các entry trong Map.
12. Set<K> keySet(): Trả về tập hợp các key trong Map.

*/
public class example {
    //Code theo và đọc lý thuyết nhé
    public static void main(String[] args) {
        Map<String, Integer> temp = new TreeMap<String, Integer>();
        //Bước đầu với put
        //1. V put(K key, V value): Thêm một entry mới vào Map. Nếu key đã tồn tại trong Map, value sẽ được cập nhật.
        temp.put("One", 1);
        temp.put("Two", 2);
        temp.put("Three", 3);
        //Duyệt map
        for (Map.Entry<String, Integer> entry : temp.entrySet()){
            System.out.println(entry);
        }
        /*
        output: 
            One=1
            Three=3
            Two=2
        Lưu ý lại: 
            • Về output của print khi đưa vào một đối tượng Entry trong Map vào làm đối số và in ra màn hình: 
                có dạng : key=value
            • Về Map.Entry sẽ được học sau, tuy nhiên nhớ lại rằng Map không duyệt được bằng for-each 
            • Map chỉ có thể duyệt bằng forEach từ java 8 trở lên thông qua ví dụ sau: 
        */
        temp.forEach((k, v)-> System.out.println("K: "+k+" V: "+v));
        /*Trong đoạn code trên hãy để ý đoạn code (k, v)-> System.out.println("K: "+k+" V: "+v)
        trong đối số của forEach là một biểu thức lambda. Lambda sẽ được học sau nhưng không trong Chương Map*/
        //Cố tình thêm một phương Map trùng key
        
        temp.put("One", 4);
        /*Vì key "One" đã tồn tại nên giá trị value của key đó được cập nhật mới*/
        
        //Sử dụng phương thức get (phương thức mới) để thực hiện chứng minh phương thức put trùng trên
        //2. V get(Object key): Trả về value tương ứng với key được chỉ định hoặc null nếu key không tồn tại.
        System.out.println(temp.get("One")); //output: 4 
        //Như vậy đối tượng One có value là 4
        
        //3. boolean containsKey(Object key): Trả về true nếu Map chứa key được chỉ định.
        temp.containsKey("One"); //true
        temp.containsKey("Nine"); //false
        
        //4. boolean containsValue(Object value): Trả về true nếu Map chứa value được chỉ định.
        temp.containsValue(1); //true 
        temp.containsValue(999); //false
        
        //5. boolean isEmpty(): Trả về true nếu Map không chứa bất kỳ entry nào.
        //6. void clear(): Xóa toàn bộ các entry khỏi Map.
        //7. V remove(Object key): Xóa entry tương ứng với key được chỉ định và trả về value của entry đó. 
        //8. int size(): Trả về số lượng entry trong Map.
        //9. void putAll(Map<? extends K, ? extends V> m): Thêm tất cả các entry trong Map m vào Map hiện tại.
        //10. Collection<V> values(): Trả về tập hợp các value trong Map.
        
        //Các phương thức sẽ được học sau trong các section liên quan tới các lớp triển khai interface Map
        //11. Set<Map.Entry<K,V>> entrySet(): Trả về tập hợp các entry trong Map.
        //12. Set<K> keySet(): Trả về tập hợp các key trong Map.
    }
    
}
