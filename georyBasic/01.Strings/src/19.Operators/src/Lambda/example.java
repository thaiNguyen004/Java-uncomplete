/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * version >= Java SE 8
 * @author nguye
 */
public class example {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );
        //Ví dụ kiểu 1 a -> a + 1
        List<Integer> listNew = list.stream().map(a -> a + 1).
                collect(Collectors.toList());
        listNew.forEach(System.out::println);
        
        //Ví dụ kiểu 2 a -> {return a + 1; }
        List<Integer> listNew2 = list.stream().map(a -> {return a + 1;}).
                collect(Collectors.toList());
        listNew2.forEach(System.out::println);
    }
    
}
