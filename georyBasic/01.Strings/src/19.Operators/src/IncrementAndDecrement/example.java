/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package IncrementAndDecrement;

/**
 * increment ++
 * decrement -- 
 * @author nguye
 */
public class example {
    static int  a = 10;
    static int b = 10;
    public static void main(String[] args) {
        a++; 
        ++a;
        System.out.println(a); // 12
        
        System.out.println(b--); // 10
        System.out.println(--b); //8
    }
}
