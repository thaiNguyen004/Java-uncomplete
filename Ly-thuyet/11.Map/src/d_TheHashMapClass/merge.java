/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

import java.util.HashMap;
import java.util.Map;

public class merge {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("john", 20);
        map.put("paul", 30);
        map.put("peter", 40);
        //Vì key "john" đã tồn tại nên phương thức merge sẽ cập nhật giá trị value của john theo biểu thức lambda
        map.merge("john", 80, (k,v)-> map.get("paul") + 100); // {peter=40, john=130, paul=30}
        
        //Vì key "paul" đã tồn tại nên phương thức merge sẽ cập nhật giá trị value của paul theo biểu thức lambda
        map.merge("paul", 15, (k, v)-> map.get("paul") * 10);
        
        //Vì key "paul" đã tồn tại, quan sát cú pháp bên dưới ta thấy phương thức merge đang thay đổi value của paul
        //biến `v` trong biểu thức lambda nhận giá trị value xác định bởi hàm
        map.merge("paul", 15, (k, v)-> v * 10);
        
        //Vì key "kelly" chưa tồn tại nên phương thức merge sẽ tạo ra một cặp k,v mới có key=kelly và value xác định bởi hàm  
        map.merge("kelly", 15, (k, v)-> map.get("peter") + 5); //{peter=40, john=130, paul=30, kelly=15}
        
        System.out.println(map);
        
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("john", 12);
        map1.put("peter", 20);
        
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("merry", 32);
        map2.put("paul", 9);
        
        
        HashMap<String, Integer> mergeMap = new HashMap<>(map1);
        mergeMap.put("paul", 9);
        map2.forEach((k,v)-> mergeMap.merge(k, v, Integer::sum));
        
        System.out.println(mergeMap);
    }

}
