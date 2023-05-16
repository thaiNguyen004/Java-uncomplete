package r_LocalVariableTypeInferenceAndGeneric;
/*Như đã được giải thích, Type Inference đã được hỗ trợ cho generics 
 * thông qua việc sử dụng toán tử diamond. Tuy nhiên, bạn cũng có thể sử dụng 
 * tính năng Local Variable Type Inference mới được thêm vào bởi JDK 10 
 * với một lớp generic. 

 *  	var mcOb = new MyClass<Integer, String>(42, "Hello");

 * Đây là một ví dụ của Local Variable Type Inference. Thay vì khai báo kiểu 
 * dữ liệu rõ ràng là `MyClass<Integer, String>`, 
 * ta có thể sử dụng từ khóa `var` để cho phép suy luận kiểu. 
 * Trình biên dịch sẽ suy ra kiểu dữ liệu từ biểu thức khởi tạo và xác định 
 * kiểu của `mcOb` là `MyClass<Integer, String>`.
 * 
 * Điều này giúp rút ngắn cú pháp và làm cho mã nguồn dễ đọc hơn trong việc khai 
 * báo các biến với generics.
*/
public class example {
	
}
