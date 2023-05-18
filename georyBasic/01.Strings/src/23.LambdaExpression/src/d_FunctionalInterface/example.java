package d_FunctionalInterface;

// Một functional interface
interface MyNumber {
	double getValue();
}


public class example {
	public static void main(String[] args) {
		MyNumber myNum; //Khởi tạo một tham chiếu giao diện
		
		
		//Ở đây, biểu thức lambda đơn giản chỉ là một biểu thức hằng số. 
		//Khi nó được gán cho myNum, một thể hiện của lớp được tạo ra trong đó 
		//biểu thức lambda thực hiện phương thức getValue() trong MyNumber.
		myNum = ()-> 123.45;
		
		
		System.out.println(myNum.getValue()); //123.45
		
		//Ở đây, một biểu thức phức tạp hơn được sử dụng.
		myNum = ()-> Math.random() * 100;
		
		//Những lời gọi này thực thi biểu thức lambda ở dòng trước đó.
		System.out.println("A random value: "+myNum.getValue());
		System.out.println("Another random value: "+myNum.getValue());
		
		
		//Một biểu thức lambda phải tương thích với phương thức được định nghĩa bởi giao diện hàm. 
		//Do đó, điều này sẽ không hoạt động.
		
//		myNum = ()-> "123.45"; Lỗi
		
		/*
		 * Như đã đề cập, biểu thức lambda phải tương thích với phương thức 
		 * trừu tượng mà nó được dùng để thực hiện. Vì lí do này, dòng đã 
		 * được ghi chú ở cuối chương trình là không hợp lệ vì giá trị kiểu 
		 * String không tương thích với kiểu double, đó là kiểu trả về yêu
		 * cầu bởi getValue().*/
		
		
		
		
		// Ví dụ tiếp theo cho thấy việc sử dụng một tham số với biểu thức lambda:
		//example2.java
	}
}
