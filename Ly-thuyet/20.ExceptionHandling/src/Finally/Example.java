/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package TryCatch;

/**
 *
 * @author nguye
 */
public class Example {
    /* Khi xảy ra lỗi, thực thi trong một phương thức sẽ đi theo một luồng không
    tuyến tính khá đột ngột và thay đổi luồng bình thường thông qua phương thức đó. 
    Tùy thuộc vào cách mà phương thức được viết, có thể thậm chí là lỗi có thể làm 
    cho phương thức kết thúc sớm. Điều này có thể là một vấn đề trong một số phương thức
    
     Ví dụ, nếu một phương thức mở một tệp khi vào và đóng tệp khi ra, bạn sẽ không
    muốn mã đóng tệp bị bỏ qua bởi cơ chế xử lý ngoại lệ. 
    finally được thiết kế để giải quyết trường hợp này.*/
    
    /* finally tạo ra một khối mã sẽ được thực thi sau khi một khối try / catch đã hoàn thành
    và trước mã sau khối try/catch. Khối finally sẽ được thực thi cho dù có ngoại lệ được
    ném ra hay không. Nếu một ngoại lệ được ném ra, khối finally sẽ được thực thi ngay cả khi 
    không có câu lệnh catch nào phù hợp với ngoại lệ đó. Mỗi khi một phương thức sắp trả về cho
    người gọi từ bên trong một khối try / catch, thông qua 
        ▪ một ngoại lệ không được xử lý hoặc ▪ một câu lệnh return rõ ràng 
    khối finally cũng được thực thi ngay trước khi phương thức trả về. Điều này có thể hữu ích để
    đóng các tệp và giải phóng bất kỳ tài nguyên nào khác mà có thể đã được cấp phát ở đầu phương thức
    với ý định giải phóng chúng trước khi trả về. Khối finally là tùy chọn. 
    Tuy nhiên, mỗi câu lệnh try yêu cầu ít nhất một câu lệnh `catch` hoặc khối `finally`.
    Dưới đây là một chương trình minh họa cho ba phương thức thoát ra ở các cách khác nhau, 
    không có phương thức nào không thực thi khối finally của mình: */
    
    //Throw an exception out of the method
    static void procA (){
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA's finally");
        }
    }
    
    //Return from within a try block
    static void procB (){
        try {
            System.out.println("inside procB");
            return;
        } finally {
            System.out.println("procB's finally");
        }
    }
    
    //Excute a try block normally
    static void procC(){
        try {
            System.out.println("inside procC");
        } finally {
            System.out.println("procC's finally");
        }
    }
    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e){
            System.out.println("Exception caught");
        }
        procB();
        procC();
        
        /* Trong ví dụ này, phương thức `procA()` sẽ dừng sớm khỏi khối `try` bằng cách
        ném ra một ngoại lệ. Khối `finally` được thực thi khi phương thức rời khỏi khối `try`. 
        Phương thức `procB()` kết thúc khối `try` thông qua một câu lệnh `return`. 
        Khối `finally` được thực thi trước khi `procB()` trả về. Trong `procC()`, khối `try` 
        thực thi bình thường, không có lỗi. Tuy nhiên, khối `finally` vẫn được thực thi. */
        
        /*
        Đừng quên rằng nếu một khối finally được liên kết với một try, khối finally sẽ được thực thi
        khi try kết thúc.

        Đây là đầu ra được tạo bởi chương trình trước đó:
            inside procA 
            procA's finally 
            Exception caught 
            inside procB 
            procB's finally 
            inside procC 
            procC's finally
        */
    }
    
}
