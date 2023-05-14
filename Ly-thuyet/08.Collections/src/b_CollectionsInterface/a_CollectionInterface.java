/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/*
• Giao diện Collection là nền tảng mà Collections Framework được xây dựng, vì nó phải được triển khai 
bởi bất kỳ lớp nào định nghĩa một collection. Collection là một giao diện generic với khai báo như sau:
    interface Collection<E>
• Ở đây, E chỉ định kiểu đối tượng mà collection sẽ chứa. Collection mở rộng giao diện Iterable. 
Điều này có nghĩa rằng tất cả các collection có thể được lặp qua bằng cách sử dụng vòng lặp for-each. 
(Hãy nhớ rằng chỉ các lớp triển khai Iterable mới có thể được lặp qua bằng vòng lặp for.)

• Giao diện Collection khai báo các phương thức cốt lõi mà tất cả các collection sẽ có. 
Các phương thức này được tóm tắt trong Bảng 19-1. Bởi vì tất cả các collection đều triển khai Collection, 
việc quen thuộc với các phương thức này là cần thiết để hiểu rõ về framework. 
    ▪ Một UnsupportedOperationException. Như đã giải thích, điều này xảy ra nếu một collection không thể được thay đổi. 
    ▪ Một ClassCastException được tạo ra khi một đối tượng không tương thích với một đối tượng khác, chẳng hạn như 
        khi cố gắng thêm một đối tượng không tương thích vào một collection. 
    ▪ Một NullPointerException được ném ra nếu cố gắng lưu trữ một đối tượng null và các phần tử null không được phép trong collection. 
    ▪ Một IllegalArgumentException được ném ra nếu sử dụng một đối số không hợp lệ. 
    ▪ Một IllegalStateException được ném ra nếu cố gắng thêm một phần tử vào một collection có độ dài cố định và đã đầy.
----------------
Dưới đây là danh sách các phương thức cốt lõi được khai báo trong giao diện Collection:
    
1. int size(): Trả về số lượng phần tử trong collection.
2. boolean isEmpty(): Kiểm tra xem collection có rỗng hay không.
3. boolean contains(Object o): Kiểm tra xem collection có chứa phần tử được chỉ định hay không.
4. boolean containsAll(Collection<?> c): Kiểm tra xem collection có chứa tất cả các phần tử trong collection được chỉ định hay không.
5. Iterator<E> iterator(): Trả về một Iterator để lặp qua các phần tử trong collection.
6. Object[] toArray(): Chuyển đổi collection thành một mảng chứa các phần tử của nó.
7. <T> T[] toArray(T[] a): Chuyển đổi collection thành một mảng chứa các phần tử của nó, sử dụng kiểu dữ liệu được chỉ định.
8. boolean add(E e): Thêm một phần tử vào collection.
9. boolean remove(Object o): Xóa một phần tử khỏi collection.
10. boolean addAll(Collection<? extends E> c): Thêm tất cả các phần tử trong collection được chỉ định vào collection hiện tại.
11. boolean removeAll(Collection<?> c): Xóa tất cả các phần tử trong collection được chỉ định khỏi collection hiện tại.
12. boolean retainAll(Collection<?> c): Chỉ giữ lại các phần tử trong collection hiện tại mà cũng có trong collection được chỉ định.
13. void clear(): Xóa tất cả các phần tử khỏi collection.
14. boolean equals(Object o): Kiểm tra xem collection có bằng với đối tượng được chỉ định hay không.
15. int hashCode(): Trả về mã băm của collection.
16. default Stream<E> stream(): Trả về một luồng tuần tự của các phần tử trong collection.
17. default Stream<E> parallelStream(): Trả về một luồng song song của các phần tử trong collection (từ JDK 8).
18. boolean removeIf(Predicate<? super E> filter): Phương thức này xóa tất cả các phần tử trong collection thỏa mãn một 
điều kiện xác định bởi đối tượng Predicate. Nếu có bất kỳ phần tử nào bị xóa, phương thức trả về true, ngược lại trả về false.
19. default void forEach(Consumer<? super E> action): Thực hiện một hành động đã cho trên từng phần tử trong danh sách.
20. Spliterator<E> spliterator(): Phương thức này trả về một Spliterator cho collection. 
Spliterator là một iterator mạnh mẽ hơn có khả năng hỗ trợ việc tách thành nhiều phần để thực hiện lặp đồng thời. 
Spliterator có thể được sử dụng để phân tách một collection thành các phần tử con để xử lý song song.

• Phương thức stream() và parallelStream() là hai phương thức trong interface Collection của Java, cho phép xử lý 
các phần tử trong một Collection một cách thuận tiện và linh hoạt.

▪ stream(): Phương thức stream() tạo ra một Stream (luồng) của các phần tử trong Collection. Stream cho phép chúng ta 
thực hiện các phép biến đổi và thao tác trên dữ liệu một cách dễ dàng và linh hoạt. Các phương thức của Stream như 
filter(), map(), reduce(),... giúp thực hiện các thao tác như lọc, ánh xạ, tích luỹ dữ liệu một cách tiện lợi. 
Với Stream, ta có thể áp dụng chuỗi các phép biến đổi và lọc dữ liệu một cách dễ đọc và hiệu quả.

▪ parallelStream(): Phương thức parallelStream() tương tự như stream(), nhưng tạo ra một Parallel Stream (luồng song song) 
thay vì một Stream thông thường. Parallel Stream cho phép xử lý các phần tử trong Collection một cách song song, sử dụng 
nhiều luồng đồng thời. Điều này giúp tận dụng được tài nguyên máy tính đa lõi và tăng tốc độ xử lý đối với các tập dữ liệu lớn. 
Parallel Stream tự động chia tách dữ liệu thành các phần nhỏ và xử lý đồng thời trên các luồng riêng biệt, sau đó kết hợp kết quả lại.

• Lựa chọn sử dụng stream() hay parallelStream() phụ thuộc vào bài toán cụ thể và tập dữ liệu. 
    ▪ Nếu bạn cần thực hiện các thao tác tuần tự và dữ liệu không quá lớn, stream() là lựa chọn phù hợp. 
    ▪ Trong khi đó, nếu bạn có tập dữ liệu lớn và muốn tận dụng hiệu năng xử lý song song của máy tính đa lõi, 
        parallelStream() có thể cung cấp hiệu quả cao hơn. Tuy nhiên, khi sử dụng parallelStream(), cần lưu ý rằng các phép 
        biến đổi và thao tác phải là an toàn với việc thực hiện song song và không tương tác không an toàn với tài nguyên chia sẻ

    ▪ Lưu ý rằng một số phương thức có thể không được triển khai trong tất cả các lớp collection và có thể ném ra 
    ngoại lệ UnsupportedOperationException nếu không được hỗ trợ.
*/

