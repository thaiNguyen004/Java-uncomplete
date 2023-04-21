/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package sets;

import java.util.LinkedHashSet;


/**
 * nếu cần giữ tính khách biệt và thứ tự của các phần tử, 
 * LinkedHashSet là sự lựa chọn tốt hơn so với TreeSet.
 * 
 * Hiệu suất tốt hơn so với HashSet
 */
public class JavaLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet linkedHash = new LinkedHashSet();
        linkedHash.add(1);
        linkedHash.add(3);
        linkedHash.add(3);
        linkedHash.add(2);
        linkedHash.add(8);
        linkedHash.add(5);
        System.out.println(linkedHash.toString());
    }
}
