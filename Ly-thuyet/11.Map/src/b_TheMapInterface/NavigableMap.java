/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_TheMapInterface;

/*
Giao diện NavigableMap mở rộng SortedMap và khai báo hành vi của một bản đồ (map) hỗ trợ việc 
lấy các entry dựa trên sự khớp gần nhất với một key hoặc keys cụ thể. NavigableMap 
là một giao diện generic, có khai báo như sau:

    interface NavigableMap<K,V>

Ở đây, K chỉ định kiểu của các keys, và V chỉ định kiểu của các giá trị liên kết với keys. 
Ngoài các phương thức kế thừa từ SortedMap, NavigableMap thêm các phương thức được tóm tắt trong Bảng 19-13. 
Một số phương thức ném ra ngoại lệ ClassCastException khi một đối tượng không tương thích với keys trong map. 
NullPointerException được ném ra nếu cố gắng sử dụng một đối tượng null và null keys không được phép trong tập hợp. 
Một IllegalArgumentException được ném ra nếu sử dụng một đối số không hợp lệ.
*/


public class NavigableMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
