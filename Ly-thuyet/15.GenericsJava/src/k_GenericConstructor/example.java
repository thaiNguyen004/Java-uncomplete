/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package k_GenericConstructor;

import java.math.BigDecimal;
/*Generic Constructor
Vì GenCons() chỉ định một tham số của một kiểu chung, mà phải là một lớp con của Number, 
GenCons() có thể được gọi với bất kỳ kiểu số nào, bao gồm Integer, Float hoặc Double,
thậm chí là BigDecimal. Do đó, mặc dù GenCons không phải là một lớp chung, 
constructor của nó là chung.*/
class GenCons {
    double val;
    <T extends Number> GenCons (T arg){
        val = arg.doubleValue();
    }
    void showVal () {
        System.out.println("Value: "+val);
    }
}
public class example {

    public static void main(String[] args) {
        GenCons test = new GenCons(new BigDecimal(525));
        test.showVal();
        
        GenCons test2 = new GenCons(50);
        test2.showVal();
    }
    
}
