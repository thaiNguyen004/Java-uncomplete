package d_TheHashMapClass;


import java.util.HashMap;
import java.util.Map;


/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
/**
 *
 * @author nguye
 */
public class computeIfAbsent {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "Chó");
        hashmap.put(0, "Chó");
        hashmap.put(3, "Mèo");
        
        //Vì key 4 chưa tồn tại nên nó sẽ tạo ra một entry có key = 4 và value bằng mapping của key = 1 
        //cộng thêm " con"
        hashmap.computeIfAbsent(4, v->hashmap.get(1)+" con");
        System.out.println(hashmap.get(4)); //-> con chó
        
        //Vì key 1 đã tồn tại (present) nên không thay đổi gì
        hashmap.computeIfAbsent(1, v->hashmap.get(1)+" con");
        System.out.println(hashmap);
    }
    
}
