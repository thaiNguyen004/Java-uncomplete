/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package TryCatch;

/**
 *
 * @author nguye
 */
public class TryCatchWithOneCatchBlock {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("two");
        } catch (Exception e) {
            //handle an exception
            System.out.println("An exception occurred:  " + e.getMessage());
        }
    }
    
}
