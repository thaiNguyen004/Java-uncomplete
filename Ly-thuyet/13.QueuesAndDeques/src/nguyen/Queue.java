/**
 * Nguyễn Thái Nguyên
 *
 * - Queue có cấu trúc FIFO First in First out
 * - Trong java có 2 loại cơ bản là PriorityQueue và LinkedList
 * Queue methods
 * 1. add(element) thêm phần tử vào cuối hàng đợi, nếu ko được => Exception
 * 2. offer(element) thêm phần tử vào cuối hàng đợi, nếu ko được => false
 * 3. remove() loại bỏ phần tử ở đầu , nếu không truy xuất được => Exception
 * 4. poll() truy xuất phần tử đầu hàng đợi và xóa đi, nếu rỗng => null
 * 5. element() truy xuất phần tử đầu hàng đợi mà không xóa, nếu rỗng => Exception
 * 6. peek() truy xuất phần tử đầu hàng đợi mà không xóa, nếu rỗng => null
 */
package nguyen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //add
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        //offer thêm phần tử vào cuối hàng đợi
        queue.offer(6);
        
        
        //remove() loại bỏ phần tử ở đầu
        queue.remove();
        
        //peek truy xuất phần tử và không xóa
        //khi sử dụng size để xử lý sửa xóa một hàng đợi thường sẽ lỗi
//        int length = queue.size();
//        for(int i = 0; i < length; i++){
//            int number = queue.peek();
//            queue.remove();
//            System.out.println(number);
//        }
        
        
        //poll truy xuất phần tử và xóa
        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            System.out.println(queue.poll());
        }
        
        //element() gần giống poll nhưng nếu null thì trả về Exception còn poll => null
        System.out.println(queue.element());
        //output: Exception
        
        
        //LinkedList
        LinkedList<Integer> dslk = new LinkedList<>();
        //add
        dslk.add(1);
        dslk.add(2);
        dslk.add(3);
        dslk.add(4);
        dslk.add(5);
        //offer
        dslk.offer(6);
        
        //add(int index, <T> value) thêm một phần tử vào linkedlist ở vị trí chỉ định
        dslk.add(1, 5);
        //1 5 2 3 4 5 6 
        
        //remove phần tử ở đầu, giống trong queue
        dslk.remove();
        
        //poll truy xuất phần tử và xóa 
        Iterator<Integer> it2 = dslk.iterator();
        while(it2.hasNext()){
            System.out.println(dslk.poll());
        }
        
        //element truy xuất phần tử nhưng không xóa
        LinkedList<Integer> dslk2 = new LinkedList<>();
        dslk2.add(1);
        dslk2.add(2);
        dslk2.add(3);
        dslk2.add(4);
        dslk2.add(5);
        
        //element tương tự poll
        
        
        //peek truy xuất phần tử nhưng xóa
        Iterator<Integer> it3 = dslk2.iterator();
        while(it3.hasNext()){
            System.out.println(dslk2.peek());
            it3.next();
            it3.remove();
            
        }
        
    }
    
}
