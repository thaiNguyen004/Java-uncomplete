/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b.StartedWithMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class p_replaceAll_meth {

    /**default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Phương thức replaceAll tiến hành thay đổi value của toàn bộ entry trong Map 
        bằng một biểu thức lambda*/
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Tiến hành cập nhật value của tất cả các entry tăng thêm 100
        ob.replaceAll((k,v) -> v += 100);
        
        //Kiểm tra
        ob.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));
        /*
            Key: Sarada Value: 101
            Key: Kawaki Value: 104
            Key: Boruto Value: 102
            Key: Mitsuki Value: 103
        */
    }
    
}
