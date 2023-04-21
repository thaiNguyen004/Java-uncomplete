/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ctdl_hashmap;

import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class computeIfPresent {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("peter", 10);
        hashMap.put("anna", 20);
        hashMap.put("john", 30);
        
        //Nếu key đã tồn tại thì mới thay đổi bằng ánh xạ hàm dùng biểu thức lambda
        //Vì peter đã tồn tại nên giá trị value của peter cộng thêm 10
        hashMap.computeIfPresent("peter", (k,v)-> v + 10); // {peter=20, john=30, anna=20}

        //Chỉ thay đổi được giá trị của value, không thay đổi được giá trị của key
        //hashMap.computeIfPresent("john", (k,v)-> k + 10); //error
        
        //Nếu key chưa tồn tại thì không làm gì cả
        //Vì tom chưa tồn tại nên không có gì thay đổi
        hashMap.computeIfPresent("tom", (k,v)-> v + 10); //{peter=20, john=30, anna=20}
        
    }
    
}
