/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b.StartedWithMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class s_replace_meth {

    /**
     * default boolean replace(K key, V oldValue, V newValue)
       default V replace(K key, V value)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Phương thức replace tiến hành thay đổi value của một entry xác định bởi key
        truyền vào function*/
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Dạng 1 trả về true nếu thay đổi được (điều kiện là key và oldValue phải tồn tại)
        //Ngược lại trả về false
        //[replace success ? true : false]
        System.out.println(ob.replace("Boruto", 2, 100)); //true
        System.out.println(ob.replace("Boruto", 999, 100)); //false
        
        //Dạng 2 trả về null nếu không replace được, ngược lại trả về giá trị value tương
        //ứng của key sau đó mới cập nhật giá trị value
        System.out.println(ob.replace("Nagato", 50)); //null vì không replace được
        System.out.println(ob.replace("Kawaki", 50)); //4 là value cũ sau đó được cập nhật là 50
        
    }
    
}
