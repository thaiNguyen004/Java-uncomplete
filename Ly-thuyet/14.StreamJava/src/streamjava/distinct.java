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

/**
 *
 * @author nguye
 */
public class distinct {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,1,5);
        
        //Lọc các phần tử trùng lặp.
        List<Integer> list_distinct = list.stream()
                                                   .distinct()
                                                   .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("DISTINCT");
        list_distinct.forEach(e -> System.out.println(e));
    }
    
}
