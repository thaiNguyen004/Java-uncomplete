/**
 * Nguyễn Thái Nguyên
 *
 * Set trong Java có 3 dạng
 * 1.TreeSet
 * 2.HashSet
 * 3.LinkedHashSet
 */
package sets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * Hãy trân trọng code của mình
 * Comparator.reverseOrder 
 * addAll(collection)
 * first(): Trả về phần tử đầu trong TreeSet
 * last(): Trả về phần tử cuối trong TreeSet
 * ceiling(element): Trả về giá trị đầu tiên lớn hơn hoặc bằng phần tử được chỉ định
 * floor(element): Trả về giá trị cao nhất nhỏ hơn hoặc bằng phần tử được chỉ định
 * higher(element): Trả về giá trị đầu tiên lớn hơn phần tử được chỉ định
 * lower(element): Trả về giá trị cao hơn nhỏ hơn phần tử được chỉ định
 * 
 * Đây là các phương thức riêng của TreeSet,
 * các phương thức cơ bản không ghi ở đây
 */
public class JavaTreeSet {
    public static void main(String[] args) {
      //Khai báo TreeSet - mặc định TreeSet sẽ sắp xếp tăng dần
        Set<String> treeSet = new TreeSet();
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("B");
        treeSet.add("W");
        System.out.println(treeSet.toString());
        //[A, B, E, W]
        
        //Khai báo TreeSet nhưng setup sắp xếp giảm dần <=> reverseOrder()
        //reverseOrder - Đảo ngược lại set tăng dần -> giảm dần 
        Set<String> treeSet2 = new TreeSet<>(Comparator.reverseOrder());
        treeSet2.addAll(treeSet);
        System.out.println(treeSet2.toString());
        //[W, E, B, A]
        
        
        //first, last
        /*Lưu ý là nếu tạo đối tượng Set trỏ tới TreeSet thì vẫn là Set thường nên không sử
        dụng được các phương thức riêng của TreeSet*/
        
        ArrayList arr = new ArrayList();
        arr.add(4);
        arr.add(3);
        arr.add(5);
        
        TreeSet tset = new TreeSet(Comparator.reverseOrder());
        tset.addAll(arr);
        System.out.println(tset.first()); //lấy giá trị đầu Treeset 
        System.out.println(tset.last());  //lấy giá trị cuối Treeset 
        
        
        
        TreeSet treeS = new TreeSet();
        treeS.add(5);
        treeS.add(3);
        treeS.add(4);
        
        Iterator<Integer> it = treeS.iterator();
        System.out.println("Duyệt qua iterator");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        //ceiling
        System.out.println("Giá trị >= 1 gần nhất là: "+treeS.ceiling(1));
        // => Trả về giá trị bằng hoặc lớn hơn gần nhất
        
        //floor
        System.out.println("Giá trị <= 5 gần nhất là: "+treeS.floor(5));
        // => Trả về giá trị bằng hoặc nhỏ hơn gần nhất
        
        //higher và lower giống hệt ceiling và floor nhưng méo có dấu =
        //higher
        System.out.println("Giá trị > 3 gần nhất là: "+treeS.higher(3));
        //lower
        System.out.println("Giá trị < 5 gần nhất là: "+treeS.lower(5));
        
    }
}
