/**
 * Nguyễn Thái Nguyên
 *
 * Deque Double ended Queue -> có thể truy cập từ hai phía
 * methods: 
 * 1. addFirst() - thêm một phaagn tư
 * 2. addLast()
 * 3. offerFirst()
 * 4. offerLast()
 * 5. removeFirst()
 * 6. removeLast()
 * 7. pollFirst()
 * 8. pollLast()
 * 9. getFirst()
 * 10. getLast()
 * 11. peekFirst()
 * 12. peekLast()
 * -- Deque cung cấp 2 list là linkedList và ArrayDeque
 */
package nguyen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeJava {
    public static void main(String[] args) {
        
        //1. LinkedList
        Deque<String> deque = new LinkedList<>();
        deque.add("Dog");
        deque.add("Cat");
        deque.addFirst("Dragon");
        deque.addLast("Lion");
        deque.add("People");
        deque.offerFirst("Fish");
        //Fish Dragon Dog Cat Lion People
        System.out.println("Trước khi remove");
        for(String x : deque){
            System.out.print(x+" ");
        }
        
        //remove, removeFirst xóa đầu hàng đợi removeLast xóa cuối hàng đợi 
        deque.remove(); 
        System.out.println("\nSau khi remove");
        for(String x : deque){
            System.out.print(x+" ");
        }
        
        Deque<Integer> deque2 = new LinkedBlockingDeque<>(Arrays.asList(1,2,3,4,5));
//        [1, 2, 3, 4, 5]
        //pollLast - pollFirst
        System.out.println(deque2.pollLast()); //out : 5
        System.out.println(deque2.toString()); //out : [1, 2, 3, 4]
        
        //pollFirst 
        System.out.println(deque2.pollFirst()); //out: 1 
        System.out.println(deque2.toString());  // out: [2, 3, 4]
        
        for(int a : deque2){
            System.out.print(deque2.poll()+" "); // 2 3 4 
        }
        System.out.println("Số phần tử còn lại là: "+deque2.size()); // 0
        
        //getLast, getFirst, get
        Deque<Integer> deque3 = new LinkedList<>(Arrays.asList(111,222,333,444,555));
        System.out.println("Phần tử cuối = "+deque3.getLast()); //555
        System.out.println("Phần tử đầu = "+deque3.getFirst()); //111
        
        System.out.println(deque3.toString()); //[111, 222, 333, 444, 555] chứng tỏ method(get) không xóa 
        
        //ArrayDeque
        Deque<Integer> arrayDeque = new ArrayDeque<>(Arrays.asList(1,2,3,4,5));
        //addAll
        arrayDeque.addAll(new ArrayList<>(Arrays.asList(6,7,8)));
        System.out.println(arrayDeque.toString());
        
    }
}
