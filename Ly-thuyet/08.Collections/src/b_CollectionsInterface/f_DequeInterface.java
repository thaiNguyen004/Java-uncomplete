/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
• Giao diện Queue mở rộng từ Collection và xác định hành vi của một hàng đợi, 
thường là một danh sách theo nguyên tắc "first-in, first-out". Tuy nhiên, có các
loại hàng đợi mà thứ tự được xác định dựa trên tiêu chí khác. Queue là một giao 
diện generic với khai báo sau:
    interface Queue<E>

• Các phương thức :
1. addFirst(E element): Thêm một phần tử vào đầu Deque.

2. addLast(E element): Thêm một phần tử vào cuối Deque.

3. descendingIterator() Trả về một Iterator duyệt ngược qua các phần tử của Deque. 
Điều này hữu ích khi bạn muốn lặp qua các phần tử của Deque từ cuối đến đầu 
mà không thay đổi cấu trúc ban đầu của Deque. 
Lưu ý rằng phương thức descendingIterator() chỉ có sẵn trong Deque, không có sẵn trong Queue hoặc List.

4. getFirst(): Trả về phần tử đầu tiên của Deque (không xóa phần tử này).

5. getLast(): Trả về phần tử cuối cùng của Deque (không xóa phần tử này).

6. offerFirst(E element): Thêm một phần tử vào đầu Deque (trả về true nếu thành công).

7. offerLast(E element): Thêm một phần tử vào cuối Deque (trả về true nếu thành công).

8. peekFirst(): Trả về phần tử đầu tiên của Deque (trả về null nếu Deque rỗng).

9. peekLast(): Trả về phần tử cuối cùng của Deque (trả về null nếu Deque rỗng).

10. pollFirst(): Xóa và trả về phần tử đầu tiên của Deque (trả về null nếu Deque rỗng).

11. pollLast(): Xóa và trả về phần tử cuối cùng của Deque (trả về null nếu Deque rỗng).

12. pop(): Loại bỏ và trả về phần tử đầu tiên (phần tử ở đầu) của Deque. 
Nó tương đương với việc sử dụng phương thức removeFirst().

13. push(E element): Đẩy một phần tử vào đầu Deque. Phương thức này tương đương với 
addFirst(E element) và thường được sử dụng để thêm phần tử vào đầu Deque.

14. removeFirst(): Xóa và trả về phần tử đầu tiên của Deque. Nếu Deque rỗng, 
nó sẽ ném ra ngoại lệ NoSuchElementException.

15. removeFirstOccurrence(Object element): Xóa lần xuất hiện đầu tiên của phần tử cụ 
thể khỏi Deque. Nếu không tìm thấy phần tử, không có thay đổi nào được thực hiện.

16. removeLast(): Xóa và trả về phần tử cuối cùng của Deque. Nếu Deque rỗng, nó 
sẽ ném ra ngoại lệ NoSuchElementException.

