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
public class q_putIfAbsent_meth {

    /**default V putIfAbsent(K key, V value)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Phương thức putIfAbsent(K key, V value) trong Map được sử dụng để thêm một cặp key-value
        vào map nếu nó không tồn tại và đồng thời trả về null. 
        Nếu key đã có trong map, phương thức sẽ trả về giá trị tương ứng với key đó 
        mà không thay đổi giá trị của value.*/
        //[putIfAbsent success ? null : V]
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Trường hợp put key đã tồn tại
        System.out.println(ob.putIfAbsent("Mitsuki", 7)); //3
        
        //Trường hợp put key chưa tồn tại
        System.out.println(ob.putIfAbsent("Madara", 99)); //null
    }
    
}
