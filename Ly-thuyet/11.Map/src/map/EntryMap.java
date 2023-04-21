/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author nguye
 */
public class EntryMap {
    public static void main(String[] args) {
        
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "Nguyên 1");
        map.put(2, "Nguyên 2");
        map.put(3, "Nguyên 3");
        map.put(4, "Nguyên 4");
        
        //Map.Entry là một interface và nó có thể thêm các cặp key value vào nhưng nên dùng map thôi
        
        System.out.println("Dùng iterator để duyệt một Entry");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        //Foreach 1
        System.out.println("Dùng foreach để duyệt một Entry");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        //Foreach 2
        System.out.println("Dùng foreach java 8+ để duyệt một Entry");
        map.forEach((k,v) -> System.out.println(k + " " + v));
        
        //Dùng for để duyệt iterator
        System.out.println("Dùng for để duyệt iterator");
        for(Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator(); it2.hasNext(); ){
            Map.Entry<Integer, String> temp = it2.next();
            System.out.println(temp);
        }
        
        //Stream.forEach java 8+ -- có bài riêng về stream
        System.out.println("Stream.forEach java 8+");
        map.entrySet().stream().forEach(e -> System.out.println(e));
        
        //Qua kết quả so sánh thì có vẻ như sử dụng forEach với java 8 là phương án 
        //duyệt phần tử tối ưu nhất
    }
    
}
