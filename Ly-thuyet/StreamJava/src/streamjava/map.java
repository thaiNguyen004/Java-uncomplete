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

public class map {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //Nhiệm vụ: ánh xạ các phần tử trong list thành các phần tử mới là bình 
        //phương của các phần tử cũ
        List<Integer> map_list = list.stream()
                                            .map(v -> v * v)
                                            .collect(Collectors.toList());
        map_list.forEach(System.out::println);
    }
    
}