17. removeLastOccurrence(Object element): Xóa lần xuất hiện cuối cùng của phần tử cụ thể 
khỏi Deque. Nếu không tìm thấy phần tử, không có thay đổi nào được thực hiện.
*/  
public class f_DequeInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//1. addFirst(E element): Thêm một phần tử vào đầu Deque.
    	Deque<String> dq1 = new ArrayDeque<>();
    	dq1.addFirst("World");
    	dq1.addFirst("Hello");
    	System.out.println(dq1); // [Hello, World]
    	
    	
    	
    	//2. addLast(E element): Thêm một phần tử vào cuối Deque
    	Deque<String> dq2 = new ArrayDeque<>();
    	dq2.add("Nguyên");
    	dq2.addFirst("Thái");
    	dq2.addLast("Hello");
    	dq2.addLast("World");
    	dq2.add("!");
    	System.out.println(dq2); //[Thái, Nguyên, Hello, World, !]
    	
    	
    	
    	//3. descendingIterator() Trả về một Iterator duyệt ngược qua các phần tử của Deque
    	Deque<String> descendingDQ = new ArrayDeque<>();
    	descendingDQ.add("One");
    	descendingDQ.add("Two");
    	descendingDQ.add("Three");
    	descendingDQ.add("Four");
    	descendingDQ.add("Five");
    	
    	System.out.println("Lặp bình thường");
    	Iterator<String> it = descendingDQ.iterator();
    	while(it.hasNext()) {
    		System.out.print(it.next() + " ");
    	}
    	
    	//Iterator đảo ngược 
    	System.out.println("\nLặp bằng descending Iterator");
    	Iterator<String> descendingIt = descendingDQ.descendingIterator();
    	while(descendingIt.hasNext()) {
    		System.out.print(descendingIt.next() + " ");
    	}
    	System.out.println();
    	
    	
    	
    	//45. getFirst and getLast : Trả về phần tử đầu và cuối của Deque (Không xóa)
    	Deque<String> dq3 = new ArrayDeque<>();
    	dq3.add("Nguyên");
    	dq3.addLast("Học CNTT");
    	dq3.add("Trường FPT");
    	dq3.addFirst("Thái");
    	System.out.println(dq3); //[Thái, Nguyên, Học CNTT, Trường FPT]
    	//Lấy ra phần tử đầu
    	System.out.println("Phần tử đầu: "+dq3.getFirst());
    	System.out.println("Phần tử cuối: "+dq3.getLast());
    	
    	//6. offerFirst(E element): Thêm một phần tử vào đầu Deque (trả về true nếu thành công).
    	System.out.println(dq3.offer("Nguyên")); //true
    	System.out.println(dq3.offerLast("Học CNTT")); //true
    	System.out.println(dq3.offer("Trường FPT")); //true
    	System.out.println(dq3.offerFirst("Thái")); //true
    	
    	
    	//8. peekFirst(): Trả về phần tử đầu tiên của Deque (trả về null nếu Deque rỗng). (Không xóa)
    	System.out.println(dq3.peekFirst()); // Thái
    	
    	
    	//10. pollFirst(): Xóa và trả về phần tử đầu tiên của Deque (trả về null nếu Deque rỗng) (Xóa)
    	//Ban đầu phần tử cuối của dq3 = "Trường FPT"
    	//Đầu tiên sẽ lấy ra phần tử cuối và xóa đi bằng pollLast
    	System.out.println(dq3.pollLast()); // Trường FPT
    	
    	//Thử lấy phần tử cuối xem có còn là "Trường FPT" không
    	System.out.println(dq3.getLast()); //Học CNTT
    
    	
    	
    	//12. pop(): Loại bỏ và trả về phần tử đầu tiên (phần tử ở đầu) của Deque
    	Deque<String> dq4 = new ArrayDeque<>();
    	dq4.add("Nguyên");
    	dq4.addLast("Học CNTT");
    	dq4.add("Trường FPT");
    	dq4.addFirst("Thái");
    	System.out.println(dq4.pop()); //Thái
    	
    	
    	//13. push(E element): Đẩy một phần tử vào đầu Deque. Phương thức này tương đương với 
    	//addFirst(E element) và thường được sử dụng để thêm phần tử vào đầu Deque.
    	dq4.push("Xuất sắc");
    	System.out.println(dq4); //[Xuất sắc, Nguyên, Học CNTT, Trường FPT]
    	
    	
    	//removeFirst và removeLast: Xóa và trả về phần tử tương ứng, nếu rỗng tả trả về ngoại
    	//lệ NoSuchElementException
    	//mặc định remove sẽ xóa phần tử đầu
    	Deque<Integer> dq5 = new ArrayDeque<>();
    	dq5.push(1);
    	dq5.push(2); 
    	
    	//ban đầu [2,1]
    	
    	try {
    		dq5.remove();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Deque rỗng không thể xóa");
		}
    	
    	System.out.println(dq5);
    	//sau [1]
    	
    	
    	//15. removeFirstOccurrence(Object element): Xóa lần xuất hiện đầu tiên của phần tử cụ 
    	//thể khỏi Deque. Nếu không tìm thấy phần tử, không có thay đổi nào được thực hiện.
    	Deque<String> dq6 = new ArrayDeque<>();
    	dq6.offer("One");
    	dq6.offer("Two");
    	dq6.offer("Three");
    	dq6.offer("Four");
    	dq6.offer("Five");
    	System.out.println(dq6.removeFirstOccurrence("Two")); //Xóa phần tử Two
    	System.out.println(dq6); // [One, Three, Four, Five]
    	
    	System.out.println(dq6.removeLastOccurrence("Four")); //Xóa phần tử Four
    	System.out.println(dq6); // [One, Three, Five]
    	
    }
    
}
