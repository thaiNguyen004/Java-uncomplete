/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package Shift;

/**
 * >> and << không dịch bit dấu (- và +)
 * >>> có thể dịch được cả bit dấu
 * 
 * <<  toàn bộ các bit sẽ được dịch trái một số lượng xác định, các giá trị bên trái sẽ được điền số 0 
 * >>  toàn bộ các bit sẽ được dịch phải một số lượng xác định, các giá trị bên phải sẽ được điền số 0
 * >>> tương tự nhưng dịch được bit dấu
 * @author nguye
 */
public class example {

    public static void main(String[] args) {
        int a = 8;          // 0000 1000
        int b = a >> 2;     // 0000 0010 => 2
        int c = a << 2;     // 0010 0000 => 32
        
        int a2 = -8;        // 1111 1000
        int b2 = a2 >>> 2;  // 0011 1110 => 30 
        //int c2 = a2 <<< 2;   erorr 
        
    }
    
}
