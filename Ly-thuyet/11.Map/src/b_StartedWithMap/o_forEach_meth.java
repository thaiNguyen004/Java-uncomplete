/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMap;

import java.util.HashMap;
import java.util.Map;

/**
 * forEach chỉ sử dụng cho các phiên bản Java >= 8
 * @author nguye
 */
public class o_forEach_meth {

    /**default void forEach(BiConsumer<? super K, ? super V> action)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Phương thức forEach lặp lại qua tất cả các entry (cặp key-value) trong Map 
        và áp dụng một hành động được chỉ định trong biểu thức lambda cho từng entry. 
        Hành động này được thực hiện thông qua đối tượng BiConsumer, 
        với đầu vào là khóa và giá trị của mỗi entry.*/
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Tăng value thêm 100 cho tất cả entry lặp qua
        ob.forEach((k,v) -> v += 100);
        
        /*Ta thấy có vài vấn đề về việc thay đổi một biến bên ngoài thông qua forEach
        Trong một lambda expression của phương thức forEach của Map, bạn không thể thay đổi 
        giá trị của phần tử hiện tại mà đang được truy cập, bởi vì lambda expression 
        là một hàm không đổi (immutable function).*/
        
        //Để làm điều này có thể áp dụng cách sau:
        ob.forEach((k,v) -> {
            if(k.equals("Sarada")){
                ob.put(k, v + 100);
            }
        });
        //Tiến hành tìm nếu có key nào == "Sarada" thì thay đổi value của entry đó bằng put
        //Kiểm tra 
        ob.forEach((k,v) -> System.out.println("Key: "+k +" Value: "+v));
        
        /*
                Key: Sarada Value: 101
                Key: Kawaki Value: 4
                Key: Boruto Value: 2
                Key: Mitsuki Value: 3
        */
        
        /*Chú ý `(k,v) ->`
        Ở đây (k,v) là 2 đối số truyền vào cho hàm tạo BiConsumer, 
        Chưa cần quan tâm tới lambda vì sẽ được học sau (nâng cao)
        */
    }
    
}
