package c_CollectionClasses;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

/*
• Lớp ArrayList mở rộng từ AbstractList và triển khai giao diện List.
ArrayList là một lớp generic có khai báo như sau:
	class ArrayList<E>
• Ở đây, E chỉ định loại đối tượng mà danh sách sẽ chứa.
ArrayList hỗ trợ mảng động có thể mở rộng khi cần. Trong Java,
mảng tiêu chuẩn có độ dài cố định. Sau khi mảng được tạo, nó không thể mở rộng
hoặc thu nhỏ, điều này có nghĩa là bạn phải biết trước số lượng phần tử mà một
mảng sẽ chứa. Tuy nhiên, đôi khi bạn không biết chính xác kích thước mảng mà bạn cần
cho đến thời điểm chạy. Để xử lý tình huống này, Collections
Framework định nghĩa ArrayList. Đơn giản, một ArrayList là một mảng độ dài biến
của các tham chiếu đối tượng. Đó là, một ArrayList có thể tăng hoặc
giảm kích thước một cách động. Các danh sách mảng được tạo với kích thước ban đầu. Khi kích thước này
vượt quá, tập hợp sẽ tự động được mở rộng. Khi đối tượng được loại bỏ,
mảng có thể bị thu nhỏ. 

• CHÚ Ý: Mảng động cũng được hỗ trợ bởi lớp cũ Vector, được mô tả
sau trong chương này.

• ArrayList có các hàm tạo như sau:
	ArrayList()
	ArrayList(Collection<? extends E> c)
	ArrayList(int capacity)

• Hàm tạo đầu tiên tạo một danh sách mảng rỗng. 
• Hàm tạo thứ hai tạo một danh sách mảng được khởi tạo với các phần tử của tập hợp c. 
• Hàm tạo thứ ba tạo một danh sách mảng có sức chứa ban đầu đã chỉ định. Sức chứa là 
kích thước của mảng cơ bản được sử dụng để lưu trữ các phần tử.
Sức chứa tăng tự động khi các phần tử được thêm vào danh sách mảng.
*/
public class a_ArrayListClass {
	public static void main(String[] args) {
		//Tạo ArrayList
		ArrayList<String> al = new ArrayList<String>();
		
		System.out.println("Initial size of al = " 
										+ al.size());
	
		al.add("C");
		al.add("A");
		al.add("B");
		al.add("D");
	
		System.out.println("Size of al after addition = " + al.size());
		
		//Hiển thị al
		System.out.println("Contents of al: " + al);
		
		//Remove elements from arraylist
		al.remove("A");
		al.remove(0);
		
		//Kích thước sau khi xóa
		System.out.println("Size of al after deletions = " + al.size());
	
		System.out.println("Contents of al: " + al);
		
/*
• Chú ý rằng al ban đầu rỗng và tăng kích thước khi các phần tử được thêm vào. 
Khi các phần tử bị loại bỏ, kích thước của nó sẽ giảm đi.
• Trong ví dụ trước, nội dung của một tập hợp được hiển thị bằng cách sử dụng quá trình 
chuyển đổi mặc định do toString() cung cấp, được kế thừa từ AbstractCollection. 
Mặc dù nó đủ cho các chương trình mẫu ngắn, bạn hiếm khi sử dụng phương thức này để hiển thị nội 
dung của một tập hợp trong thực tế. Thông thường, bạn sẽ cung cấp các phương thức đầu ra riêng của mình. 
Tuy nhiên, trong một vài ví dụ tiếp theo, đầu ra mặc định được tạo ra bởi toString() là đủ.
• Mặc dù sức chứa của một đối tượng ArrayList tăng tự động khi các đối tượng được lưu trữ trong nó, 
bạn có thể tăng sức chứa của một đối tượng ArrayList bằng cách gọi ensureCapacity(). 
Bạn có thể làm điều này nếu bạn biết trước rằng bạn sẽ lưu trữ nhiều phần tử hơn trong tập hợp so với hiện tại. 
Bằng cách tăng sức chứa một lần, từ đầu, bạn có thể ngăn chặn việc cấp phát lại nhiều lần sau này. 
Vì việc cấp phát lại tốn kém về thời gian, Việc ngăn chặn cấp phát lại không cần thiết 
có thể cải thiện hiệu suất của chương trình. Khi một đối tượng ArrayList được tạo với một sức chứa ban đầu, 
nó được cấp phát một mảng có kích thước tương ứng. Khi số lượng phần tử vượt quá sức chứa ban đầu, 
ArrayList sẽ tự động tăng kích thước mảng bên dưới để có đủ không gian lưu trữ các phần tử.
Tuy nhiên, quá trình cấp phát lại mảng là một hoạt động tốn kém về thời gian, vì nó phải tạo một mảng mới 
và sao chép dữ liệu từ mảng cũ sang mảng mới. Khi chúng ta biết trước rằng một tập hợp sẽ lưu trữ một số lượng 
lớn phần tử, việc tăng sức chứa ban đầu của ArrayList bằng cách gọi hàm ensureCapacity() có thể ngăn chặn 
các quá trình cấp phát lại mảng sau này.
Bằng cách tránh các quá trình cấp phát lại mảng không cần thiết, chúng ta giảm thiểu các hoạt động sao chép dữ liệu 
và tăng hiệu suất của chương trình. Tuy nhiên, việc tăng sức chứa ban đầu của ArrayList cũng tiêu tốn một lượng bộ
nhớ dư thừa. Do đó, việc quyết định cách tăng sức chứa ban đầu phụ thuộc vào các yếu tố khác nhau như dự đoán 
số lượng phần tử, yêu cầu về hiệu suất và sử dụng bộ nhớ.
	void ensureCapacity(int cap)
Ở đây, cap chỉ định sức chứa tối thiểu mới của tập hợp.
Ngược lại, nếu bạn muốn giảm kích thước của mảng đằng sau một đối tượng ArrayList để nó chính xác bằng số lượng 
phần tử nó đang giữ, gọi trimToSize(), được hiển thị ở đây:
	void trimToSize()

*/	
		//Khởi tạo một ArrayList với sức chứa ban đầu là 100
		ArrayList<String> arraylist = new ArrayList<>(100);
		//arraylist.ensureCapacity(100); Cách 2
		System.out.println("Initial size of arraylist = "+ arraylist.size()); // 0
		//Nên lưu ý về sức chứa và số lượng phần tử
		
		arraylist.add("One");
		//Ở đây arraylist chỉ có 1 phần tử nhưng sức chứa thì lại là 100 dư thừa 99 sức chứa
		
		//Sử dụng trimToSize(); để giảm kích thước của arraylist bằng với số lượng phần tử arraylist đang giữ
		arraylist.trimToSize();
		
		
		
/*
 Lấy một Mảng từ ArrayList (Obtaining an Array from ArrayList)
Khi làm việc với ArrayList, đôi khi bạn muốn lấy một mảng thực sự chứa nội dung của danh sách. 
Bạn có thể làm điều này bằng cách gọi toArray(), được định nghĩa bởi Collection. Có một số lý do 
tại sao bạn có thể muốn chuyển đổi một tập hợp thành một mảng, chẳng hạn như:
	• Để đạt được thời gian xử lý nhanh hơn cho một số thao tác
	• Để truyền một mảng cho một phương thức không được nạp chồng để chấp nhận một tập hợp
	• Để tích hợp mã dựa trên tập hợp với mã cũ không hiểu tập hợp
Dù cho lý do là gì, việc chuyển đổi một ArrayList thành một mảng là một vấn đề đơn giản. 
Có ba phiên bản của toArray(), được hiển thị lại ở đây để tiện cho bạn:
	object[] toArray()
	<T> T[] toArray(T array[])
	default <T> T[] toArray(IntFunction<T[]> arrayGen)
• Phiên bản đầu tiên trả về một mảng của Object. Hai phiên bản thứ hai và thứ ba trả về 
một mảng các phần tử có cùng kiểu với T. Ở đây, chúng tôi sẽ sử dụng phiên bản thứ hai 
vì sự tiện lợi của nó. Chương trình sau đây cho thấy cách sử dụng nó.
*/	
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(1);
		al2.add(2);
		al2.add(3);
		
		//Integer[] ia = al2.toArray(); lỗi!!
		//Khởi tạo Array có <Integer>
		Integer[] ia = new Integer[al2.size()];
		
		ia = al2.toArray(ia);
		
		//Duyệt mảng
		System.out.println(Arrays.toString(ia));
		
/*
• Có một điều thú vị khác trong chương trình này. Như bạn đã biết, các tập hợp chỉ có thể 
lưu trữ tham chiếu, không phải giá trị của các kiểu nguyên thủy. Tuy nhiên, autoboxing cho 
phép chúng ta truyền giá trị kiểu int vào add() mà không cần phải bọc chúng trong một Integer 
theo cách thủ công, như chương trình đã thể hiện. Autoboxing làm cho chúng tự động được bọc. 
Điều này giúp autoboxing cải thiện đáng kể tính dễ sử dụng khi lưu trữ các giá trị nguyên thủy
trong các tập hợp.
*/
	}
}
