/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_TheHashMapClass;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class replaceAll {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "Chó");
        hashmap.put(0, "Chó");
        hashmap.put(3, "Mèo");

        //replace kiểm tra xem có khóa `1` không nếu có thì thay thế bằng giá trị value
        hashmap.replace(1, "Chim");
        System.out.println(hashmap);

        //replaceAll
        Map<String, Integer> map = new HashMap<>();
        map.put("john", 20);
        map.put("paul", 30);
        map.put("peter", 40);
        map.replaceAll((key, value) -> value+10);
        System.out.println(map.toString());
    }

}
