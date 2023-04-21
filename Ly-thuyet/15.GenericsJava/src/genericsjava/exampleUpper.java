/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package genericsjava;

//Ví dụ về Upper Bounded Parameter
public class exampleUpper <T extends Number> {
    T value;
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
    public static void main(String[] args) {
      //example<String> e = new example<>(); error
        exampleUpper<Integer> e = new exampleUpper<>();
        e.setValue(10);
        System.out.println(e.getValue());
    }
    
}
