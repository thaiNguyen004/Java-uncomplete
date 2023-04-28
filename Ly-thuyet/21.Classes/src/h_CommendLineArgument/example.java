/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package h_CommendLineArgument;


public class example {

    /*
        Đôi khi bạn muốn truyền thông tin vào chương trình khi bạn chạy nó. Điều này
        được thực hiện bằng cách truyền các đối số dòng lệnh cho main(). Một đối số dòng
        lệnh là thông tin ngay sau tên chương trình trên dòng lệnh khi nó được thực thi. 
        Để truy cập các đối số dòng lệnh trong chương trình Java rất dễ dàng - chúng được 
        lưu trữ dưới dạng chuỗi trong một mảng String được truyền vào tham số args của main(). 
        Đối số dòng lệnh đầu tiên được lưu trữ tại args [0], đối số thứ hai tại args [1], và 
        tiếp tục như vậy. Ví dụ, chương trình sau đây hiển thị tất cả các đối số dòng lệnh mà nó được gọi với.
    */
    //
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println("args["+ i + "] : " +args[i]);
        }
    }
    
}
