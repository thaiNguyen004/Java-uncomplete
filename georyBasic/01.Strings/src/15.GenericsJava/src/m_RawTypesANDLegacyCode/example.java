package m_RawTypesANDLegacyCode;

class Gen<T> {
	T ob;
	
	Gen(T o) {
		ob = o;
	}
	
	T getob() {
		return ob;
	}
}

public class example {
	public static void main(String[] args) {
		//Tạo ra một đối tượng generic với kiểu Integer
		Gen<Integer> iOb = new Gen<Integer>(88);
		
		//Tạo ra một đối tượng generic với kiểu String
		Gen<String> sOb = new Gen<String>("Hello World");
		
		//Tạo ra một đối tượng generic raw-type và truyền vào một kiểu dữ liệu bất kỳ
		Gen raw = new Gen(Double.valueOf(98.6));
		//Khi truyền kiểu raw thì giá trị trong phương thức trả về sẽ là Object 
		//nên muốn lấy giá trị thì phải ép kiểu
		double d = (Double)raw.getob(); //ép kiểu là cần thiết
		System.out.println(d);
		
		// int i = (Integer) raw.getob(); run-time error!!!
		
		sOb = raw; //Vì cùng là object nên không báo lỗi
		// String str =  sOb.getob(); run-time error!!!
		
		raw = iOb; // Vẫn gán được bình thường
		double a = (Double) raw.getob(); 
		System.out.println(a);
		
/*
• Chương trình này chứa một số điều thú vị. Đầu tiên, một raw type của lớp generic Gen 
được tạo ra bằng khai báo sau đây:
	Gen raw = new Gen(Double.valueOf(98.6));
• Chú ý rằng không có đối số kiểu được chỉ định. Cơ bản, điều này tạo ra một đối 
tượng Gen với kiểu T được thay thế bằng Object.
Raw type không an toàn về kiểu. Do đó, một biến có kiểu raw type có thể được 
gán một tham chiếu đến bất kỳ loại đối tượng Gen nào. Ngược lại cũng được phép; 
một biến có kiểu Gen cụ thể có thể được gán một tham chiếu đến một đối tượng Gen raw. 
Tuy nhiên, cả hai hoạt động này đều có tiềm năng không an toàn vì cơ chế kiểm tra 
kiểu của generics bị né tránh.
*/
		
/*
• Sự thiếu an toàn về kiểu được minh họa bằng những dòng được chú thích ở cuối 
chương trình. Hãy xem xét từng trường hợp. Đầu tiên, hãy xem xét tình huống sau đây:
	// int i = (Integer) raw.getob(); // lỗi thời gian chạy
• Trong câu lệnh này, giá trị của ob bên trong raw được lấy ra, và giá trị này được 
ép kiểu thành Integer. Sự cố là raw chứa một giá trị Double, không phải là giá trị integer. 
Tuy nhiên, điều này không thể được phát hiện trong quá trình biên dịch vì kiểu 
của raw là không xác định. Do đó, câu lệnh này gây lỗi thời gian chạy.

• Dòng tiếp theo gán một tham chiếu tới một đối tượng Gen raw cho strOb 
(một tham chiếu có kiểu Gen<String>).
	sOb = raw;
	String str =  sOb.getob(); run-time error!!!
• Phép gán này, từ cú pháp, là đúng, nhưng đáng ngờ. Vì sOb có kiểu Gen<String>, 
ta giả định rằng nó chứa một chuỗi (String). Tuy nhiên, sau phép gán, đối tượng 
được tham chiếu bởi sOb chứa một giá trị Double. Do đó, trong quá trình chạy, 
khi cố gắng gán nội dung của sOb cho str, sẽ gây ra lỗi thời gian chạy vì sOb 
hiện chứa một giá trị Double. Do đó, việc gán một tham chiếu raw cho một tham 
chiếu generic bỏ qua cơ chế an toàn kiểu.

• Dãy tiếp theo đảo ngược trường hợp trước đó:
	raw = iOb; 
	double a = (Double) raw.getob(); 
• Ở đây, một tham chiếu generic được gán cho một biến tham chiếu raw. 
Mặc dù điều này cú pháp là chính xác, nhưng nó có thể gây ra các vấn đề, 
như được minh họa trong dòng thứ hai. Trong trường hợp này, raw giờ đây 
trỏ đến một đối tượng chứa một đối tượng Integer, nhưng việc ép kiểu giả định 
rằng nó chứa một Double. Lỗi này không thể được ngăn chặn trong quá trình biên dịch. 
Thay vào đó, nó gây ra một lỗi thời gian chạy.
 
• Vì tiềm năng nguy hiểm inherent trong raw types, javac hiển thị cảnh báo 
unchecked (không được kiểm tra) khi một raw type được sử dụng một cách có thể 
đe dọa tính an toàn kiểu. Trong chương trình trước đó, những dòng này tạo ra cảnh báo 
unchecked:
	Gen raw = new Gen(Double.valueOf(98.6));
	strOb = raw; // OK, nhưng có thể sai

• Trong dòng đầu tiên, là cuộc gọi đến constructor Gen mà không có đối số 
kiểu làm cho cảnh báo xuất hiện. Trong dòng thứ hai, việc gán một tham chiếu raw 
cho một biến generic tạo ra cảnh báo.

• Ở đầu tiên, bạn có thể nghĩ rằng dòng này cũng nên tạo ra một cảnh báo unchecked, 
nhưng thực tế không phải như vậy:
	raw = iOb; // OK, nhưng có thể sai
• Không có cảnh báo từ trình biên dịch được phát ra vì việc gán không gây mất mát 
thêm về tính an toàn kiểu so với đã xảy ra khi raw được tạo ra.

• Một điểm cuối cùng: Bạn nên giới hạn việc sử dụng raw types chỉ trong những 
trường hợp bạn phải kết hợp mã cũ với mã generic mới hơn. Raw types chỉ là một 
tính năng chuyển tiếp và không nên được sử dụng cho mã mới.
*/
	}
	
}
