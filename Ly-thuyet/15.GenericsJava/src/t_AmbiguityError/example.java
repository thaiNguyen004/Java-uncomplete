package t_AmbiguityError;
/*
• Các lỗi không rõ ràng (ambiguity errors)
Việc bao gồm generics dẫn đến một loại lỗi khác mà bạn phải phòng ngừa: sự không rõ ràng. 
• Các lỗi không rõ ràng xảy ra khi sự xóa bỏ (erasure) làm cho hai khai báo generics 
khác nhau có vẻ giống nhau giải quyết thành cùng một kiểu bị xóa (erased type), 
gây ra một xung đột. Dưới đây là một ví dụ liên quan đến việc nạp chồng phương thức 
(method overloading):
*/

//Lỗi không rõ ràng được bắt bởi sự xóa bỏ (erasure)

class MyGenClass <T,V> {
	T ob1;
	V ob2;
	
	//...
	
	//Có 2 phương thức không rõ ràng và sẽ không biên dịch
	
//	void set(T o) {
//		ob1 = o;
//	}
//	void set(V o) {
//		ob2 = o;
//	}
	
/*
 * Lưu ý rằng MyGenClass khai báo hai kiểu generics: T và V. 
 * Bên trong MyGenClass, có một nỗ lực để nạp chồng phương thức set() 
 * dựa trên các tham số kiểu T và V. Điều này có vẻ hợp lý vì T và V 
 * dường như là các kiểu khác nhau. Tuy nhiên, có hai vấn đề không rõ ràng ở đây.
 * 
 * Trước tiên, khi viết MyGenClass, không có yêu cầu rằng T và V thực sự phải là 
 * các kiểu khác nhau. Ví dụ, việc xây dựng một đối tượng MyGenClass như được hiển thị 
 * dưới đây là hoàn toàn đúng (về nguyên tắc):
 * 
 * 		MyGenClass<String, String> obj = new MyGenClass<String, String>();
 * 
 * Trong trường hợp này, cả T và V sẽ được thay thế bằng String. Điều này làm 
 * cho cả hai phiên bản của set() trở nên giống nhau, điều đó tất nhiên là một lỗi.
 * 
 * Vấn đề thứ hai và quan trọng hơn là sự xóa bỏ kiểu của set() giảm cả hai phiên bản thành như sau:
 * 
 * 		void set(Object o) { // ...
 * 
 * Do đó, việc nạp chồng phương thức set() như đã thử trong MyGenClass là mơ hồ từ bản chất.
 * Các lỗi không rõ ràng có thể khá khó để sửa. Ví dụ, nếu bạn biết rằng V sẽ luôn là một 
 * loại Number nào đó, bạn có thể thử sửa lỗi MyGenClass bằng cách viết lại khai báo của nó 
 * như được hiển thị dưới đây:
 * 
 * 		class MyGenClass<T, V extends Number> { // hầu như đúng!
 * 
 * Thay đổi này khiến MyGenClass biên dịch thành công, và bạn thậm chí có thể khởi tạo đối tượng 
 * như trong ví dụ dưới đây:
 * Điều này hoạt động vì Java có thể xác định chính xác phương thức nào được gọi.
 * 
 * Tuy nhiên, sự mơ hồ trở lại khi bạn thử dòng mã sau đây:
 * 
 * 		MyGenClass<Number, Number> x = new MyGenClass<Number, Number>();
 * 
 * Trong trường hợp này, vì cả T và V đều là Number, phải gọi phiên bản set() nào? 
 * Cuộc gọi đến set() bây giờ là mơ hồ.
 * Thành thật mà nói, trong ví dụ trên, tốt hơn nhiều nếu bạn sử dụng hai tên phương thức riêng biệt 
 * thay vì cố gắng nạp chồng set(). Thường thì, giải pháp cho sự không rõ ràng liên quan đến việc 
 * tái cấu trúc mã nguồn, vì sự không rõ ràng thường có nghĩa là bạn có một lỗi khái niệm trong thiết kế của mình.
*/
	
}

class MyGenClass2 <T, V extends Number> {
	T ob1; 
	V ob2;
	
	void set(T o) {
		ob1 = o;
	}

	void set(V o) {
		ob2 = o;
	}
	//Như bạn có thể thấy hoàn toàn biên dịch được
}
public class example {
	public static void main(String[] args) {
		var x = new MyGenClass2<Integer, Integer>();
//		x.set(15); error!!!
		
		//Thử sửa lại
		var x1 = new MyGenClass2<String, Integer>();
		x1.set("Hello World");
		//Hết lỗi
	}
}
