/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_MapClasses;

import java.util.Map;
import java.util.TreeMap;

/*
Lớp TreeMap mở rộng AbstractMap và thực hiện giao diện NavigableMap. Nó tạo ra các 
bản đồ được lưu trữ trong cấu trúc cây. TreeMap cung cấp một phương tiện hiệu quả 
để lưu trữ cặp khóa/giá trị theo thứ tự được sắp xếp và cho phép truy xuất nhanh chóng. 
Bạn nên lưu ý rằng, khác với bản đồ băm, TreeMap đảm bảo rằng các phần tử của nó sẽ được sắp xếp 
theo thứ tự tăng dần của khóa. TreeMap là một lớp chung với khai báo như sau:
    class TreeMap<K, V>
Ở đây, K chỉ định kiểu của các khóa và V chỉ định kiểu của các giá trị. 
Các hàm tạo TreeMap sau được định nghĩa:
• TreeMap()
• TreeMap(Comparator<? super K> comp)
• TreeMap(Map<? extends K, ? extends V> m)
• TreeMap(SortedMap<K, ? extends V> sm)

• Dạng đầu tiên tạo ra một bản đồ cây rỗng sẽ được sắp xếp bằng cách sử dụng thứ tự tự nhiên của các khóa. 
• Dạng thứ hai tạo ra một bản đồ cây rỗng sẽ được sắp xếp bằng cách sử dụng Comparator comp. 
(Comparator được thảo luận sau). 
• Dạng thứ ba khởi tạo một bản đồ cây với các mục nhập từ m, 
sẽ được sắp xếp bằng cách sử dụng thứ tự tự nhiên của các khóa. 
• Dạng thứ tư khởi tạo một bản đồ cây với các mục nhập từ sm, 
sẽ được sắp xếp theo thứ tự giống như sm.

TreeMap không có các phương thức bản đồ ngoài các phương thức được chỉ định bởi 
giao diện NavigableMap và lớp AbstractMap.
Chương trình sau đây sửa đổi ví dụ trước đó để sử dụng TreeMap:
*/
public class b_TreeMap {

    public static void main(String[] args) {
        TreeMap<String, Double> tm = new TreeMap<>();
        tm.put("Naruto", 5102.13);
        tm.put("Kawaki", 7102.13);
        tm.put("Boruto", 12102.13);
    
        for (Map.Entry<String, Double> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + ": "+entry.getValue());
        }
        /*
            Boruto: 12102.13
            Kawaki: 7102.13
            Naruto: 5102.13
        Các entry trong TreeMap() được sắp xếp theo thứ tự tự nhiên của các khóa
        */
        
        Double strength = tm.get("Boruto");
        //Tăng sức mạnh cho Boruto thêm 1000
        tm.put("Boruto", strength + 1000);
        
        System.out.println("Sức mạnh mới của Boruto: "+tm.get("Boruto"));
    }
    
}
