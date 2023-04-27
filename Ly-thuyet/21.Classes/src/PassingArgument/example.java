/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package PassingArgument;

class Test {
    static void meth (int i, int j){
        i *= 2;
        j /= 2;
    }
}

class Test2 {
    int a, b;
    Test2 (int i, int j){
        a = i;
        b = j;
    }
    void meth (Test2 o){
        o.a *= 2;
        o.b /= 2;
    }
}
public class example {
    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        System.out.println("a và b trước khi gọi: "+a + " " + b);
        
        Test.meth(a, b);
        System.out.println("a và b sau khi gọi: "+a +" "+ b);
                
        /* Khi bạn chuyển đối tượng vào một phương thức, tình hình thay đổi một cách đáng kể,
        vì đối tượng được chuyển theo cách gọi là tham chiếu (call-by-reference).  */
        
        Test2 o = new Test2(a, b);
        System.out.println("a và b trước khi gọi: "+o.a + " " + o.b);
        //Lấy đối tượng làm tham số sẽ là chuyền tham chiếu
        o.meth(o);
        System.out.println("a và b sau khi gọi: "+o.a +" "+ o.b);
        
        
    }
    
}
