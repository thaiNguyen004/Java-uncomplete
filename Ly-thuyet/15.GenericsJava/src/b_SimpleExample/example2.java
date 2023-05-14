/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_SimpleExample;
//Generic Types Differ Based on Their Type Arguments

class Gens<T> {
    T ob;
    Gens (T o){
        ob = o;
    }
    T getOb(){
        return ob;
    }
    void getType(){
        System.out.println("Type : "+ob.getClass().getName());
    }
}
public class example2 {
    public static void main(String[] args) {
        Gens<Integer> iOb1 = new Gens<Integer>(15);
        Gens<Integer> iOb2 = new Gens<Integer>(12);
        Gens<String> strOb = new Gens<String>("Hello world");
        
        
        /*Một điểm chính cần hiểu về kiểu generic là một tham chiếu của một phiên bản cụ thể 
        của kiểu generic không tương thích kiểu với một phiên bản khác của cùng kiểu generic. 
        Ví dụ, giả sử chương trình vừa được hiển thị, 
        dòng mã sau đây là kết quả:
            iOb1 = strOb; lỗi!
            iOb1 = iOb2;
        Mặc dù cả iOb và strOb đều là kiểu Gen<T>, tuy nhiên chúng là các tham chiếu đến các kiểu khác nhau do đối số kiểu của chúng khác nhau. Điều này là một phần của cách mà generic thêm tính an toàn kiểu và ngăn chặn các lỗi.
        */
        
        
    }
    
}
