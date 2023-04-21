/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package concurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author nguye
 */
public class demo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1, "Mèo");
        concurrentMap.put(2, "Mèo");
        concurrentMap.put(3, "Mèo");
        
        for(Map.Entry<Integer, String> entry : concurrentMap.entrySet()){
            if(entry.getValue().equals("Mèo")){
                concurrentMap.remove(entry.getKey());
            }
        }
        System.out.println(concurrentMap);
        //Kết quả trả về đúng !!! Xóa hết
        
        
    }
    
}
