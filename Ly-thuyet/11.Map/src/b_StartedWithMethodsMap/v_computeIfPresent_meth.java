/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMethodsMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class v_computeIfPresent_meth {

    /**default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Phương thức computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) 
        trong interface Map của Java được sử dụng để cập nhật một entry trong Map nếu nó tồn tại 
        và có thể tính toán một giá trị mới cho entry đó dựa trên khóa và giá trị hiện tại của entry.

        Nếu entry đã tồn tại và không null, phương thức sẽ tính toán một giá trị mới cho entry đó dựa 
        trên khóa và giá trị hiện tại của entry bằng cách sử dụng hàm remappingFunction. 
        Nếu giá trị mới được tính toán khác null, entry sẽ được cập nhật với giá trị mới. 
        Nếu giá trị mới là null, entry sẽ được xóa khỏi Map.

        Nếu entry không tồn tại, phương thức sẽ không thực hiện bất kỳ hành động nào và trả về null.*/
        //[computeIfPresent success ? remappingFunction : ]
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        /* Nếu entry đã tồn tại và không null, phương thức sẽ tính toán một giá trị mới cho entry đó dựa 
        trên khóa và giá trị hiện tại của entry bằng cách sử dụng hàm remappingFunction. */
        System.out.println(ob.computeIfPresent("Sarada", (k,v) -> v + 10)); //remappingFunction = 11
        //Vì key đã tồn tại và value không null nên phương thức sẽ tính toán giá trị mới cho key 
        //dựa trên key và giá trị hiện tại `(k,v)` để tính toán giá trị mới chính là giá trị trả về
        //của remappingFunction
        //Yêu cầu phải đảm bảo giá trị trả về của remappingFunction phải khác null, 
        //nếu bằng null thì entry sẽ bị xóa khỏi Map
        
        //Duyệt 
        ob.forEach((k,v) -> System.out.println("Key: "+k + " Value: "+v));
        /*
        (giá trị key Sarada được thay đổi)
            Key: Sarada Value: 11 
            Key: Kawaki Value: 4
            Key: Boruto Value: 2
            Key: Mitsuki Value: 3
        */
        
        //Trường hợp không dùng tới tham số kiểu v
        System.out.println(ob.computeIfPresent("Sarada", (k, v) -> 50));  //remappingFunction = 50
        //Trong gvis dụ trước ta thấy remappingFunction lấy giá trị key trước để cộng thêm 10 như
        //được hiển thị trên kia. Tuy nhiên nếu trong remappingFunction không đề cập, hay nói cách khác
        //là không sử dụng tới v thì giá trị của entry có key k sẽ được ghi đè giá trị 50
        //còn ở ví dụ trước thì entry có key k được ghi đè value = v + 10
        
        //Duyệt
        ob.forEach((k,v) -> System.out.println("Key: "+k + " Value: "+v));
        /*
            Key: Sarada Value: 50
            Key: Kawaki Value: 4
            Key: Boruto Value: 2
            Key: Mitsuki Value: 3
        */
        
        //Trường hợp giá trị remappingFunction được cập nhật là giá trị null
        //khi đó entry sẽ bị xóa
        System.out.println(ob.computeIfPresent("Boruto", (k,v) -> v = null)); //remappingFunction = null
        //entry có key = "Boruto" sẽ bị xóa
        //Duyệt
        ob.forEach((k,v) -> System.out.println("Key: "+k + " Value: "+v));
        /*
            Key: Sarada Value: 50
            Key: Kawaki Value: 4
            Key: Mitsuki Value: 3
        */
        
        //Trường hợp Entry có key không tồn tại function sẽ không làm gì và trả về null
        System.out.println(ob.computeIfPresent("Naruto", (k,v) -> v = 100)); //remappingFunction = null
    }
    
}
