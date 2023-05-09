/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
• Giao diện SortedSet mở rộng giao diện Set và xác định hành vi của một tập hợp được sắp xếp theo thứ tự tăng dần. 
SortedSet là một giao diện generic có khai báo như sau:
    interface SortedSet<E>
• Ở đây, E chỉ định kiểu của các đối tượng mà tập hợp sẽ chứa.
Ngoài các phương thức được cung cấp bởi Set, giao diện SortedSet khai báo các phương thức được tóm tắt trong Bảng 19-3.
    ▪ NoSuchElementException khi tập hợp không chứa bất kỳ phần tử nào. 
    ▪ Một ClassCastException được ném ra khi một đối tượng không tương thích với các phần tử trong tập hợp. 
    ▪ Một NullPointerException được ném ra nếu có sự cố khi sử dụng một đối tượng null và null không được phép trong tập hợp. 
    ▪ Một IllegalArgumentException được ném ra nếu một đối số không hợp lệ được sử dụng.

Giao diện SortedSet khai báo một số phương thức riêng so với giao diện Set. Dưới đây là danh sách và mô tả các phương thức đó:

1. Comparator<? super E> comparator():
Trả về Comparator được sử dụng để sắp xếp các phần tử trong SortedSet.
Nếu SortedSet được tạo mà không chỉ định Comparator, phương thức này sẽ trả về null.

2. E first():
Trả về phần tử đầu tiên (phần tử nhỏ nhất) trong SortedSet.
Ném ra NoSuchElementException nếu SortedSet không chứa bất kỳ phần tử nào.

3. SortedSet<E> headSet(E toElement):
Trả về một SortedSet chứa tất cả các phần tử nhỏ hơn toElement.

4. E last():
Trả về phần tử cuối cùng (phần tử lớn nhất) trong SortedSet.
Ném ra NoSuchElementException nếu SortedSet không chứa bất kỳ phần tử nào.

5. SortedSet<E> subSet(E fromElement, E toElement):
Trả về một SortedSet chứa tất cả các phần tử nằm giữa fromElement (bao gồm) và toElement (không bao gồm).

6. SortedSet<E> tailSet(E fromElement):
Trả về một SortedSet chứa tất cả các phần tử lớn hơn hoặc bằng fromElement.

*/
public class d_SortedSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Comparator<? super E> comparator():
        //Không chỉ định phương thức comparator
        SortedSet<Integer> ss = new TreeSet<>();
        ss.add(4);
        ss.add(2);
        ss.add(1);
        ss.add(3);
        System.out.println(ss.comparator());  //null


        //Có chỉ định phương thức comparator
        SortedSet<Integer> ss1 = new TreeSet<>(Comparator.reverseOrder());
        System.out.println(ss1.comparator()); //java.util.Collections$ReverseComparator@404b9385
        
        //Có thể sử dụng comparator của SortedSet ss1 để gán cho một Comparator : 
        Comparator compss1 = ss1.comparator();

        
        //2. E first() và E last() 
        SortedSet<Integer> ss2 = new TreeSet<>();
        ss2.add(4);
        ss2.add(1);
        ss2.add(2);
        ss2.add(3);
        System.out.println(ss2.first()); //1
        System.out.println(ss2.last());  //4
        
        
        //SortedSet<E> subSet(E fromElement, E toElement) immutable 
        SortedSet<Integer> originalSet = new TreeSet<>();
        originalSet.add(4);
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);
        
        SortedSet<Integer> subSet = new TreeSet<>();
        subSet = originalSet.subSet(0, 3);
        //subSet sẽ bao gồm các phần tử của originalSet có giá trị từ fromElement (bao gồm) đến toElement(không bao gồm)
        System.out.println(originalSet); //[1, 2, 3, 4]
        System.out.println(subSet);      //[1, 2]
        
//        subSet.add(10); lỗi!!
        originalSet.add(0);
        System.out.println("Sau khi original thêm phần tử");
        System.out.println(originalSet); //[1, 2, 3, 4]
        System.out.println(subSet);      //[1, 2]
        /*
            Sau khi original thêm phần tử
            [0, 1, 2, 3, 4]
            [0, 1, 2]
        */
        
        //6. SortedSet<E> tailSet(E fromElement): Trả về một SortedSet chứa tất cả các phần tử lớn hơn hoặc bằng fromElement.
        SortedSet<Integer> originalSet1 = new TreeSet<>();
        originalSet1.add(0);
        originalSet1.add(1);
        originalSet1.add(2);
        originalSet1.add(3);
        
        SortedSet<Integer> tailSet = originalSet1.tailSet(2);
        System.out.println(tailSet); //[2, 3]
        
        
        //3. SortedSet<E> headSet(E toElement): Trả về một SortedSet chứa tất cả các phần tử nhỏ hơn toElement.
        SortedSet<Integer> originalSet2 = new TreeSet<>();
        originalSet2.add(0);
        originalSet2.add(1);
        originalSet2.add(2);
        originalSet2.add(3);
        
        SortedSet<Integer> headSet = originalSet2.headSet(3);
        System.out.println(headSet); //[0, 1, 2]
    }
    
}
