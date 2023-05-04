/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class n_getOrDefault_meth {

    /**default V getOrDefault(Object key, V defaultValue)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Phương thức getOrDefault(Object key, V defaultValue) là một phương thức 
        của interface Map trong Java. Nó được sử dụng để trả về giá trị của phần tử 
        có khóa key trong Map nếu có tồn tại, 
        hoặc trả về giá trị defaultValue nếu không tồn tại phần tử với khóa key.
        */
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        System.out.println(ob.getOrDefault("Sarada", -1)); //1
        System.out.println(ob.getOrDefault("Kakashi", -1)); //-1
        
        /*
        - Ta có thể thấy ở lần get 1 thì giá trị key Sarada có tồn tại nên giá trị trả 
        về là value của key đó
        - Ta có thể thấy ở lần get 2 thì giá trị key Kakashi không tồn tại nên giá trị trả
        về là value default được qui định bởi hàm*/
    }
    
}
