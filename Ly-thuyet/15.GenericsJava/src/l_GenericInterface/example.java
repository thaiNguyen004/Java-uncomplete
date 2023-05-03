/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package l_GenericInterface;

//Giao diện chung - generic cho interface

interface MinMax <T extends Comparable<T>> {
    T max();
    T min();
}

class MyClass <T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    public MyClass(T[] o) {
        vals = o;
    }
    
    @Override
    public T max() {
        T max = vals[0];
        for (int i = 1 ; i < vals.length; i++){
            if(max.compareTo(vals[i]) < 0){
                 max = vals[i];
            }
        }
        return max;
    }

    @Override
    public T min() {
        T min = vals[0];
        for (int i = 1; i < vals.length; i++){
            if(min.compareTo(vals[i]) > 0) {
                min = vals[i];
            }
        }
        return min;
    }
    
}

public class example {
/*Mặc dù hầu hết các khía cạnh của chương trình này nên dễ hiểu, nhưng cần làm rõ một số điểm quan trọng. 
Trước tiên, lưu ý rằng MinMax được khai báo như sau:
```
interface MinMax<T extends Comparable<T>> {
```
Nói chung, một giao diện chung được khai báo cách giống như một lớp chung. 
Trong trường hợp này, tham số kiểu là T và ranh giới trên của nó là Comparable. 
Như đã giải thích trước đó, Comparable là một giao diện được định nghĩa bởi java.lang 
mô tả cách so sánh các đối tượng. Tham số kiểu của nó chỉ định kiểu của các đối tượng được so sánh.
    
Tiếp theo, MinMax được triển khai bởi MyClass. Lưu ý khai báo của MyClass như sau:
```
class MyClass<T extends Comparable<T>> implements MinMax<T> {
```
Chú ý đặc biệt đến cách tham số kiểu T được khai báo bởi MyClass và sau đó được truyền cho MinMax. 
Vì MinMax yêu cầu một kiểu dữ liệu thực hiện Comparable, lớp triển khai (trong trường hợp này là MyClass) 
phải chỉ định giới hạn tương tự. Hơn nữa, một khi giới hạn này đã được thiết lập, 
không cần phải chỉ định lại trong mệnh đề implements. 
Trong thực tế, điều này sẽ làm sai và không biên dịch được. 
Ví dụ, dòng mã sau đây là không chính xác và sẽ không biên dịch được :
    
    class MyClass <T extends Comparable<T>> implements MinMax<T extends Comparable<T>> Lỗi
    
Sau khi tham số kiểu được xác định, nó chỉ được chuyển đến giao diện mà không cần sửa đổi nữa.
Nói chung, nếu một lớp triển khai một giao diện tổng quát, thì lớp đó cũng phải có tổng quát, 
ít nhất là đối với phần nào đó như một tham số kiểu được chuyển đến giao diện. 
Ví dụ, nếu ta khai báo MyClass như sau thì sẽ bị lỗi:
    class MyClass implements MinMax<T> { // Sai!
Bởi vì MyClass không khai báo một tham số kiểu, không có cách nào để chuyển một tham số kiểu 
tới MinMax. Trong trường hợp này, định danh T là không biết, và trình biên dịch báo cáo lỗi.
Tuy nhiên, nếu một lớp triển khai một kiểu cụ thể của giao diện tổng quát, 
như được thể hiện ở đây:

class MyClass implements MinMax<Integer> { // OK
    
Đây là cú pháp tổng quát cho một giao diện generic:
interface interface-name<type-param-list> { //...

Ở đây, type-param-list là một danh sách các tham số kiểu được phân tách bằng dấu phẩy. 
Khi triển khai một giao diện generic, bạn phải chỉ định các đối số kiểu, như được thể hiện ở đây:
    
class class-name<type-param-list> implements interface-name<type-arg-list> { //...
*/
    public static void main(String[] args) {
        Integer inums[] = {1, 2, 3, 4, 5};
        MyClass<Integer> iob = new MyClass<Integer>(inums);
        
        Character chs[] = {'a', 'd', 'f', 'g'};
        MyClass<Character> cob = new MyClass<Character>(chs);
        
        System.out.println("Max value is inums: "+iob.max());
        System.out.println("Min value is inums: "+iob.min());
        
        System.out.println("Max value is chs: "+cob.max());
        System.out.println("Min value is chs: "+cob.min());
    }
    
}
