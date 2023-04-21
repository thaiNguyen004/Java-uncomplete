/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package streamjava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class sorted {
    public static void main(String[] args) {
        //Sắp xếp tăng dần
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        List<Integer> list2 = list.stream().sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Sắp xếp tăng dần");
        list2.forEach(e -> System.out.print(e+" "));
        
        List<Integer> list3 = list.stream().sorted((o1,o2) -> o2.compareTo(o1))
                .collect(Collectors.toList());
        System.out.println("\nSắp xếp giảm dần");
        list3.forEach(e -> System.out.print(e+" "));
        
        //Cách chuyển kiểu dữ liệu nguyên thủy trong stream sang kiểu dl đối tượng
        System.out.println("\nSắp xếp tăng dần cho một mảng kiểu nguyên thủy");
        int [] a = {5,4,3,2,1};
        IntStream intStream = IntStream.of(a);
        List<Integer> list4 = intStream.boxed().sorted().collect(Collectors.toList());
        
    }
    
}
