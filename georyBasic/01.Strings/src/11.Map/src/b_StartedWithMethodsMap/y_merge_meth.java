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
public class y_merge_meth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        • Phương thức merge trong Map được sử dụng để cập nhật giá trị của một khóa 
        trong Map bằng cách kết hợp giá trị cũ và giá trị mới thông qua một hàm remapping.
        • Cụ thể, khi gọi phương thức merge, nó sẽ kiểm tra xem khóa có tồn tại trong Map hay không. 
        • Nếu khóa đã tồn tại, phương thức sẽ sử dụng hàm remappingFunction để kết hợp giá trị cũ
        và giá trị mới và cập nhật giá trị mới vào Map. Nếu khóa chưa tồn tại, phương thức 
        sẽ thêm một entry mới vào Map với giá trị mới được cung cấp.
        • Phương thức merge trả về giá trị mới của khóa sau khi được cập nhật hoặc thêm mới.*/
        
        Map<String, Integer> ob = new HashMap<>();
        ob.put("Sarada", 1);
        ob.put("Boruto", 2);
        ob.put("Mitsuki", 3);
        ob.put("Kawaki", 4);
        
        //Trường hợp khóa tồn tại 
        System.out.println(ob.merge("Sarada", 50, (k,v) -> v + 10 )); //60
        //Cập nhật lại value của entry có khóa Sarada bằng cách lấy value truyền vào làm value mới 
        //đồng thời lấy value đó kết hợp với remappingFunction để tạo ra value mới 
        //Trong ví dụ bên trên value = 50 và dùng value đó làm đối số cho v tức là v = 50.
        //Biểu thức trên v + 10 cho thấy rằng 50 + 10 = 60.
        
        //Test
        ob.forEach((k,v)-> System.out.println("K: "+k +" V: "+v));
        
        
        
        //Trường hợp remappingFunction = null => cập nhật lại value cho entry đó mặc kệ remappingFunction trả về null
        System.out.println(ob.merge("Mitstuki", 14, (k, v) -> v = null)); //14
        
        //Test
        ob.forEach((k,v)-> System.out.println("K: "+k +" V: "+v));
        
        
        
        //Trường hợp khóa chưa tồn tại
        System.out.println(ob.merge("Minato", 99, (k,v) -> v ));  
        //Tạo ra một entry mới có key là "Minato" và value = 99
        
        //Test
        ob.forEach((k,v)-> System.out.println("K: "+k +" V: "+v));
    }
    
}
