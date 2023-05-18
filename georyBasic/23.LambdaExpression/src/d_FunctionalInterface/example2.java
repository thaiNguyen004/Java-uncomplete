package d_FunctionalInterface;

//Another functional interface
interface NumericTest {
	boolean test(int n);
}

public class example2 {
	public static void main(String[] args) {
		//Một biểu thức lambda kiểm tra một số chẵn
		NumericTest isEven = (n) -> (n%2) == 0;
		
		if(isEven.test(10)) System.out.println("10 is even");
		if(!isEven.test(9)) System.out.println("9 is not even");
		
		//Một biểu thức lambda kiểm tra một số nguyên dương
		//is non-negative
		NumericTest isNonNeg = (n) -> n >= 0;
		
		if(isNonNeg.test(1)) System.out.println("1 không phải số âm");
		if(!isNonNeg.test(-1)) System.out.println("-1 là số âm");

/*
 * • Chương trình này giới thiệu một điểm quan trọng về biểu thức lambda đáng 
 * được xem xét kỹ. Hãy chú ý đặc biệt đến biểu thức lambda thực hiện kiểm tra 
 * tính chẵn lẻ. Nó được trình bày lại ở đây:
 * 		(n) -> (n % 2) == 0
 * • Lưu ý rằng kiểu của n không được chỉ định. Thay vào đó, kiểu của n được suy ra 
 * từ ngữ cảnh. Trong trường hợp này, kiểu của n được suy ra từ kiểu tham số 
 * của phương thức test() như được định nghĩa bởi giao diện NumericTest, kiểu int. 
 * • Cũng có thể chỉ định rõ kiểu của tham số trong một biểu thức lambda. 
 * Ví dụ, cách viết sau đây cũng là cách hợp lệ để viết:
 * 		(int n) -> (n % 2) == 0
 * Ở đây, n được chỉ định rõ là int. 
 * • Thông thường, không cần phải chỉ định rõ kiểu, nhưng bạn có thể làm điều đó 
 * trong những tình huống yêu cầu. Bắt đầu từ JDK 11, bạn cũng có thể sử dụng từ khóa var 
 * để chỉ định rõ kiểu suy ra của biến cục bộ cho tham số biểu thức lambda.
 * 
 * 
 * Chương trình này thể hiện một điểm quan trọng khác về biểu thức lambda: 
 * • Một tham chiếu giao diện chức năng có thể được sử dụng để thực thi bất kỳ 
 * biểu thức lambda nào tương thích với nó. 
 * • Lưu ý rằng chương trình xác định hai biểu thức lambda khác nhau tương thích 
 * với phương thức test() của giao diện chức năng NumericTest. 
 * • Biểu thức lambda đầu tiên, gọi là isEven, xác định xem một giá trị có là chẵn hay không. 
 * • Biểu thức lambda thứ hai, gọi là isNonNeg, kiểm tra xem một giá trị có là không âm 
 * hay không. Trong mỗi trường hợp, giá trị của tham số n được kiểm tra. 
 * Vì mỗi biểu thức lambda tương thích với test(), nên mỗi biểu thức có thể 
 * được thực thi thông qua một tham chiếu NumericTest.
 * • Một điểm khác trước khi tiếp tục. Khi một biểu thức lambda chỉ có một tham số,
 * không cần thiết phải bao quanh tên tham số bằng dấu ngoặc đơn khi nó được chỉ định 
 * ở phía trái của toán tử lambda. Ví dụ, đây cũng là cách viết hợp lệ cho biểu thức 
 * lambda được sử dụng trong chương trình:
 * 
 * 		n -> (n % 2)==0
 * 
 * Chương trình tiếp theo thể hiện một biểu thức lambda mà có hai tham số. 
 * Trong trường hợp này, biểu thức lambda kiểm tra xem một số có phải là ước của số khác 
 * hay không.
 */
		
		
		NumericTest2 isFactor = (n,d) -> (n%d) == 0;
		
		if(isFactor.test(10, 2)) System.out.println("2 là ước của 10");
		
		if(!isFactor.test(10, 3)) System.out.println("3 không phải ước của 10");
	
/*
 * Trong chương trình này, giao diện chức năng NumericTest2 
 * định nghĩa phương thức test():
 * 		boolean test(int n, int d);
 * Trong phiên bản này, test() chỉ định hai tham số. Do đó, để biểu thức lambda 
 * tương thích với test(), biểu thức lambda cũng phải chỉ định hai tham số. 
 * Lưu ý cách chúng được chỉ định:
 * 		(n, d) -> (n % d) == 0
 * Hai tham số, n và d, được chỉ định trong danh sách tham số, 
 * cách nhau bằng dấu phẩy. Ví dụ này có thể được tổng quát hóa. 
 * Khi cần nhiều hơn một tham số, các tham số được chỉ định, 
 * cách nhau bằng dấu phẩy, trong một danh sách được bao bọc bởi dấu ngoặc đơn 
 * ở phía trái của toán tử lambda.
 * 
 * Đây là một điểm quan trọng về nhiều tham số trong một biểu thức lambda: 
 * Nếu bạn cần khai báo rõ ràng kiểu của một tham số, thì tất cả các tham số khác 
 * cũng phải có kiểu đã được khai báo. Ví dụ, điều này là hợp lệ:
 * 		(int n, int d) -> (n % d) == 0
 * Nhưng điều này không hợp lệ:
 * 		(int n, d) -> (n % d) == 0*/
	}
}

interface NumericTest2 {
	boolean test(int n, int d);
}
