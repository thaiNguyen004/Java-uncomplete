/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_TheHashMapClass;

import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class putIfAbsent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<Integer, String> hm  = new HashMap<>();
        hm.put(1, null);
        hm.put(2, "Con chó");
        
        hm.putIfAbsent(1, "Con mèo"); //output null
        hm.putIfAbsent(2, "Con chim"); // output Con chó
    }
    
}
