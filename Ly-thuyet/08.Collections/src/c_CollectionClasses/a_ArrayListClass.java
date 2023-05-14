package c_CollectionClasses;
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
	
}
