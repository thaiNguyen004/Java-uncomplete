/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_MapClasses;

/*
• LinkedHashMap mở rộng từ HashMap. Nó duy trì một danh sách liên kết các entry trong bản đồ, 
theo thứ tự chúng được chèn vào. 
• Điều này cho phép lặp lại theo thứ tự chèn vào qua bản đồ. Nghĩa là, khi lặp lại qua 
một LinkedHashMap, các phần tử sẽ được trả về theo thứ tự chúng được chèn vào. 
Bạn cũng có thể tạo một LinkedHashMap trả về các phần tử của nó theo thứ tự chúng 
được truy cập cuối cùng. LinkedHashMap là một lớp chung có khai báo như sau:
    
    class LinkedHashMap<K, V>

• Ở đây, K chỉ định loại khóa và V chỉ định loại giá trị.
LinkedHashMap định nghĩa các hàm tạo sau:
  LinkedHashMap()
  LinkedHashMap(Map<? extends K, ? extends V> m)
  LinkedHashMap(int capacity)
  LinkedHashMap(int capacity, float fillRatio)
  LinkedHashMap(int capacity, float fillRatio, boolean Order)
• Dạng đầu tiên xây dựng một LinkedHashMap mặc định. 
• Dạng thứ hai khởi tạo LinkedHashMap với các phần tử từ m. 
• Dạng thứ ba khởi tạo và quy định sức chứa. 
• Dạng thứ tư khởi tạo LinkedHashMap và quy định cả sức chứa và tỷ lệ lấp đầy. 
Ý nghĩa của sức chứa và tỷ lệ lấp đầy giống như với HashMap. Sức chứa mặc định là 16. 
Tỷ lệ mặc định là 0,75. 
•Dạng cuối cùng cho phép bạn chỉ định liệu các phần tử sẽ được lưu trữ trong 
danh sách liên kết theo thứ tự chèn vào hoặc theo thứ tự truy cập cuối cùng. 
Nếu Order là true, thì sử dụng thứ tự truy cập. Nếu Order là false, thì sử dụng thứ tự chèn vào.

LinkedHashMap chỉ thêm một phương thức vào những phương thức đã được định nghĩa bởi HashMap. 
Phương thức này là removeEldestEntry() và được định nghĩa như sau:

protected boolean removeEldestEntry(Map.Entry<K, V> e)

Phương thức này được gọi bởi put() và putAll(). Entry cũ nhất được truyền vào trong e. 
Mặc định, phương thức này trả về false và không làm gì cả. Tuy nhiên, nếu bạn ghi đè 
phương thức này, bạn có thể làm cho LinkedHashMap xóa entry cũ nhất trong bản đồ. 
Để làm điều này, hãy cho phương thức ghi đè của bạn trả về true. Để giữ entry cũ nhất, trả về false.
*/
public class c_LinkedHashMap {
    
    public static void main(String[] args) {
        
    }
    
}
