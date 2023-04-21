/**
 * Nguyễn Thái Nguyên
 *
 * LIFO last in first out
 */


package stack;
import java.util.Stack;
public class StackJava {
    public static void main(String[] args) {
         Stack<String> stack = new Stack<>();
         //add và addElement
         //add: thêm phần tử vào cuối hàng đợi
         stack.add("Chó đen");
         stack.add("Chó xám");
         stack.add("Mèo đen");
         
         //push : thêm phần tử vào cuối hàng đợi
         stack.push("Chó trắng");
         
         //peek: trả về giá trị cuối bản ghi nhưng không xóa
         for(String s : stack){
             System.out.println(stack.peek()+" ");
         }
         //vì không xóa nên nó sẽ lặp n lần phần tử cuối là "Chó trắng"
         
         //pop : trả về giá trị cuối bản ghi và xóa
         System.out.println(stack.pop());
         System.out.println(stack.toString());
         
         //empty
         System.out.println(stack.empty()); //false
         
         //search trả về vị trí bắt đầu từ cuối
         System.out.println("Có phần tử `Chó đen` không? "+stack.search("Chó đen"));
    }
    
}
