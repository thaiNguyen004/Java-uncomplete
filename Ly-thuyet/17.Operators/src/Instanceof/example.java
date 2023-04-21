/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package Instanceof;

/**
 * object Instanceof class
 * 
 * - Instanceof giúp kiểm tra xem đối tượng có phải là một thể hiện của lớp cụ thể
 * hay là một thể hiện là lớp con của lớp cụ thể hay không 
 * - Giá trị trả về true | false
 * - Lưu ý: 
 *      Instanceof chỉ hoạt động với object không hoạt động với (float, int, ...)
 *      Instanceof không thể kiểm tra một đối tượng có phải là một thể hiện cụ thể của 
 *          một interfacce hay không.
 * @author nguye
 */

class SuperClass {
    public void print(){
        System.out.println("This is SuperClass");
    }
}
class SubClass extends SuperClass{
    
}
interface iSuperClass {
    public void print();
}
class subClass2 implements iSuperClass {

    @Override
    public void print() {
        System.out.println("This is subClass2");
    }
    
}
public class example {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();
        System.out.println(superClass instanceof SubClass);   // false
        System.out.println(subClass instanceof SuperClass);   // true
        System.out.println(superClass instanceof SuperClass); // true 
        
        //Trường hợp inteface
        subClass2 subClass2 = new subClass2();
        System.out.println(subClass2 instanceof iSuperClass); // true
        //Vì subClass2 là một thể hiện của lớp subClass2 mà lớp subClass2 lại triển khai
        //interface iSuperClass nên giá trị trả về là true
    }
    
}
