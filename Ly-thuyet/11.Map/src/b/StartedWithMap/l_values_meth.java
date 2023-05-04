/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b.StartedWithMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class l_values_meth {

    /**
     * Collection<V> values()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Phương thức values() của interface Map trong Java trả về một Collection chứa tất cả 
//        các giá trị (values) có trong map đó. Cụ thể, phương thức này trả về một đối tượng Collection<V> 
//        với V là kiểu dữ liệu của giá trị value trong map.

        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Tạo một collection lưu trữ tất cả các value của Map
        Collection<Integer> col = ob.values();
        //Lưu ý cấp 1 : đối số kiểu của Collection generic phải trùng kiểu dữ liệu với kiểu dữ liệu value trong Map
        //Trong ob kiểu dữ liệu của value là Integer thì đối số kiểu trong collection generic cũng phải là Integer
        col.forEach(v -> System.out.println(v));
        /*
            1
            4
            2
            3
        Thứ tự bị xáo trộn?
        Việc bị xáo trộn các entry khi thực hiện in ra và không đồng nhất với thứ tự chèn
        Liên quan tới các lớp triển khai Map, một trong các nguyên nhân là HashMap, HashMap lưu trữ
        phần tử dưới dạng bảng băm (hashing) và do đó không đảm bảo thứ tự giữa các phần tử.
        Nếu muốn các phần tử không bị xáo trộn mà giữ được thứ tự chèn thì có thể sử dụng LinkedHashMap
        */
    }
    
}
