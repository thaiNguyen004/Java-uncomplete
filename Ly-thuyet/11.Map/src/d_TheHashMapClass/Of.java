/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

import java.util.HashMap;
import java.util.Map;

public class of {

    public static void main(String[] args) {
        /*default Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6): 
        Trả về một SortedMap chứa sáu cặp key-value.*/
        
        /* Khi sử dụng phương thức Map.of() để khởi tạo một Map thì đối tượng trả về 
        sẽ không phải là đối tượng của lớp HashMap. Phương thức Map.of() trả về một 
        Map bất biến (immutable) được triển khai bằng cách sử dụng một cách triển khai 
        tối ưu hơn cho các trường hợp cụ thể. Các phương thức trên đối tượng trả về này 
        khác với các phương thức của lớp HashMap, 
        ví dụ như chúng không cho phép thay đổi các phần tử trong Map.*/
        Map<String, Integer> ob = Map.of("one", 1, "two", 2, "three", 3);
        
        //Cách triển khai phương thức of có sử dụng cấu trúc dữ liệu hash map
        Map<String, Integer> ob2 = new HashMap<>(Map.of("one", 1, "two", 2));
    }
    
}
