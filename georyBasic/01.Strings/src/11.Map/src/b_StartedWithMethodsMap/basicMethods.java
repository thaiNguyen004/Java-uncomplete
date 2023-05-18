/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_StartedWithMethodsMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
a, int size()
b, boolean isEmpty()
c, boolean containsKey(Object key)
d, boolean containsValue(Object value)
e, V get(Object key)
f, V put(K key, V value)
g, V remove(Object key)
h, void putAll(Map<? extends K, ? extends V> m)
i, void clear()
*/
public class basicMethods {
    static Map<String,Integer> createMap(Map<String,Integer> map){
        Map<String, Integer> ob = map;
        ob.put("kakashi", 12412);
        ob.put("boruto", 8412);
        ob.put("ada", 24212);
        ob.put("kaguya", 32122);
        return ob;
    }
    public static void main(String[] args) {
        //int size() trả về kích thước phần tử thực của Map
        Map<String, Integer> ob1 = new HashMap<>();
        ob1 = createMap(ob1);
        System.out.println(ob1.size()); //out : 4
        
        //boolean isEmpty() kiểm tra trống 
        //[trống ? true : false]
        System.out.println(ob1.isEmpty()); //false
        
        //boolean containsKey(Object key)
        //kiểm tra đối tượng key truyền vào meth có tồn tại không
        //[tồn tại ? true : false]
        System.out.println(ob1.containsKey("kaguya")); //true
        System.out.println(ob1.containsKey("nobita")); //false
        
        //boolean containsValue(Object value)
        //kiểm tra đối tượng value truyền vào meth có tồn tại không
        //[tồn tại ? true : false]
        System.out.println(ob1.containsValue(1)); //false
        System.out.println(ob1.containsValue(32122)); //true
        
        //V get(Object key)
        //trả về V (value) tương ứng với key truyền vào
        //[tồn tại ? V : null]
        System.out.println(ob1.get("ada")); //24212
        System.out.println(ob1.get("nobita")); //null
        
        //V put(K key, V value)
        //Thêm một Entry vào map với K và V được truyền vào
        //[Thêm thành công ? null : V]
        System.out.println(ob1.put("boruto", 11001));
        //8412 - lý do vì key "boruto" đã tồn tại nên không thêm được Entry vào, 
        //đồng thời trả về value cũ của boruto trước đó
        System.out.println(ob1.put("sarada", 11001));
        //null - lý do vì thêm thành công
        
        //V remove(Object key)
        //Xóa 1 Entry trong Map. Lưu ý rằng Map không cho phép 2 entry cùng key!!!
        //[remove success ? V : null]
        System.out.println(ob1.remove("kaguya")); //32122 vì xóa thành công
        System.out.println(ob1.remove("nobita")); //null vì xóa không thành công
        
        //boolean remove(Object key, V value)
        //Xóa 1 Entry trong Map. Lưu ý rằng Map không cho phép 2 entry cùng key!!!
        //[remove success ? true : false]
        System.out.println(ob1.remove("boruto", 8412)); //true
        System.out.println(ob1.remove("nobita", -1)); //false
        
        //remove many entries
        Iterator<Map.Entry<String, Integer>> it = ob1.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() < 20000) {
                it.remove();
            }
        }
        
        //void putAll(Map<? extends K, ? extends V> m)
        //put một Map khác vào Map hiện tại
        Map<String, Integer> ob2 = new HashMap<>();
        ob2.put("Momoshiki", 25000);
        ob2.put("Naruto", 35000);
        ob2.put("Mitsuki", 21000);
        
        ob1.putAll(ob2);
        //duyệt ob2 
        ob1.forEach((k,v) -> System.out.println(k));
        /*
            Momoshiki
            Naruto
            Mitsuki
            ada
        */
        
        //void clear()
        //xóa toàn bộ entry trong một Map
        ob1.clear();
        //duyệt ob2 
        ob1.forEach((k,v) -> System.out.println(k));
        /*
            rỗng!
        */
        
        //V put(K key, V value)
        //Thêm một entry mới vào Map nếu key chưa tồn tại, nếu tồn tại key đó rồi 
        //thì trả về giá trị tương ứng của key mà không thay đổi value
        //[put success ? null : V]
        //put thành công
        System.out.println(ob1.put("ada", 1)); //null
        //put trùng 
        System.out.println(ob1.put("ada", 3)); //1
        
    }
    
}