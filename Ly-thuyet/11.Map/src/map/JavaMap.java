/**
 * Nguyễn Thái Nguyên
 * Map là một interface có cấu trúc dữ liệu dạng K-V (key - value) và không chứa phần tử lặp
 * Map methods
 * 1.put(key, value)
 * 2.get(key)
 * 3.remove(key)
 * 4.containsKey(key)
 * 5.keySet() một Set chứa các key
 * 6.values() một collection chứa các value
 * 7.putIfAbsent(key, value) trả về null nếu put được <=> trả về key đã có
 */
package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class JavaMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        //put => thêm phần tử vào map
        map.put("Apple", 5);
        map.put("Orange", 12);
        map.put("Orange", 12);
        //map {Apple=5, Orange=12}
        
        //get lấy ra phần tử dựa vào key của nó
        System.out.println(map.get("Orange")); // output: 12
        
        //remove xóa phần tử khỏi map từ key
        System.out.println(map.remove("Orange")); //output: 12 đồng thời xóa 
        System.out.println(map.toString()); // {Apple=5}
        
        
        //putIfAbsent trả về null nếu chưa có entry đó trong map, ngược lại trả về key
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Orange", 1);
        map2.put("Apple", 2);
        map2.put("Potatos", 0);
        map2.put("Potato", 3);
        System.out.println(map2.putIfAbsent("Apple", 2)); 
        //do đã tồn tại nên phương thức này trả về key của entry trước đó
        
        //containsKey
        System.out.println(map2.containsKey("Apple")); //tồn tại => true
        //containsValue
        System.out.println(map2.containsValue(3)); // true
        System.out.println(map2.containsValue(5)); // false
        
        //keySet
        Set<String> listKey = map2.keySet();
        System.out.println(listKey);
        //[Potato, Apple, Orange]
        
        //values thứ tự không xác định
        Collection<Integer> listValue = map2.values();
        System.out.println(listValue.toString());
        //[0, 3, 2, 1]
        //Khi đó muốn lưu trữ các key hoặc các value mà muốn sắp xếp thì khuyên dùng List với Map.Entry
        
        List<Map.Entry<String, Integer>> entry = new ArrayList<>(map2.entrySet());
//      for(Map.Entry<String, Integer> item : entry){
//         System.out.println(item.getValue());
//            //[0, 3, 2, 1] vẫn theo thứ tự giống như collection nhưng vì là list nên ta dễ dàng sắp xếp 
//      }
        
        Collections.sort(entry, (o1,o2)-> o1.getValue().compareTo(o2.getValue()));
        for(Map.Entry<String, Integer> item : entry){
            System.out.println(item.getValue());
            //[0, 1, 2, 3] giá trị đã được sắp xếp
        }   
        //Và có thể sử dụng sort để sắp xếp dựa trên key nữa ...
        
        
        //Iterator => map không có iterator nhưng nếu muốn ta có thể sử dụng một Set chứa Map.Entry
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Nguyên", 12);
        map3.put("Vinh", 31);
        map3.put("Dũng", 11);
        
        Set<Map.Entry<String, Integer>> set = new HashSet<>(map3.entrySet());
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> subMap = it.next();
            it.next().getKey();
        }
    }
    
}
