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
public class m_entrySet_meth {

    /**
     * Set<Map.Entry<K, V>> entrySet()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Phương thức entrySet() trong Map được sử dụng để trả về một tập hợp (set) 
//        chứa tất cả các entry (cặp key-value) trong map. Mỗi entry được đóng gói 
//        trong một đối tượng của lớp Map.Entry.

        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Tạo một Set lưu trữ tất cả các key của Map
        Set<Map.Entry<String, Integer>> entrySet = ob.entrySet();
        
        //duyệt Set
        entrySet.forEach(e -> System.out.println("Key: "+e.getKey() +" Value: "+e.getValue()));
        /*
            Chú ý trong forEach e là đại diện cho một phần tử trong Set, mà một phần tử trong Set là
            một đối tượng Map.Entry nên ta có thể lấy key và value thông qua phương thức: getKey(), getValue()
        
            Key: Sarada Value: 1
            Key: Kawaki Value: 4
            Key: Boruto Value: 2
            Key: Mitsuki Value: 3
        */    
    }
}
