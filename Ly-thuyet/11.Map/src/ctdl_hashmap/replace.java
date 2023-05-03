/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ctdl_hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class replace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Dạng 1 Trả về index nếu thay thế được ngược lại trả về null
        Map<String, Integer> ob1 = new HashMap<>(Map.of("one", 1, "two", 2));
        System.out.println(ob1.replace("two", 4)); //return 2
        System.out.println(ob1.replace("three", 4)); //return null
        ob1.forEach((k,v) -> System.out.println("K: "+k+" V: "+v));
        
        //Dạng 2 trả về true nếu tt được ngược lại trả về false
        Map<String, Integer> ob2 = new HashMap<>(Map.of("one", 1, "two", 2));
        System.out.println(ob2.replace("one", 999, 111)); 
        //return false vì không tìm thấy
        //cặp nào phù hợp
        
        System.out.println(ob2.replace("one", 1, 111));
        //return true
    }
    
}
