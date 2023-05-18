/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMethodsMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nguye
 */
public class k_keySet_meth {

    /**
     * Set<K> keySet()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Phương thức keySet() của interface Map trong Java trả về một tập hợp (set) 
//        chứa tất cả các khóa (keys) có trong map đó. Cụ thể, phương thức này trả về một 
//        đối tượng Set<K> với K là kiểu dữ liệu của khóa trong map.

        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Tạo một Set lưu trữ tất cả các key của Map
        Set<String> keySet = ob.keySet();
        
        //duyệt Set
        keySet.forEach(k -> System.out.println("Key: " + k));
        
        /* 
            Key: Sarada
            Key: Kawaki
            Key: Boruto
            Key: Mitsuki
        */
    }
    
}
