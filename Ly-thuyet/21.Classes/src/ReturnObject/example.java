/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ReturnObject;

/**
 * Một phương thức có thể trả về bất kỳ loại dữ liệu nào, kể cả các loại lớp mà bạn tạo.
 * @author nguye
 */
class Test {
    int a;
    Test (int i){
        this.a = i;
    }
    public Test incrByTen(){
        Test temp = new Test(a+10);
        return temp;
    }
}
public class example {
    public static void main(String[] args) {
        Test a = new Test(10);
        Test b = a.incrByTen();
        System.out.println(b.a); //20
    }
    
}
