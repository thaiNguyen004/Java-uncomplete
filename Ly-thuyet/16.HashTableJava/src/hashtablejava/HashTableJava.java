/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package hashtablejava;

import java.util.Hashtable;

/**
 * Trước khi học về HashTable thì phải đọc các ưu và nhược điểm của nó
 * 
 * Ưu điểm: 
 *      - Truy xuất phần tử theo key nhanh O(1), tùy vào hàm băm, có thể nhanh hơn ArrayList, LinkedList
 *      - Xử lý được một số lượng lớn dữ liệu, giúp giảm thiểu tình trạng tràn bộ nhớ
 *      - Khả năng đồng bộ hóa, vì là một lớp đồng bộ hóa nên đảm bảo tính toàn vẹn dữ liệu khi có nhiều luồng 
 *        truy cập vào cùng một HashTable
 * Nhược điểm: 
 *      - Không đảm bảo được thứ tự của các phần tử 
 *      - Không cho phép lưu trữ giá trị null
 *      - Nếu số lượng phần tử quá lớn có thể giảm hiệu xuất (Không ổn định)
 * @author nguye
 */
public class HashTableJava {
    public static void main(String[] args) {
        Hashtable<Integer, String> map = new Hashtable<>();
        map.putIfAbsent(101, "Naruto shippuden");
        map.putIfAbsent(102, "Naruto");
        map.putIfAbsent(103, "Sasuke shippuden");
        map.forEach((k,v) -> System.out.println(k+" "+v));
        //Về cơ bản nó như map tuy nhiên sử dụng thuật toán lưu trữ dữ liệu có sự khác biệt 
    }
    
}
