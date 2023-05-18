/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/*
• Giao diện NavigableSet mở rộng từ SortedSet và xác định hành vi của một tập 
hợp hỗ trợ việc truy xuất các phần tử dựa trên giá trị gần nhất đến một giá trị 
hoặc các giá trị cụ thể. 
• NavigableSet là một giao diện thông qua khai báo sau:
    interface NavigableSet<E>
Ở đây, E chỉ định kiểu đối tượng mà tập hợp sẽ giữ. Ngoài các phương thức mà nó 
kế thừa từ SortedSet, NavigableSet bổ sung các phương thức tóm tắt trong Bảng 19-4

1. E lower(E e): Trả về phần tử lớn nhất trong tập hợp nhỏ hơn phần tử được chỉ định
2. E floor(E e): Trả về phần tử lớn nhất trong tập hợp nhỏ hơn hoặc bằng phần tử được chỉ định
3. E ceiling(E e): Trả về phần tử nhỏ nhất trong tập hợp lớn hơn hoặc bằng phần tử được chỉ định
4. E higher(E e): Trả về phần tử nhỏ nhất trong tập hợp lớn hơn phần tử được chỉ định
5. E pollFirst(): Xóa và trả về phần tử nhỏ nhất trong tập hợp, hoặc trả về null nếu tập hợp trống
6. E pollLast(): Xóa và trả về phần tử lớn nhất trong tập hợp, hoặc trả về null nếu tập hợp trống
7. NavigableSet<E> descendingSet(): Trả về một NavigableSet ngược lại với tập hợp hiện tại
8. Iterator<E> descendingIterator(): Trả về một trình lặp Iterator cho phép lặp 
qua các phần tử trong tập hợp theo thứ tự ngược lại.
9. NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive): 
Trả về một tập hợp con của NavigableSet chứa các phần tử nằm giữa fromElement và toElement, 
với khả năng bao gồm hoặc loại trừ các giá trị tương ứng.
10. NavigableSet<E> headSet(E toElement, boolean inclusive): Trả về một tập hợp con 
của NavigableSet chứa các phần tử nhỏ hơn toElement, với khả năng bao gồm hoặc loại trừ toElement.
11. NavigableSet<E> tailSet(E fromElement, boolean inclusive): Trả về một tập hợp 
con của NavigableSet chứa các phần tử lớn hơn hoặc bằng fromElement, với khả năng 
bao gồm hoặc loại trừ fromElement.
*/
public class e_NavigableSetInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NavigableSet<Integer> demoNavigableSet = 
                new TreeSet<>(Set.of(1, 2, 3, 4, 5));
        
        //1. E lower(E e): Trả về phần tử lớn nhất trong tập hợp nhỏ hơn phần tử được chỉ định
        System.out.println(demoNavigableSet.lower(3)); 
        //trả về 2 vì 2 là phần tử lớn nhất trong tập hợp mà nhỏ hơn 3
        
        
        
        //2. E floor(E e): Trả về phần tử lớn nhất trong tập hợp nhỏ hơn hoặc bằng phần tử được chỉ định
        System.out.println(demoNavigableSet.floor(3));
        //trả về 3 vì 3 là phần tử lớn nhất trong tập hợp mà nhỏ hơn hoặc bằng 3
        
        
        
        //3. E ceiling(E e): Trả về phần tử nhỏ nhất trong tập hợp lớn hơn hoặc bằng phần tử được chỉ định
        System.out.println(demoNavigableSet.ceiling(3));
        //trả về 3 vì 3 là phần tử nhỏ nhất trong tập hợp mà lớn hơn hoặc bằng 3
        
        
        
        //3. E higher(E e): Trả về phần tử nhỏ nhất trong tập hợp lớn hơn phần tử được chỉ định
        System.out.println(demoNavigableSet.higher(3));
        //trả về 4 vì 4 là phần tử nhỏ nhất trong tập hợp mà lớn hơn 3
        
        
        
        //5. E pollFirst(): Xóa và trả về phần tử nhỏ nhất trong tập hợp, hoặc trả về null nếu tập hợp trống
        System.out.println(demoNavigableSet.pollFirst()); 
        //Trả về 1 vì 1 là phần tử nhỏ nhất
        
        
        
        //5. E pollLast(): Xóa và trả về phần tử lớn nhất trong tập hợp, hoặc trả về null nếu tập hợp trống
        System.out.println(demoNavigableSet.pollLast()); 
        //Trả về 5 vì 5 là phần tử lớn nhất
     
        
        
        //7. NavigableSet<E> descendingSet(): Trả về một NavigableSet ngược lại với tập hợp hiện tại
        NavigableSet<Integer> descending = demoNavigableSet.descendingSet();
        //Lúc này các phương thức như higher, ceiling sẽ có tác dụng ngược lại
        System.out.println(descending.higher(3));
        //Bình thường thì phương thức higher sẽ trả về phần tử có giá trị nhỏ nhất và lớn hơn 3 nên trả về 4
        //nhưng đối với descending thì ngược lại, sẽ trả về phần tử có giá trị lớn nhất và nhỏ hơn 3 nên trả về 2
        
        //Các giá trị của descending khi lặp cũng bị đảo ngược
        System.out.print("demoNavigableSet: ");
        demoNavigableSet.forEach(e -> System.out.print(e +" "));
        System.out.println();
        System.out.print("descending: ");
        descending.forEach(e -> System.out.print(e + " "));
        System.out.println();
        
        /*
            demoNavigableSet: 2 3 4 
            descending: 4 3 2 
        */
        
        
        //8. Iterator<E> descendingIterator(): Trả về một trình lặp Iterator cho phép lặp 
        //qua các phần tử trong tập hợp theo thứ tự ngược lại.
        Iterator<Integer> itdescending = demoNavigableSet.descendingIterator();
        System.out.print("descendingIterator: ");
        itdescending.forEachRemaining(e -> System.out.print(e+" "));
        /*
            descendingIterator: 4 3 2
        */
        
        
        //9. NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive): 
        //Trả về một tập hợp con của NavigableSet chứa các phần tử nằm giữa fromElement và toElement, 
        //với khả năng bao gồm hoặc loại trừ các giá trị tương ứng.
        
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        NavigableSet<Integer> originalNav = new TreeSet<>(list);
        
        NavigableSet<Integer> subSet = originalNav.subSet(1, true, 5, false);
        //fromInclusive = true bao gồm phần tử fromElement và ngược lại
        //toInclusive = true bao gồm phần tử toElement và ngược lại
        System.out.println();
        System.out.println(subSet);
        //[1, 2, 3, 4]
        

        
        //10. NavigableSet<E> headSet(E toElement, boolean inclusive): Trả về một tập hợp con 
        //của NavigableSet chứa các phần tử nhỏ hơn toElement, với khả năng bao gồm hoặc loại trừ toElement.
        NavigableSet<Integer> headSet = originalNav.headSet(5, true);
        //[1, 2, 3, 4, 5]
        NavigableSet<Integer> headSet2 = originalNav.headSet(5, false);
        //[1, 2, 3, 4]
        
        
        
        //11. NavigableSet<E> tailSet(E fromElement, boolean inclusive): Trả về một tập hợp 
        //con của NavigableSet chứa các phần tử lớn hơn hoặc bằng fromElement, với khả năng 
        NavigableSet<Integer> tailSet = originalNav.tailSet(2, true);
        //[2, 3, 4, 5]
        NavigableSet<Integer> tailSet2 = originalNav.tailSet(2, false);
        //[3, 4, 5]

        
    }
    
}
