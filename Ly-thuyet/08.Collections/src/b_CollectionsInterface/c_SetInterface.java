/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
• Giao diện Set định nghĩa một tập hợp. Nó mở rộng giao diện Collection và xác định hành vi của 
một tập hợp không cho phép các phần tử trùng lặp. Do đó, phương thức add() trả về false nếu có nỗ lực 
thêm các phần tử trùng lặp vào một tập hợp. Trừ hai trường hợp, giao diện này không xác định bất kỳ 
phương thức bổ sung nào riêng của nó. Set là một giao diện generic có khai báo như sau:
    interface Set<E>
Ở đây, E chỉ định kiểu của các đối tượng mà tập hợp sẽ chứa.
• Bắt đầu từ JDK 9, Set bao gồm phương thức factory of()
    static <E> Set<E> of( )
Phiên bản cuối cùng của phương thức of() chỉ định một tham số varargs, chấp nhận một số phần tử tùy ý 
hoặc một mảng các phần tử. Nó được hiển thị dưới đây:

    static <E> Set<E> of(E ... objs)

• Đối với tất cả các phiên bản, các phần tử null không được cho phép. Trong tất cả các trường hợp, 
việc triển khai của Set không được xác định.
• Bắt đầu từ JDK 10, Set bao gồm phương thức tĩnh copyOf(), được hiển thị dưới đây:

    static <E> Set<E> copyOf(Collection <? extends E> from)

Nó trả về một tập hợp chứa cùng các phần tử như từ tập hợp đầu vào. Giá trị null không được phép. Tập hợp được trả về không thể sửa đổi.
*/
public class c_SetInterface {

    public static void main(String[] args) {
        //static <E> Set<E> of() truyền một mảng vào 
//        Integer array[] = {1,2,2,4,5}; java.lang.IllegalArgumentException
        Integer array[] = {1,2,3,4,5};
        Set<Integer> set = Set.of(array);
        set.forEach(e -> System.out.println(e));
        
        
        //static <E> Set<E> copyOf(Collection <? extends E> from)
        //phương thức trả về một bản sao không thể thay đổi
        Set<Integer> setOriginal = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> setCopied = Set.copyOf(setOriginal);
        
        //Thay đổi setCopied 
//        setCopied.add(5); lỗi !!!
        
        //Xuất 
        System.out.println("setOriginal: " + setOriginal);
        System.out.println("setCopied: "+ setCopied);
        
    }
    
}
