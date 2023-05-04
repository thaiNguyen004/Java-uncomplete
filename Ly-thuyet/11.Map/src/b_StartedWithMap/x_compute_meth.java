/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class x_compute_meth {

    /**default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Phương thức default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) 
        trong interface Map có chức năng thay đổi giá trị của entry với key cho trước bằng cách áp dụng
        một hàm tính toán được chỉ định.

        Phương thức này nhận vào một key và một BiFunction được sử dụng để tính toán giá trị mới cho entry. 
        Nếu entry đã tồn tại trong map với key tương ứng, hàm remappingFunction sẽ được áp dụng trên 
        key và value hiện tại để tính toán giá trị mới. Nếu giá trị tính toán được trả về là null, 
        entry tương ứng sẽ bị xóa khỏi map. Nếu giá trị mới khác null, giá trị của entry sẽ được thay đổi 
        bằng giá trị mới tính toán được.*/

            Map<String, Integer> ob = new HashMap<>();
            ob.put("Sarada", 1);
            ob.put("Boruto", 2);
            ob.put("Mitsuki", 3);
            ob.put("Kawaki", 4);
            
//        Nếu key tồn tại trong map sẽ sảy ra 2 trường hợp, 
//        nếu giá trị == null thì entry đó sẽ bị xóa,
//        nếu giá trị không null thì entry đó sẽ được cập nhật giá trị mới
        System.out.println(ob.compute("Kawaki", (k,v) -> v + 10)); //14
        //Vì là Kawaki là key đã tồn tại, nên phương thức cập nhật giá trị cho value qua remappingFunction

        //Nếu key tồn tại nhưng remappingFunction trả về null thì entry sẽ bị xóa
        System.out.println(ob.compute("Kawaki", (k,v) -> v = null)); //null và entry bị xóa
        
//        Nếu không có entry nào tồn tại trong map với key tương ứng, phương thức sẽ tạo ra một entry
//        mới. Với key được chỉ định, và value tính toán remappingFunction 
        System.out.println(ob.compute("NonContains", (k,v) -> v = 100));
        ob.forEach((k, v) -> System.out.println("K: "+k+" V: "+v));
        
    }
    
}
