package e_LambdaBlock;

import java.util.Set;
import java.util.TreeSet;

/*
 * Biểu thức Lambda dạng Block
 * • Thân của các biểu thức lambda được hiển thị trong các ví dụ trước chỉ bao gồm 
 * một biểu thức duy nhất. Loại thân lambda như vậy được gọi là thân biểu thức, 
 * và các lambda có thân biểu thức đôi khi được gọi là lambda biểu thức. 
 * • Trong thân biểu thức, mã phía bên phải của toán tử lambda phải chỉ bao gồm 
 * một biểu thức duy nhất. Mặc dù lambda biểu thức rất hữu ích, đôi khi tình huống 
 * sẽ yêu cầu nhiều hơn một biểu thức duy nhất. Để xử lý những trường hợp như vậy, 
 * Java hỗ trợ một loại biểu thức lambda thứ hai, trong đó mã phía bên phải của toán tử 
 * lambda bao gồm một khối mã có thể chứa nhiều hơn một câu lệnh. 
 * Loại thân lambda như vậy được gọi là thân block. 
 * • Lambda có thân block đôi khi được gọi là lambda block. 
 * Một lambda block mở rộng các loại hoạt động có thể xử lý trong một biểu thức lambda 
 * vì nó cho phép thân lambda chứa nhiều câu lệnh. 
 * Ví dụ, trong một lambda block, bạn có thể khai báo biến, sử dụng vòng lặp, 
 * chỉ định câu lệnh if và switch, tạo các khối lồng nhau và nhiều hơn nữa. 
 * Một lambda block dễ dàng tạo ra. Đơn giản chỉ cần bao quanh thân bằng dấu ngoặc nhọn 
 * như bạn làm với bất kỳ khối câu lệnh nào khác.Ngoài việc cho phép nhiều câu lệnh, 
 * lambda block được sử dụng tương tự như lambda biểu thức đã được thảo luận. 
 * Tuy nhiên, một khác biệt quan trọng là bạn phải rõ ràng sử dụng câu lệnh return 
 * để trả về một giá trị. Điều này là cần thiết vì thân lambda block không biểu diễn 
 * một biểu thức duy nhất.Dưới đây là một ví dụ sử dụng lambda block để tính và trả 
 * về giai thừa của một giá trị int:
 */

interface NumericFunc {
	int func (int n);
}

/*
 * • Trong chương trình, hãy chú ý rằng lambda block khai báo một biến được gọi là result, 
 * sử dụng vòng lặp for và có một câu lệnh return. Những điều này là hợp lệ trong thân 
 * lambda block. Về bản chất, thân block của một lambda tương tự như thân của một phương thức. 
 * • Một điểm khác là khi câu lệnh return xuất hiện trong một biểu thức lambda, 
 * nó chỉ gây ra một sự trở về từ lambda đó. Nó không khiến phương thức bao quanh trở về.
 * Một ví dụ khác về lambda block được hiển thị trong chương trình sau đây. 
 * Nó đảo ngược các ký tự trong một chuỗi.*/

interface StringFunc {
	String func (String str);
}
public class example {
	public static void main(String[] args) {
		NumericFunc factorial = (n) -> {
			int reuslt = 1;
			for (int i = 1; i <= n; i++) {
				reuslt *= i;
			}
			return reuslt;
		};
		
		System.out.println("Factorial của 5: " + factorial.func(5));
		System.out.println("Factorial của 9: "+ factorial.func(9));
		
		
		StringFunc reverse = (String str) -> {
			String result = "";
			for (int i = str.length()-1; i >= 0 ; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		
		System.out.println("Reverse FPT =  " + reverse.func("FPT")); //TPF
		System.out.println("Reverse Nguyên = " + reverse.func("Nguyên")); //nêyugN
		
/*
 * Các giao diện chức năng tổng quát
 * • Một biểu thức lambda không thể chỉ định các tham số kiểu. 
 * Do đó, một biểu thức lambda không thể là kiểu tổng quát. 
 * (Tất nhiên, do suy luận kiểu, tất cả các biểu thức lambda 
 * đều có một số đặc điểm "tựa tổng quát".) Tuy nhiên, 
 * giao diện chức năng liên kết với một biểu thức lambda có thể là kiểu tổng quát. 
 * • Trong trường hợp này, kiểu mục tiêu của biểu thức lambda được xác định, phần nào, 
 * bởi đối số hoặc các đối số kiểu được chỉ định khi một tham chiếu giao diện chức năng được khai báo.
 * • Để hiểu giá trị của các giao diện chức năng tổng quát, hãy xem xét điều này. 
 * Hai ví dụ trong phần trước sử dụng hai giao diện chức năng khác nhau, 
 * một gọi là NumericFunc và một gọi là StringFunc. Tuy nhiên, cả hai đều xác định 
 * một phương thức gọi là func() nhận một tham số và trả về một kết quả. 
 * 		• Trong trường hợp đầu tiên, kiểu của tham số và kiểu trả về là int. 
 * 		• Trong trường hợp thứ hai, kiểu tham số và kiểu trả về là String. 
 * • Do đó, sự khác biệt duy nhất giữa hai phương thức đó là kiểu dữ liệu mà chúng yêu cầu. 
 * • Thay vì có hai giao diện chức năng mà phương thức của chúng chỉ khác nhau về kiểu dữ liệu, 
 * ta có thể khai báo một giao diện tổng quát mà có thể được sử dụng để xử lý cả hai trường hợp. 
 * Chương trình dưới đây cho thấy cách tiếp cận này.
 */
		
		SomeFunc<Integer> factorial2 = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
			return result;
		};
		
		SomeFunc<String> reverse2 = (str) -> {
			String result = "";
			for (int i = str.length() - 1; i >=0 ; i--) {
				result += str.charAt(i);
			}
			return result; 
		};
		
		System.out.println("Factorial 5 = " + factorial2.func(5));
		System.out.println("Reverse Nguyên = " + reverse2.func("Nguyên"));
	}
}

// Một functional interface generic
interface SomeFunc <T> {
	T func (T o);
}
/*
 * Ở đây, T xác định cả kiểu trả về và kiểu tham số của func(). Điều này có nghĩa rằng 
 * nó tương thích với bất kỳ biểu thức lambda nào nhận một tham số và trả về một 
 * giá trị cùng kiểu.
 * Giao diện SomeFunc được sử dụng để cung cấp một tham chiếu đến hai loại biểu thức lambda khác nhau. Loại đầu tiên sử dụng kiểu String. Loại thứ hai sử dụng kiểu Integer. Do đó, cùng một giao diện hàm có thể được sử dụng để tham chiếu đến biểu thức lambda đảo ngược và biểu thức lambda của giai thừa. Chỉ có đối số kiểu được truyền vào SomeFunc khác nhau.*/
