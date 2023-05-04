/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class compute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("john", 20);
        map.put("paul", 30);
        map.put("peter", 40);
        
        //compute là tổng hợp của computeIfAbsent và computeIfPresent
        //Nếu key chưa tồn tại thì sẽ thêm một phần tử mới vào với key xác định bởi hàm, 
        //value phụ thuộc vào ánh xạ hàm và biểu thức lambda
        //Nếu key đã tồn tại thì phụ thuộc vào lambda để thay đổi value của key đó
        
        map.compute("john", (k,v) -> v + 10);
        map.compute("anna", (k,v) -> map.get("john") + 10);
        System.out.println(map);
    }

}
