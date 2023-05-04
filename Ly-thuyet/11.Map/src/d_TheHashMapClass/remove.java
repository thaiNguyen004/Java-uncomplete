/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_TheHashMapClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author nguye
 */
public class remove {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>() {};
        hashmap.put(1, "Chó");
        hashmap.put(0, "Chó");
        hashmap.put(3, "Mèo");
        
        //Xóa bằng forEach của collections
        //Exception in thread "main" java.util.ConcurrentModificationException sẽ xảy ra
        //Lý do là vì khi bạn có hành động muốn thay đổi cấu trúc của một collections trong khi 
        //đang có nhiều lượt duyệt chạy song song
        
        /**
        hashmap.forEach((k, v) -> {
            if(v.equals("Chó")){
                hashmap.remove(k);
            }
        });
        **/
        
        //Xóa bằng Iterator
        Iterator<Map.Entry<Integer, String>> it = hashmap.entrySet().iterator();
        while(it.hasNext()){
            if(it.next().getValue().equals("Chó")){
                it.remove();
            }
        }
        //Kết quả trả về là đúng !!!
        
        //Thêm phần tử
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "Táo");
        hm.put(2, "Ổi");
        hm.put(3, "Nho");
        for(Map.Entry<Integer, String> entry : hm.entrySet()){
            if(entry.getValue().equals("Ổi")){
                hm.put(4, "Ổi 2");
            }
        }
        System.out.println(hm.toString());
        //Kết quả trả về cũng lỗi vì không cho phép vừa thay đổi collection vừa chạy song song 
        //với các lượt duyệt song song
        
        //Tìm hiểu về ConcurrentHashMap
    }
    
}
