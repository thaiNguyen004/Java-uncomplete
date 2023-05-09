/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_CollectionsInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/*
• Giao diện List mở rộng từ Collection và định nghĩa hành vi của một tập hợp lưu trữ một chuỗi các phần tử. 
Các phần tử có thể được chèn hoặc truy cập thông qua vị trí của chúng trong danh sách, sử dụng chỉ số bắt đầu từ 0. 
Một danh sách có thể chứa các phần tử trùng lặp. List là một giao diện generic (thuộc tính đại diện) có khai báo như sau:
    interface List<E>
Ở đây, E chỉ định loại đối tượng mà danh sách sẽ lưu trữ.
Ngoài các phương thức được định nghĩa bởi Collection, List cũng định nghĩa một số phương thức riêng của nó, 
được tóm tắt trong Bảng 19-2. Lưu ý rằng một số phương thức này sẽ ném ngoại lệ 
    ▪ UnsupportedOperationException nếu danh sách không thể được sửa đổi. 
    ▪ ClassCastException khi một đối tượng không tương thích với một đối tượng khác, ví dụ như khi cố gắng thêm một 
        đối tượng không tương thích vào danh sách. 
    ▪ IndexOutOfBoundsException nếu sử dụng chỉ số không hợp lệ. 
    ▪ NullPointerException được ném nếu cố gắng lưu trữ một đối tượng null và List không cho phép các phần tử null. 
    ▪ IllegalArgumentException được ném nếu sử dụng một đối số không hợp lệ.

1. void add(int index, E element): Thêm phần tử vào vị trí đã cho trong danh sách.
2. boolean addAll(int index, Collection<? extends E> c): Thêm tất cả các phần tử trong một collection vào danh sách, 
bắt đầu từ vị trí đã cho.
3. E get(int index): Trả về phần tử tại vị trí đã cho trong danh sách.
4. E set(int index, E element): Thay thế phần tử tại vị trí đã cho trong danh sách bằng phần tử đã cho.
5. E remove(int index): Xóa phần tử tại vị trí đã cho trong danh sách và trả về phần tử đã xóa.
6. int indexOf(Object o): Trả về chỉ số đầu tiên của phần tử đã cho trong danh sách, hoặc -1 nếu không tìm thấy.
7. int lastIndexOf(Object o): Trả về chỉ số cuối cùng của phần tử đã cho trong danh sách, hoặc -1 nếu không tìm thấy.
8. ListIterator<E> listIterator(): Trả về một ListIterator để lặp qua các phần tử trong danh sách.
9. ListIterator<E> listIterator(int index): Trả về một ListIterator để lặp qua các phần tử trong danh sách, bắt đầu từ vị trí đã cho.
10. List<E> subList(int fromIndex, int toIndex): Trả về một danh sách con chứa các phần tử từ vị trí 
từ Index đến toIndex-1 trong danh sách.
11. default void replaceAll(UnaryOperator<E> operator): Thay thế tất cả các phần tử trong danh sách bằng kết quả của 
việc áp dụng một toán tử một ngôi lên từng phần tử.
12. default void sort(Comparator<? super E> c): Sắp xếp danh sách bằng một Comparator đã cho.
13. static <E> List<E> of( ): Trả về một List chứa các phần tử được tạo trong đối số của of

• Đây chỉ là một số phương thức quan trọng trong giao diện List. Ngoài ra, giao diện List còn thừa kế các phương thức 
từ giao diện Collection và Iterable.
• Đối với tất cả các phiên bản, không cho phép có phần tử null. Trong tất cả các trường hợp, việc thực hiện giao diện 
List không được xác định cụ thể.

• Bắt đầu từ JDK 9, List bao gồm phương thức factory of(), có một số phiên bản khác nhau. Mỗi phiên bản trả về một 
bộ sưu tập không thể sửa đổi và dựa trên giá trị, bao gồm các đối số được truyền vào. 
• Mục đích chính của of() là cung cấp một cách tiện lợi, hiệu quả để tạo ra một bộ sưu tập List nhỏ. 
Có 12 phiên bản của of(). Một phiên bản không có đối số và tạo ra một danh sách trống. Nó được hiển thị dưới đây.
    static <E> List<E> of( )
• Mười phiên bản này có từ 1 đến 10 đối số và tạo ra một danh sách chứa các phần tử được chỉ định. Chúng được hiển thị dưới đây:
    static <E> List<E> of(E obj1)
    static <E> List<E> of(E obj1, E obj2)
    static <E> List<E> of(E obj1, E obj2, E obj3)
    static <E> List<E> of(E obj1, E obj2, E obj3, E obj4)
    ...
    static <E> List<E> of(E obj1, E obj2, E obj3, E obj4, E obj5, 
                                    E obj6, E obj7, E obj8, E obj9, E obj10)
• Phiên bản cuối cùng của phương thức of() chỉ định một tham số varargs, chấp nhận một số phần tử tùy ý 
hoặc một mảng các phần tử. Nó được hiển thị dưới đây:
    static <E> List<E> of(E ... objs)
• Đối với tất cả các phiên bản, các phần tử null không được cho phép. Trong tất cả các trường hợp, 
việc triển khai của danh sách không được xác định.

*/
public class b_ListInterface {

