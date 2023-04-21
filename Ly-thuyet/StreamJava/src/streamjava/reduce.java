/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package streamjava;

import java.util.Arrays;
import java.util.List;

public class reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int tong = list.stream().reduce(0, (a,b) -> a + b);
        System.out.println(tong);
    }
    
}
