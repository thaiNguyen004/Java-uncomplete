/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package e_ArraysRevisited;

/* Ví dụ, đây là một phiên bản cải tiến của lớp Stack. Như bạn có thể nhớ, các phiên 
bản trước của lớp này luôn tạo ra một stack chứa mười phần tử. 
Phiên bản sau cho phép bạn tạo các stack có bất kỳ kích thước nào. 
Giá trị của stck.length được sử dụng để ngăn chặn stack bị tràn: */

class Stack {
    private int stack[];
    private int tos;
    Stack(int size){
        stack = new int[size];
        tos = -1;
    }
    void push (int item){
        if(tos >= stack.length - 1){
            System.out.println("Full");
        }else{
            stack[++tos] = item;
        }
    }
    int pop(){
        if(tos < 0){
            System.out.println("Stack underflow");
            return 0;
        }else{
            return stack[tos--];
        }
    }
}
public class example {
    public static void main(String[] args) {
        Stack myStack1 = new Stack(5);
        for(int i = 0 ; i < 5; i++){
            myStack1.push(i);
        }
        for(int i = 0 ; i < 5; i++){
            System.out.println(myStack1.pop());
        }
    }
}
