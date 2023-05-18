/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package streamjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nguye
 */
public class flatMap {
    public static void main(String[] args) {
        //Giới thiệu về List chứa List 
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );
        list.forEach(e -> System.out.println(e));
        
        //Hiện tại List đang chứa nhiều List ta có thể sử dụng flatMap để làm phẳng
        //Và kết hợp stream này thành một stream duy nhất
        
        List<Integer> list_flat = list.stream()
                                                .flatMap(List::stream)
                                                .collect(Collectors.toList());
        
        list_flat.forEach(e -> System.out.println(e));
        
        List<List<Integer>> list2 = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4)
        );
        List<Integer> list3 = list2.stream()
                                            .flatMap(List::stream)
                                            .collect(Collectors.toList());
    }
    
}
