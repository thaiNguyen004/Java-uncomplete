/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author nguye
 */
public class KeySet {
    public static void main(String[] args) {
        //KeySet là một phương thức trong map giúp trả về một tập hợp các key 
        Map<Integer, String> map = new TreeMap<>();
        map.put(5, "Nguyên 1");
        map.put(6, "Nguyên 2");
        map.put(7, "Nguyên 3");
        map.put(8, "Nguyên 4");
        
        //Tạo một set để lưu trữ
        Set<Integer> set = map.keySet();
        
        //Duyệt keyset
        System.out.println("Duyệt bằng for each");
        for(Integer key : map.keySet()){
            System.out.print(key + " ");
        }
        
        //Duyệt bằng Iterator
        System.out.println("\nDuyệt bằng Iterator");
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            System.out.print(key + " ");
        }
        
        //Duyệt bằng forEach java 8+
        System.out.println("\nDuyệt bằng forEach java8+");
        map.keySet().forEach(k -> System.out.print(k + " "));
        
        //Duyệt bằng stream java 8+
        System.out.println("\nDuyệt bằng Stream.foreach java8+");
        map.keySet().stream().forEach(e -> System.out.print(e + " "));
        
        //Duyệt for với iterator
        System.out.println("\nDuyệt bằng for with iterator");
        for(Iterator<Integer> it2 = map.keySet().iterator(); it2.hasNext();){
            System.out.print(it2.next() + " ");
        }
        
    }
    
}
