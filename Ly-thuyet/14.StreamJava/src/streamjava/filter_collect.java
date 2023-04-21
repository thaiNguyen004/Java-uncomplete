/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package streamjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class filter_collect {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(6,7,3,2,6,9,1));
        //Sử dụng stream.filter để lọc các số chẵn và dùng forEach để duyệt qua từng số đó để in
        list.stream()
                .filter((v) -> v % 2 == 0)
                .forEach(System.out::println);
        
        //Sử dụng stream.filter để lọc các số chẵn và dùng colect để tập hợp dữ liệu lại
        int[] sochan = new int[1000];
        List<Integer> list_soChan = list.stream()
                                                .filter(v -> v % 2 == 0)
                                                .collect(Collectors.toList());
        //Collectors có các phương thức như toList, toSet, toMap
        //Có thể ghi cụ thể ra là toList,... hoặc toColections
        
        //Ví dụ về sử dụng toCollections
        //LinkedList::new là tạo ra một đối tượng thuộc collection thay vì ghi là toList
        List<Integer> listBigerThan5 = list.stream()
                                                    .filter(v -> v >= 5)
                                                    .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Các số lớn >= 5");
        listBigerThan5.forEach(System.out::println);
    }
}
