/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_MapClasses;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
• Lớp EnumMap mở rộng AbstractMap và thực hiện (implement) Map. Nó được thiết kế 
đặc biệt để sử dụng với các khóa thuộc loại enum. Đây là một lớp chung có khai báo dạng kiểu như sau:

    class EnumMap<K extends Enum<K>, V>

• Ở đây, K chỉ định kiểu của khóa, và V chỉ định kiểu của giá trị. Lưu ý rằng K phải 
mở rộng Enum<K>, điều này bắt buộc các khóa phải thuộc loại enum.
• EnumMap định nghĩa các constructor sau:
    EnumMap(Class<K> kType)
    EnumMap(Map<K, ? extends V> m)
    EnumMap(EnumMap<K, ? extends V> em)
• Constructor đầu tiên tạo một EnumMap rỗng của kiểu kType. 
• Constructor thứ hai tạo ra một bản đồ EnumMap chứa các mục nhập giống như m. 
• Constructor thứ ba tạo ra một EnumMap được khởi tạo với các giá trị trong em.
EnumMap không định nghĩa bất kỳ phương thức riêng nào của nó.
*/
public class e_EnumMap {
    enum Season {
        SPRING, SUMMER, FALL, WINTER
    }
    public static void main(String[] args) {
        //EnumMap(Class<K> kType)
        EnumMap<Season, String> con1 = new EnumMap<>(Season.class);
        con1.put(Season.SPRING, "Mùa xuân");
        con1.put(Season.SPRING, "Mùa xuân");
        con1.put(Season.FALL, "Mùa thu");
        con1.put(Season.SPRING, "Mùa xuân");
        con1.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v)); System.out.println();
        /*
            Key: SPRING Value: Mùa xuân
            Key: FALL Value: Mùa thu
        */
        
        //EnumMap(Map<K, ? extends V> m)
        
        Map<Season, String> map = new EnumMap<>(Season.class);
        map.put(Season.SPRING, "Mùa xuân");
        map.put(Season.SUMMER, "Mùa hè");
        map.put(Season.FALL, "Mùa thu");
        map.put(Season.WINTER, "Mùa đông");
        
        System.out.println("Duyệt Entry trong map ");
        map.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v)); System.out.println();
        
        EnumMap<Season, String> con2 = new EnumMap<>(map);
        System.out.println("Duyệt Entry trong con2 ");
        con2.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));
        
        /*
            Duyệt Entry trong map 
            Key: SPRING Value: Mùa xuân
            Key: SUMMER Value: Mùa hè
            Key: FALL Value: Mùa thu
            Key: WINTER Value: Mùa đông

            Duyệt Entry trong con2 
            Key: SPRING Value: Mùa xuân
            Key: SUMMER Value: Mùa hè
            Key: FALL Value: Mùa thu
            Key: WINTER Value: Mùa đông
        Các entry được sao chép từ Map<K extends Enum<K>, V>, lưu ý rằng để sao chép từ Map, 
        • Map đó phải được thực hiện dưới class EnumMap, và K của Map phải cùng enum với class
        EnumMap 
        • Ví dụ bên trên đang cố gắng copy các entry từ một Map sang một EnumMap
            Và Map đó phải được thực hiện bởi class EnumMap() và đối số trong construct của Map đó
            là một định nghĩa Enum được sử dụng cho Map này, trong ví dụ trên định nghĩa Enum là 
            enum Season, Sau đó tạo ra một đối tượng EnumMap với đối số kiểu generic K phải trùng với đối số 
            kiểu K của Map bên trên,
            vì mình đang muốn copy từ Map bên trên vào EnumMap này nên đối số kiểu K phải là cùng  một enum Season
            . Tiếp theo phần construct của EnumMap nhận vào một đối tượng Map là map
        */
        
        //EnumMap(EnumMap<K, ? extends V> em)
        EnumMap<Season, String> enumMap1 = new EnumMap<>(Season.class);
        enumMap1.put(Season.SUMMER, "Mùa hè");
        
        EnumMap<Season, String> enumMap2 = new EnumMap<>(enumMap1);
        
        /*Trong ví dụ bên trên đang thực hiện sao chép một enumMap và đưa vào constructor của một
        enumMap khi đó toàn bộ entry của enumMap1 sẽ được sao chép tới enumMap2
        Tất nhiên đối số kiểu generic K phải là cùng 1 enum*/
        
    }
    
}
