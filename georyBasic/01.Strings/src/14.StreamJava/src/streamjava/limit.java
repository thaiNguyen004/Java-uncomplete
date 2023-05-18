/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package streamjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class limit {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> listLimit = list.stream().limit(2)
                                                .filter(v -> v % 2 == 0)
                                                .collect(Collectors.toList());
        listLimit.forEach(System.out::println);
    }
    
}
