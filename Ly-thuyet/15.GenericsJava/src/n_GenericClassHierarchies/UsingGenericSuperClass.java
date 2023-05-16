package n_GenericClassHierarchies;

//Sử dụng một lớp cha Generic
//Dưới đây là một ví dụ đơn giản về một hệ thống lớp sử dụng một lớp cha generic:
class Gen<T> {
	T ob;
	
	Gen(T o) {
		ob = o;
	}
	
	T getob() {
		return ob;
	}
}

class Gen2<T> extends Gen<T> {
	Gen2(T o) {
		super(o);
	}
}
/*
• Trong hệ thống lớp này, lớp Gen2 mở rộng từ lớp generic Gen. 
Chú ý cách khai báo của lớp Gen2 như sau:
	class Gen2<T> extends Gen<T> {
• Tham số kiểu T được chỉ định bởi lớp Gen2 và cũng được truyền cho lớp Gen 
trong mệnh đề extends. Điều này có nghĩa là bất kỳ kiểu dữ liệu nào được 
truyền cho Gen2 cũng sẽ được truyền cho Gen. Ví dụ, với khai báo này:
	Gen2<Integer> num = new Gen2<Integer>(100);
• Integer được truyền làm tham số kiểu cho Gen. Do đó, ob bên trong phần Gen 
của Gen2 sẽ có kiểu Integer.
Chú ý rằng Gen2 không sử dụng tham số kiểu T ngoại trừ việc hỗ trợ cho lớp cha Gen. 
• Do đó, ngay cả khi một lớp con của lớp cha generic không cần phải là generic, 
nó vẫn phải chỉ định các tham số kiểu cần thiết của lớp cha generic.
Tất nhiên, một lớp con có thể tự do thêm các tham số kiểu của riêng nếu cần. 
Ví dụ, dưới đây là một biến thể của hệ thống lớp trước đó trong đó Gen2 
thêm một tham số kiểu của riêng nó:
*/

//Một lớp con mở rộng lớp Gen và xác định tham số kiểu thứ hai
class Gen3 <T, V> extends Gen<T> {
	V ob3;
	Gen3(T o1, V o3) {
		super(o1);
		ob3 = o3;
	}
	
	V getob3 () {
		return ob3;
	}
}


public class UsingGenericSuperClass {
	public static void main(String[] args) {
		Gen3<String, Integer> x = 
				new Gen3<String, Integer>("Value : ", 100);
		System.out.print(x.getob());
		System.out.println(x.getob3());
		
/*
• Chú ý đến khai báo của phiên bản Gen3 này, được hiển thị như sau:
	class Gen3<T, V> extends Gen<T> {
Ở đây, T là kiểu được truyền cho Gen và V là kiểu chỉ định riêng cho Gen3. 
V được sử dụng để khai báo một đối tượng được gọi là ob3, và là kiểu trả về 
cho phương thức getob3(). Trong hàm main(), một đối tượng Gen3 được tạo ra 
với tham số kiểu T là String và tham số kiểu V là Integer. 
Chương trình hiển thị kết quả dự kiến như sau:
	Value is: 100
*/
		
		
		//Tạo một đối tượng Gen4
		Gen4<String> gen4 = 
				new Gen4<String>("Hello ", 47);
		
		System.out.print(gen4.getob());
		System.out.println(gen4.getnum());
	}
}

/*
Một Lớp con Generic
• Hoàn toàn chấp nhận được khi một lớp không generic là lớp cha của một lớp con generic. 
Ví dụ, xem xét chương trình sau đây:
*/

//Một lớp không generic có thể là một lớp cha của một lớp generic
class NonGen {
	int num;
	
	NonGen(int a) {
		num = a;
	}
	int getnum () {
		return num;
	}
}

class Gen4 <T> extends NonGen {
	T ob;
	
	Gen4 (T o, int i) {
		super(i);
		ob = o;
	}
	
	T getob() {
		return ob;
	}
}
/*
• Kết quả của chương trình được hiển thị như sau:
Hello 47

• Trong chương trình, chú ý cách lớp Gen4 kế thừa từ NonGen trong khai báo sau:
class Gen4<T> extends NonGen {
Vì NonGen không phải là generic, nên không có đối số kiểu được chỉ định. 
• Do đó, mặc dù Gen khai báo tham số kiểu T, nhưng nó không cần thiết cho NonGen 
(và không thể sử dụng cho NonGen). Do đó, NonGen được kế thừa bởi Gen theo cách thông thường. 
Không có điều kiện đặc biệt áp dụng.
*/