public class a_CollectionInterface {

    public static void main(String[] args) {
        
        //10. boolean addAll(Collection<? extends E> c)
        List<String> list = new LinkedList<>(List.of("Nguyên", "Vinh", "Dũng"));
        Collection<String> col = new ArrayList<>();
        System.out.println(col.addAll(list)); //true
        //[addAll success : true ? false]
        //Xuất
        col.forEach(e -> System.out.print(e+ " "));
        /*
            Nguyên Vinh Dũng 
        */
        
        
        //4. boolean containsAll(Collection<?> c)
        List<String> list2 = new ArrayList<>(List.of("Nguyên", "Vinh", "Dũng"));
        //khởi tạo Collection vì Collection là interface nên phải sử dụng các lớp triển khai Collection
        Collection<String> col1 = new LinkedList<>();
        col1.addAll(list2);
        //[containAll : true ? false]
        System.out.println(col1.containsAll(list2)); //true
        
        //6. Object[] toArray()
        Object[] containCol1 = col1.toArray();
        for(Object ob : containCol1) {
            System.out.print(ob+ " ");
        }
        System.out.println();
        //Xuất mảng containCol1
        /*
            Nguyên Vinh Dũng
        */
        
        
        //7. <T> T[] toArray(T[] a)
        //Phương thức trên trả về một đối tượng cụ thể thay vì đối tượng Object, và để làm được điều này phải ép kiểu
        //Cách 1 Sử dụng phương thức toArray(T[] a) và truyền vào một mảng rỗng có kiểu String[] để trả về kết quả:
        String containCol1TypeStr[] = col1.toArray(new String[0]);
        //trong trường hợp này mảng được truyền vào có kích thước là 0 không đủ để chứa các phần tử của Collection 
        //tuy nhiên phương thức sẽ tự động tạo ra một mảng đủ để chứa các phần tử
        //Xuất cách 1 : 
        for (String str : containCol1TypeStr) {
            System.out.print(str + " "); //Nguyên Vinh Dũng 
        }
        System.out.println();
        
        //Cách 2 Sử dụng phương thức toArray(IntFunction<T[]> generator) và truyền vào một lambda expression để tạo một mảng String[]:
        String containCol1TypeStr1[] = col1.toArray(String[]::new);
        //Xuất cách 2 : 
        for (String str : containCol1TypeStr1) {
            System.out.print(str + " "); //Nguyên Vinh Dũng 
        }
        System.out.println();
        
        //16. default Stream<E> stream(): Trả về một luồng tuần tự của các phần tử trong collection.
        Collection<String> col2 = new ArrayList<>(List.of("Nguyên", "Người eo", "Bạn bè"));
        col2.stream().forEach(str -> System.out.println(str+ " "));
        System.out.println();
        
        //17. default Stream<E> parallelStream(): Trả về một luồng song song của các phần tử trong collection (từ JDK 8).
        Collection<String> col3 = new ArrayList(List.of("Người yêu", "Bạn bè", "Ba mẹ"));
        col3.parallelStream().forEach(str -> System.out.println(str+" "));
        System.out.println();
        
        //18. boolean removeIf(Predicate<? super E> filter)
        Collection<String> col4 = new ArrayList<>(List.of("Hoa", "Cây", "Quả", "Quần"));
        col4.removeIf(str -> str.indexOf("Q") == 0);
        col4.parallelStream().forEach(e -> System.out.println(e));
        System.out.println();
        /*
        Cây
        Hoa
        */
        
        //19. Spliterator<E> spliterator()
        Collection<Double> col5 = new ArrayList<>(List.of(1551.11, 141.11));
        Spliterator<Double> spliterator = col5.spliterator();
        spliterator.forEachRemaining(e -> System.out.println(e));
        
        
    }
    
}
