/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ZeroInstanceEnum;

/**
 *
 * @author nguye
 */
public class example {
    public enum util{
        /*no instances */ ;
        public static void display(){
            System.out.println("Hello world");
        }
    }
    public static void main(String[] args) {
        util.display();
    }
}
