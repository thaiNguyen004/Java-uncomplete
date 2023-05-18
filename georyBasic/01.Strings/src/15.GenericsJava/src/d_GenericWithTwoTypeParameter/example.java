/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package d_GenericWithTwoTypeParameter;

/* Bạn có thể khai báo nhiều hơn một tham số kiểu trong một generic type. Để chỉ định hai 
hoặc nhiều hơn các tham số kiểu, chỉ cần sử dụng danh sách được phân tách bằng dấu phẩy. 
Ví dụ, lớp TwoGen sau đây là một biến thể của lớp Gen có hai tham số kiểu: */
class TwoGen<T, V> {
    T ob1;
    V ob2;
    //Truyền vào constructor một tham chiếu tới đối tượng kiểu T, và một tham chiếu
    //tới đối tượng kiểu V
    TwoGen(T o1, V o2){
        ob1 = o1;
        ob2 = o2;
    }
    void showType(){
        System.out.println("Type of T: "+ob1.getClass().getName() + "\n"
                + "Type of V: "+ ob2.getClass().getName());
    }
    T getOb1 () {
        return ob1;
    }
    V getOb2 () {
        return ob2;
    }
}
public class example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(50, "Hello");
        
        tgObj.showType();
        
        int v = tgObj.getOb1();
        System.out.println("value: "+v);
        String str = tgObj.getOb2();
        System.out.println("value: "+str);
        
        /* Chú ý cách khai báo lớp TwoGen như sau:
        class TwoGen<T, V> {
        Nó chỉ định hai tham số kiểu: T và V, được phân tách bằng dấu phẩy. Vì nó
        có hai tham số kiểu, hai đối số kiểu phải được truyền vào TwoGen khi
        một đối tượng được tạo.
        Trong trường hợp này, Integer được thay thế cho T và String được thay thế cho V.    
        Mặc dù hai đối số kiểu khác nhau trong ví dụ này, nhưng có thể cho cả hai kiểu
        cùng là giống nhau. Ví dụ: dòng mã sau là hợp lệ:
        
        TwoGen<String, String> x = new TwoGen<String, String> ("A","B");
        
        Trong trường hợp này, cả T và V sẽ có kiểu String. Tất nhiên, nếu các đối số kiểu
        luôn giống nhau, thì hai tham số kiểu sẽ là không cần thiết.*/
    }
    
}
