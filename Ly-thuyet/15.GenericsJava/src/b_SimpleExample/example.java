/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package b_SimpleExample;

//Một ví dụ đơn giản,
//Ở đây, T là một tham số kiểu và sẽ được thay thế thành một kiểu đối tượng thực sự
//khi đối tượng Gen được khởi tạo 

class Gen<T> {
    T ob; //Khai báo một đối tượng kiểu T

    //Truyền vào hàm tạo một tham chiếu tới đối tượng kiểu T
    Gen(T o){
        ob = o;
    }
    
    //Return ob
    T getOb(){
        return ob;
    }
    
    //Show type of T
    void showType(){
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}
public class example {
    public static void main(String[] args) {
        //Khởi tạo một tham chiếu Gen cho kiểu Integer
        Gen<Integer> iOb;
        //Khởi tạo một đối tượng Gen<Integer> và chỉ định cho tham chiếu iOb
        iOb = new Gen<Integer>(88); // autoboxing
        /*Trong ví dụ được đề cập, giá trị 88 có kiểu dữ liệu cơ bản là int, nhưng nó được 
        đóng gói vào một đối tượng Integer thông qua việc sử dụng autoboxing. 
        Autoboxing là một tính năng của Java cho phép tự động chuyển đổi giữa kiểu dữ liệu cơ bản 
        và đối tượng tương ứng của nó. Vì vậy, khi giá trị 88 được truyền vào constructor 
        của lớp Gen, nó sẽ được đóng gói vào một đối tượng Integer trước khi được 
        lưu trữ trong thuộc tính ob của lớp Gen.*/
        
        //Show kiểu dữ liệu được sử dụng cho iOb
        iOb.showType(); //Type of T is: java.lang.Integer
        
        int v = iOb.getOb();
        System.out.println("value: "+v);
        
        //Tạo một đối tượng Gen cho kiểu Strings
        Gen<String> strOb = new Gen<String> ("Generics Test");
        
        //Show kiểu dữ liệu được sử dụng cho strOb
        strOb.showType();
        
        String str = strOb.getOb();
        System.out.println("value: "+str);
        
        //Mô tả về ví dụ này kĩ hơn ở file Ly-thuyet
        
        //Một tính chất đơn giản nhưng quan trọng 
        /*Generic chỉ hoạt động với các kiểu tham chiếu
        Khi khai báo một thể hiện của một kiểu generic, tham số kiểu được truyền vào phải là một kiểu tham chiếu. 
        Bạn không thể sử dụng một kiểu nguyên thủy, chẳng hạn như int hoặc char. Ví dụ, với Gen, bạn có thể truyền 
        bất kỳ kiểu lớp nào cho T, nhưng bạn không thể truyền một kiểu nguyên thủy cho tham số kiểu. 
        Do đó, khai báo sau là không hợp lệ: Gen<int> intOb = new Gen<int>(53);
        Tất nhiên, không thể chỉ định một kiểu nguyên thủy là một hạn chế nghiêm trọng, 
        bởi vì bạn có thể sử dụng các lớp bao kiểu (như ví dụ trước đã làm) để bao bọc kiểu nguyên thủy. 
        Hơn nữa, cơ chế tự động đóng gói và mở đóng gói của Java làm cho việc sử dụng 
        lớp bao kiểu trở nên minh bạch.
        
        Trong Java, các kiểu dữ liệu nguyên thủy (primitive types) như int, char, double, float, ... 
        không phải là đối tượng, do đó không thể trực tiếp sử dụng chúng trong các đối tượng Generic của Java. 
        Tuy nhiên, Java cung cấp các lớp bao kiểu (wrapper classes) tương ứng, 
        ví dụ như Integer, Character, Double, Float, ... để đóng gói các kiểu 
        dữ liệu nguyên thủy này vào đối tượng.

        Cơ chế tự động đóng gói (autoboxing) và mở đóng gói (autounboxing) của Java cho phép 
        các giá trị của các kiểu dữ liệu nguyên thủy này tự động được đóng gói vào các đối tượng 
        tương ứng và ngược lại. Khi sử dụng các đối tượng Generic của Java, ta có thể sử dụng 
        các lớp bao kiểu này như một tham số để tránh hạn chế của việc sử dụng các kiểu dữ liệu nguyên thủy.

        Nhờ cơ chế tự động đóng gói và mở đóng gói của Java, việc sử dụng lớp bao kiểu trở nên 
        rất minh bạch và dễ dàng, vì các giá trị của các kiểu dữ liệu nguyên thủy 
        được tự động đóng gói và mở đóng gói một cách tự động.
        */
        
        //Generic Types Differ Based on Their Type Arguments => file example2.java
    }
    
}
