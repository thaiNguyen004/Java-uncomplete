/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package BitwiseAndLogical;

/**
 * Toán tử bitwase ~ đảo ngược tất cả các bit trong một giá trị số nguyên hoặc long
 * Toán tử (XOR) ^ sẽ trả về true khi một trong hai trả về true, trả về false nếu cả hai trả về true hoặc false
 * Toán tử & AND cả hai trả về true => true, cả hai trả về fasle hoặc một trong hai trả về false => false
 * Toán tử | OR một trong hai trả về true hoặc cả hai trả về true => true, ngược lại cả hai trả về false => false
 * @author nguye
 */
public class example {
    
    public static void main(String[] args) {
        //Ví dụ về toán tử ~ (bitwase)
        int a = 5;  // 0000 0101 (5)
        int b = ~a; // 1111 1010 (-6)
        
        //Ví dụ về toán tử ^(XOR)
        int c = 5; // 0101
        int d = 3; // 0011
        int e = c ^ d; // 0 1 1 0
        // 0 với 0 = 0
        // 1 với 0 = 1
        // 0 với 1 = 1
        // 1 với 1 = 0
        
        //Ví dụ về toán tử & (AND)
        int s1 = 5; // 0101
        int s2 = 3; // 0011
        int s3 = s1 & s2; // => s3 0 0 0 1
        
        //Ví dụ về toán tử | (OR)
        int c1 = 5; // 0101
        int c2 = 3; // 0011
        int c3 = c1 | c2; // => c3 0 1 1 1
    }
    
}
