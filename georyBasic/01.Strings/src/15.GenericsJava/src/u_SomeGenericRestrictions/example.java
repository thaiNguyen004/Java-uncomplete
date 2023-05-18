package u_SomeGenericRestrictions;
/*
 * Một số hạn chế chung
 * Có một vài hạn chế mà bạn cần lưu ý khi sử dụng generics.
 * Chúng liên quan đến việc tạo đối tượng của một tham số kiểu, 
 * thành viên tĩnh, ngoại lệ và mảng. Mỗi hạn chế sẽ được xem xét ở đây.
 * Tham số kiểu không thể được khởi tạo
 * Không thể tạo một phiên bản của một tham số kiểu. Ví dụ, hãy xem xét lớp này.
 */

class Gen<T> {
	T ob;
	Gen() {
//		ob = new T(); //Lỗi Ellagel (Bất hợp pháp)
	}
}
/*
 * Ở đây, việc cố gắng tạo một phiên bản của T là bất hợp pháp. 
 * Lý do rất dễ hiểu: trình biên dịch không biết tạo ra đối tượng kiểu gì. 
 * T chỉ là một trình giữ chỗ.
 */


//Restrictions on Static Members (Hạn chế đối với thành viên tĩnh)
/* 
 * Không có thành viên tĩnh nào có thể sử dụng một tham số kiểu được khai báo 
 * bởi lớp bao quanh. 
 * Ví dụ, cả hai thành viên tĩnh của lớp này đều là không hợp lệ:
 */
class Wrong <T> {
//	Biến static
	T ob; 		  //=> Bình thường
//	static T ob;	=> Lỗi 
	
//	Phương thức static
	T getob() {return ob;} // Bình thường
//	static T getob() {return ob;} 	Lỗi

/*
 * Mặc dù bạn không thể khai báo các thành viên tĩnh sử dụng một tham số kiểu 
 * được khai báo bởi lớp bao quanh, bạn có thể khai báo các phương thức tĩnh 
 * generic, mà định nghĩa các tham số kiểu riêng của chúng, 
 * như đã được thực hiện trước đây trong chương này.*/
	static <String, Integer> void nameMethod (String str, int a) {
		//....
	}
}

/* Hạn chế về Mảng Generic
 * Có hai hạn chế quan trọng về generics áp dụng cho mảng. 
 * Thứ nhất, bạn không thể khởi tạo một mảng có kiểu phần tử là một tham số kiểu. 
 * Thứ hai, bạn không thể tạo một mảng chứa các tham chiếu generic cụ thể kiểu. 
 * Đoạn chương trình ngắn sau đây cho thấy cả hai tình huống:
 */
class RestrictionArray <T extends Number> {
	T ob;
	T vals[]; //OK
	
	public RestrictionArray(T o, T[] nums) {
		ob = o;
//		vals = new T[10];  Không thể khởi tạo 1 mảng kiểu T
		vals = nums; //OK
	}
}
public class example {
	public static void main(String[] args) {
		Integer[] n = {1, 2, 3, 4, 5};
		
		var iOb = new RestrictionArray<Integer>(5, n); //OK
		
		//Không thể tạo một mảng chứa các tham chiếu generic cụ thể
//		RestrictionArray<Integer> gens[] = new RestrictionArray<Integer>[10]; lỗi
		
		RestrictionArray<?> gens2 [] = new RestrictionArray<?> [10];
	}
/*
 * Như chương trình đã thể hiện, việc khai báo một tham chiếu 
 * đến một mảng có kiểu T là hợp lệ, như dòng này:
 * 		T vals[]; // OK
 * Tuy nhiên, bạn không thể khởi tạo một mảng của T, như đã cố gắng trong 
 * dòng đã bị chú thích này: 
 * 		vals = new T[10]; // không thể tạo một mảng của T
 * Lý do bạn không thể tạo một mảng của T là vì trình biên dịch không biết 
 * tạo ra một loại mảng nào thực sự.
 * 
 * Tuy nhiên, bạn có thể truyền một tham chiếu đến một mảng tương thích với kiểu 
 * vào phương thức Gen() khi tạo đối tượng và gán tham chiếu đó cho vals, 
 * như chương trình thực hiện trong dòng này:
 * 		vals = nums; // OK để gán tham chiếu vào mảng tồn tại
 * Điều này hoạt động vì mảng được truyền vào Gen có một kiểu đã biết, 
 * và sẽ là cùng một kiểu với T tại thời điểm tạo đối tượng.
 * 
 * Trong phương thức main(), lưu ý rằng bạn không thể khai báo một mảng 
 * các tham chiếu đến một kiểu generic cụ thể. Đó là, dòng này
 * 		Gen<Integer> gens[] = new Gen<Integer>[10]; // Sai!sẽ không được biên dịch.
 * Tuy nhiên, bạn có thể tạo một mảng các tham chiếu đến một kiểu generic 
 * nếu bạn sử dụng ký tự đại diện (wildcard), như được hiển thị ở đây:
 * 		Gen<?> gens[] = new Gen<?>[10]; // OK
 * Cách tiếp cận này tốt hơn việc sử dụng một mảng các kiểu nguyên thủy, 
 * vì ít nhất vẫn có một số kiểm tra kiểu sẽ được áp dụng.
 * 
 * Một lớp generic không thể mở rộng từ Throwable. 
 * Điều này có nghĩa là bạn không thể tạo các lớp exception generic.
 */
}
