/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package NestedTryStatements;

/**
 *
 * @author nguye
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int a = 1;
            /* If no command-line args are present. 
                the following statement will generate 
                a divide-by-zero exception*/
            int b = 42 / a;
            System.out.println("a = " + a);

            try { //Nested try block
                /* If one command-line arg is used, 
                    then a divide-by-zero exception
                    will be generated by the following code. */
                if (a == 1) {
                    a = a / (a - a); //divide by zero
                }
                /* If two command-line args are used, 
                    then generated an out-bounds exception */
                if (a == 2) {
                    int c[] = {1};
                    c[42] = 99; // out-of-bounds exception
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index of bounds: " + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
        /* Như bạn có thể thấy, chương trình này lồng một khối try trong một khối try khác.
        Chương trình hoạt động như sau. Khi bạn thực thi chương trình mà không có đối số dòng lệnh, 
        một ngoại lệ chia cho không được tạo ra bởi khối try bên ngoài. Thực thi chương trình với 
        một đối số dòng lệnh tạo ra một ngoại lệ chia cho không từ trong khối try lồng. Vì khối lồng 
        bên trong không bắt ngoại lệ này, nó được truyền vào khối try bên ngoài, nơi nó được xử lý. 
        Nếu bạn thực thi chương trình với hai đối số dòng lệnh, một ngoại lệ giới hạn mảng được tạo ra
        từ bên trong khối try lồng*/

 /* Việc lồng các câu lệnh try có thể xảy ra một cách ít rõ ràng hơn khi liên quan đến các
        cuộc gọi phương thức. Ví dụ, bạn có thể bao bọc một cuộc gọi phương thức bên trong một khối try.
        Bên trong phương thức đó lại có một câu lệnh try khác. Trong trường hợp này, câu lệnh try bên 
        trong phương thức vẫn được lồng bên trong khối try bên ngoài, gọi phương thức. Đây là chương 
        trình trước đó được viết lại để câu lệnh try lồng vào trong phương thức nesttry(): */
        try {
            int a = 1;
            /* If no command-line args are present. 
                the following statement will generate 
                a divide-by-zero exception*/
            int b = 42 / a;
            System.out.println("a = " + a);

            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
    }

    public static void nesttry(int a) {
        try { //Nested try block
            /* If one command-line arg is used, 
                    then a divide-by-zero exception
                    will be generated by the following code. */
            if (a == 1) {
                a = a / (a - a); //divide by zero
            }
            /* If two command-line args are used, 
                    then generated an out-bounds exception */
            if (a == 2) {
                int c[] = {1};
                c[42] = 99; // out-of-bounds exception
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index of bounds: " + e);
        }
    }
}
