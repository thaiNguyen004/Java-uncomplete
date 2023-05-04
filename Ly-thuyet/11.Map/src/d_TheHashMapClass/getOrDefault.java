/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class getOrDefault {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "john");
        hm.put(2, "peter");
        hm.put(3, "anna");
        
        hm.get(1); // trả về john
        hm.get(4); // trả về null
        hm.getOrDefault(4, "Méo có giá trị nào"); //trả về "méo có giá trị nào"
    
    }
}
