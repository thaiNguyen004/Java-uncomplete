package o_Instanceof;
/*
• So sánh kiểu tại thời gian chạy trong một hệ thống lớp generic
Hãy nhớ lại toán tử instanceof được sử dụng để kiểm tra thông tin kiểu tại 
thời gian chạy đã được mô tả trong Chương 13. Như đã giải thích, instanceof 
xác định xem một đối tượng có phải là một thể hiện của một lớp hay không. 
Nó trả về giá trị true nếu đối tượng là kiểu được chỉ định hoặc có thể ép kiểu 
thành kiểu được chỉ định. Toán tử instanceof có thể được áp dụng cho các đối tượng 
của các lớp generic. 
• Lớp sau đây mô tả một số hệ quả về tương thích kiểu của một hệ thống lớp generic:
*/

class Gen <T> {
	T ob;
	
	Gen(T o) {
		ob = o;
	}
	
	T getob() {
		return ob;
	}
}

class Gen2 <T> extends Gen<T> {
	Gen2(T o) {
		super(o);
	}
}


public class Instanceof {
	public static void main(String[] args) {
		//Tạo ra một đối tượng Generic với kiểu Integer
		Gen<Integer> iOb = 
				new Gen<Integer>(99);
		
		//Tạo ra một đối tượng Generic2 với kiểu Integer
		Gen2<Integer> iOb2 = 
				new Gen2<Integer>(100);
		
		//Tạo ra một đối tượng Generic2 với kiểu String
		Gen2<String> strOb2 = 
				new Gen2<String>("Generic test");
		
		//---------------
		
		//Kiểm tra xem iOb2 có phải là một dạng của Generic2 không
		if(iOb2 instanceof Gen2<?>)
			System.out.println("iOb2 is instance of Generic2");
	
		//Kiểm tra iOb2 có phải là một dạng của Generic không
		if(iOb2 instanceof Gen<?>)
			System.out.println("iOb2 is instance of Generic");
		System.out.println();
	
		//Kiểm tra tương ứng với strOb2
		if(strOb2 instanceof Gen2<?>)
			System.out.println("strOb2 is instance of Generic2");
		
		//Kiểm tra tương ứng với strOb2
		if(strOb2 instanceof Gen<?>)
			System.out.println("strOb2 is instance of Generic");
		
	
		
		
		//Kiểm tra xem iOb có phải là một dạng của Generic2 không
		if(iOb instanceof Gen2<?>) 
			System.out.println("iOb is instance of Generic2");
	
		//Kiểm tra xem iOb có phải là một dạng của Generic không
		if(iOb instanceof Gen<?>)
			System.out.println("iOb is instance of Generic");
		
		//Không thể biên dịch mã sau vì thông tin loại chung không tồn tại
		//trong thời gian chạy
		
//		if(iOb2 instanceof Gen2<String>)
//		System.out.println("iOb2 is instance of Generic2<String>");
		
/*
• Trong chương trình này, Gen2 là một lớp con của Gen, có kiểu generic 
trên tham số kiểu T. Trong hàm main(), ba đối tượng được tạo ra. 
	▪ Đầu tiên là iOb, một đối tượng có kiểu Gen<Integer>. 
	▪ Thứ hai là iOb2, một phiên bản của Gen2<Integer>. 
	▪ Cuối cùng, strOb2 là một đối tượng có kiểu Gen2<String>.
Sau đó, chương trình thực hiện các kiểm tra instanceof trên kiểu của iOb2:	
	if(iOb2 instanceof Gen2<?>)
			System.out.println("iOb2 is instance of Gen2");
			
	if(iOb2 instanceof Gen<?>)
			System.out.println("iOb2 is instance of Gen");
			
• Như kết quả hiển thị, cả hai kiểm tra đều thành công. Trong kiểm tra đầu tiên, 
iOb2 được kiểm tra so với Gen2<?>. Kiểm tra này thành công vì nó chỉ xác nhận 
rằng iOb2 là một đối tượng thuộc loại Gen2 nào đó. Việc sử dụng ký tự đại diện 
cho phép instanceof xác định xem iOb2 có phải là một đối tượng thuộc bất kỳ loại Gen2 
nào hay không. Tiếp theo, iOb2 được kiểm tra so với Gen<?>, loại cha. Điều này cũng đúng 
vì iOb2 là một dạng của Gen, loại cha. 
• Một số dòng tiếp theo trong hàm main() hiển thị cùng một chuỗi (và cùng kết quả) cho strOb2.

Tiếp theo, iOb, một phiên bản của Gen<Integer> (lớp cha), được kiểm tra 
bằng các dòng sau đây:

	if(iOb instanceof Gen2<?>) 
			System.out.println("iOb is instance of Gen2");
	
	if(iOb instanceof Gen<?>)
		System.out.println("iOb is instance of Gen");

• Lần kiểm tra đầu tiên không thành công vì iOb không phải là một đối tượng của lớp Gen2. 
• Kiểm tra thứ hai thành công vì iOb là một đối tượng của lớp Gen.
Bây giờ, hãy xem kỹ các dòng được comment như sau:

//		if(iOb2 instanceof Gen2<Integer>)
//			System.out.println("iOb2 is instance of Gen2<Integer>");

Như những comment cho biết, các dòng này không thể được biên dịch 
vì chúng cố gắng so sánh iOb2 với một kiểu cụ thể của Gen2, trong trường hợp này 
là Gen2<String>. Hãy nhớ rằng không có thông tin kiểu generic nào có sẵn tại 
thời điểm chạy. Do đó, không có cách nào để instanceof biết được iOb2 có phải là 
một thể hiện của Gen2<String> hay không.

*/
	}
}
