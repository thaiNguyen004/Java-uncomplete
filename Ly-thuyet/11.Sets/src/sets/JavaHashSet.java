/**
 * Nguyễn Thái Nguyên
 *
 * Set trong Java có 3 dạng
 * 1.TreeSet
 * 2.HashSet
 * 3.LinkedHashSet
 */
package sets;

import java.util.HashSet;
import java.util.Iterator;


/**
 * Hãy trân trọng code của mình
 */
public class JavaHashSet {
    public static void main(String[] args) {
        HashSet<Integer> hashS = new HashSet<>();
        hashS.add(5);
        hashS.add(4);
        hashS.add(3);
        hashS.add(10);
        hashS.add(7);
        
        //clone phương thức này của Object nên ko chỉ hashSet mới dùng được 
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2 = (HashSet)hashS.clone();
        
        
        Iterator it = hashS.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        Iterator it2 = hashSet2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        
        
    }
}