    public static void main(String[] args) {
        //1. void add(int index, E element), để sử dụng phải đảm bảo rằng danh sách đủ lớn để chứa phần tử thứ index
        List<String> l1 = new ArrayList<>(List.of("zero", "one", "two", "three", "four"));
        System.out.println(l1.get(1)); //one
        l1.add(1, "one new");
        System.out.println(l1.get(1)); //one new
        
        //2. boolean addAll(int index, Collection<? extends E> c)
        List<String> l2 = new ArrayList<>(List.of("Nguyên", "Thái", "Nguyễn"));
        System.out.println(l2.addAll(1, l1)); //true
        //Xuất: 
        l2.stream().forEach(e -> System.out.print(e + " "));
        /*Nguyên zero one new one two three four Thái Nguyễn*/
        
        //4. E set(int index, E element)
        //Danh sách ban đầu của l2 : Nguyên zero one new one two three four Thái Nguyễn
        l2.set(0, "Phần tử mới");
        //Danh sách ban đầu của l2 : Phần tử mới zero one new one two three four Thái Nguyễn
    
        
        //5. E remove(int index)
        List<String> l3 = new ArrayList<>(List.of("F", "P", "T"));
        System.out.println(l3.remove(0)); //F
        //Xuất danh sách: 
        l3.forEach(e -> System.out.print(e+ " "));
        // P T
        
        //6. int indexOf(Object o)
        //Trường hợp tìm thấy
        System.out.println(l3.indexOf("P")); // 0
        
        //Trường hợp không tìm thấy
        System.out.println(l3.indexOf("F")); // -1
        
        
        //7. int lastIndexOf(Object o)
        //Trường hợp tìm thấy
        System.out.println(l3.lastIndexOf("T")); // 1
        
        //Trường hợp không tìm thấy
        System.out.println(l3.lastIndexOf("F")); // -1
        
        
        //8. ListIterator<E> listIterator()
        List<String> l4 = List.of("Java", "Js", "PHP", "HTML", "ReactJs");
        ListIterator<String> lit = l4.listIterator();
        lit.forEachRemaining(System.out::println); System.out.println();
        /*
            Java
            Js
            PHP
            HTML
            ReactJs
        */
        
        
        //9. ListIterator<E> listIterator(int index)
        ListIterator<String> lit2 = l4.listIterator(2);
        lit2.forEachRemaining(System.out::println); System.out.println();
        /*
            PHP
            HTML
            ReactJs
        */
        
        //10. List<E> subList(int fromIndex, int toIndex)
        //Tạo ra một list và nhận vào các phần tử của list khác
        List<String> l5 = l4.subList(0, 3);
        l5.forEach(System.out::println);
        /*
            Java
            Js
            PHP
        */
        
        //11. default void replaceAll(UnaryOperator<E> operator)
        List<Integer> l6 = new ArrayList<>(List.of(5, 10, 100, 120));
        l6.replaceAll((t) -> t < 100 ? t += 100 : t);
        //Duyệt : 
        l6.forEach(e -> System.out.print(e + " ")); System.out.println();
        /*105 110 100 120*/
        
        
        //12. default void sort(Comparator<? super E> c)
        //Danh sách hiện tại của l6 : 105 110 100 120 (chưa sắp xếp)
        
        l6.sort(Comparator.naturalOrder());
        l6.forEach(e -> System.out.print(e + " "));
        /*100 105 110 120 (đã sắp xếp)*/
        
        //static <E> List<E> of(E...objs) đây là dạng varargs của of
        //có thể truyền bao nhiêu phần tử tùy ý
        List<String> list = List.of("a","a","a","a","a","a",
                "a", "a","a","a","a","a","a","a"
                ,"a","a","a","a","a","a","a","a");
//        list.set(0, "h"); lỗi!! - Vì không thay đổi được một List sử dụng phương thức of
     }
    
}
