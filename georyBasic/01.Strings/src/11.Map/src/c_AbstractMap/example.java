/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_AbstractMap;

//create a custom map

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;


class CustomMap <K,V> extends AbstractMap<K, V> {

    //Mảng đối tượng dùng để lưu trữ các cặp key value
    private Object[] entries;
    private int size;
    CustomMap() {
        //Khi khởi tạo lớp MyMap này sẽ được cấp phát bộ nhớ lưu trữ 10 entries
        entries = new Object[10];
        //Và qui định size = 0
        size = 0;
    }
    
    @Override
    public V put(K key, V value) {
        for (int i = 0; i < size; i+=2) {
            /*
            • entries[i] == null && key == null: Kiểm tra nếu phần tử entries[i] trong mảng entries là null 
            và key được truyền vào cũng là null. Nếu cả hai đều đúng, nghĩa là đã tìm thấy một entry có 
            key là null và ta có thể thay đổi value tương ứng.
            trường hợp này sảy ra khi bạn thực hiện hành động sau: 
            
                Map<String, Integer> map = new hashMap<>();
                map.put(null, 10);
            
            • entries[i] != null && entries[i].equals(key): Kiểm tra nếu phần tử entries[i] không null 
            và bằng key được truyền vào. Nếu điều kiện này đúng, nghĩa là đã tìm thấy một entry có key 
            trùng khớp và ta có thể thay đổi value tương ứng.
            trường hợp này sảy ra khi bạn thực hiện hành động put entry có key đã tồn tại */
            if(entries[i] == null && key == null || entries[i] != null && entries[i].equals(key)){
                //gán giá trị value (entries[i+1] cho biến oldValue)
                V oldValue = (V) entries[i+1];
                entries[i+1] = value;
                //Khi put 1 phần tử có key đã tồn tại thì giá trị value của key đó sẽ được cập nhật
                //đồng thời trả về giá trị value trước đó
                return oldValue;
            }
        }
        
        //Dưới này sẽ rơi vào trường hợp put giá trị mới
        
        //Gọi hàm ensureCapacity với giá trị minCapacity = size + 2 để kiểm tra mảng có chứa được 2 phần tử tiếp không
        //Nếu không thì phải tăng kích thước còn nếu vẫn chứa được thì thôi
        ensureCapacity(size + 2);
        entries[size++] = key;
        entries[size++] = value;
        //sau mỗi lần put thì size sẽ tăng thêm 2 
        return null;
        //Khi put thành công thì phương thức put mặc định trả về null
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < size; i+=2) {
            if(entries[i] == null && key == null || entries[i] != null && entries[i].equals(key)) {
                return (V) entries[i+1];
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        //...
        return null;
    }
    /*
    • Phương thức ensureCapacity trong ví dụ CustomMap được sử dụng để đảm bảo rằng mảng entries 
    có đủ dung lượng (capacity) để chứa các cặp key-value khi thêm vào CustomMap.
    • Trong một CustomMap, khi thêm một cặp key-value mới, chúng ta cần kiểm tra xem mảng entries 
    đã đạt đến giới hạn dung lượng hay chưa. 
    Nếu không đủ dung lượng, chúng ta cần tăng kích thước của mảng để có thể chứa thêm các cặp mới.
    */
    
    private void ensureCapacity (int minCapacity) {
        //Khởi tạo dung lượng hiện tại
        int oldCapacity = entries.length;
        //Kiểm tra nếu minCapacity nhỏ hơn dung lượng hiện tại của mảng entries, 
        //không cần thay đổi gì và phương thức kết thúc.
        if(minCapacity > oldCapacity) { //Cần phải tăng kích thước cho mảng
            /*Tính toán dung lượng mới (newCapacity) bằng cách tăng dung lượng hiện tại 
            lên một lượng bổ sung. 
            Trong ví dụ, dung lượng mới được tính bằng cách thêm nửa dung lượng hiện tại 
            (oldCapacity >> 1) vào dung lượng hiện tại. Điều này tạo ra một mảng mới với dung lượng 
            gần gấp đôi so với dung lượng hiện tại*/
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            /*Kiểm tra nếu dung lượng mới (newCapacity) vẫn còn nhỏ hơn minCapacity, sử dụng minCapacity thay thế.*/
            if(newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            /*Tạo một mảng mới (newEntries) với dung lượng mới và sao chép các phần tử từ mảng entries 
            hiện tại sang mảng mới, sử dụng phương thức System.arraycopy(). */
            Object[] newEntries = new Object[newCapacity];
            /*
                public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            Object src : mảng from
            int srcPos : vị trí bắt đầu trong mảng from
            Object dest : mảng to
            int destPos : vị trí bắt đầu trong mảng to
            int length : số lượng phần tử muốn copy trong mảng from
            */
            //Thực hiện copy (size) phần tử từ mảng entries tới mảng newEntries
            System.arraycopy(entries, 0, newEntries, 0, size);
            
            //Gán mảng newEntries làm mảng entries để thay thế mảng cũ.
            entries = newEntries;
        }
    }
    
}
public class example {

    public static void main(String[] args) {
        CustomMap<String, Integer> map = new CustomMap<>();
        map.put("Nguyễn Thái Nguyên", 100);
        map.put("Nguyễn Văn B", 101);
        map.put("Nguyễn Văn A", 4500);
        System.out.println(map.get("Nguyễn Thái Nguyên")); //100
        System.out.println(map.get(null));
    }
}
