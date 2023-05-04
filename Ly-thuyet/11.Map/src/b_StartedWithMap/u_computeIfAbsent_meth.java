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
public class u_computeIfAbsent_meth {

    /**default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        • Phương thức default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) 
        trong interface Map<K, V> được sử dụng để tính toán và đưa ra giá trị mới cho một khóa (key) đã cho, 
        chỉ nếu khóa đó chưa tồn tại trong Map, hoặc nếu giá trị của khóa là null.

        • Phương thức nhận vào một khóa key và một đối tượng 
        mappingFunction kiểu Function<? super K, ? extends V> để tính toán giá trị mới của khóa nếu khóa chưa 
        tồn tại trong Map. Nếu khóa đã tồn tại và có giá trị khác null thì phương thức sẽ trả về giá trị 
        hiện có của khóa đó. Nếu khóa chưa tồn tại hoặc có giá trị là null, phương thức sẽ tính toán giá trị
        mới của khóa đó bằng cách sử dụng mappingFunction và đặt giá trị value mới vào Map. Sau đó, phương thức 
        sẽ trả về giá trị mới của khóa.*/
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Trường hợp khóa chưa tồn tại hoặc bằng null
        System.out.println(ob.computeIfAbsent("Sasuke", v -> 5)); 
        //Vì khóa Sasuke chưa tồn tại nên phương thức sẽ tạo ra một Entry mới có key = "Sasuke" 
        //và value = 5 đồng thời trả về giá trị value của khóa "Sasuke"
        
        //Trường hợp khóa tồn tại hoặc khác null
        System.out.println(ob.computeIfAbsent("Sarada", v -> 10));
        //Vì khóa Sarada đã tồn tại nên phương thức sẽ không làm gì và
        //trả về giá trị hiện có của Map
        
    }
    
}
