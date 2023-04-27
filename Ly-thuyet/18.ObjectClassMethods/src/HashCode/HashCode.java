/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package HashCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Phương thức HashCode() trả về một giá trị băm -> Giá trị băm là một số nguyên
 * int được tính toán dựa trên chỉ số của đối tượng -> Thường được sử dụng để
 * tìm kiếm, phân loại, so sánh -> Trường hợp va chạm (collision) : tức là khi 2
 * đối tượng có trùng giá trị băm, để giảm thiểu thì phương thức HashCode() phải
 * được cài đặt từ các thuộc tính của đối tượng và không bị thay đổi trong xuốt
 * quá trình sử dụng đối tượng -> Phương thức hashCode được sử dụng trong các
 * cấu trúc dữ liệu như HashMap, HashSet, HashTable -> Khi sử dụng hashCode ta
 * phải đảm bảo dữ liệu không thay đổi, nếu có thay đổi thì phương thức
 * hashCode() cũng cần cập nhật theo để không gây ra va chạm
 *
 * @param args the command line arguments
 */
class student {

    int id;
    String name;

    student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
//            mặc định khi generate
//            int hash = 7;
//            return hash;
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    //Trong đó prime được tạo ra để tính toán hashCode phức tạp giúp tránh va chạm
}

class exampleHashCodeShortCut {
    int field1, field2, field3;
    //Ví dụ sử dụng hashCode với short cut (Java SE >= 1.2)
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] {field1, field2, field3});
    }
}

class exampleHashCodeShortCut2 {
    int field1, field2, field3;
    //Ví dụ sử dụng hashCode với short cut (Java SE >= 1.7)
    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }
}

public class HashCode {

    public static void main(String[] args) {
        //Sử dụng HashMap để lưu trữ sinh viên 
        //có thể sử dụng các ctdl không liên quan tới băm như ArrayList bình thường.
        //tuy nhiên nên sử dụng các ctdl như HashMap, HashSet, HashTable để dùng HashCode()
        student student1 = new student(1, "Naruto");
        student student2 = new student(2, "Sasuke");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(student1.id, student1.name);
        hashMap.put(student2.id, student2.name);
    }

}
