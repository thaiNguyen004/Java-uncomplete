package p_Casting;
/*
Bạn chỉ có thể ép kiểu một thể hiện của một lớp generic sang một lớp khác 
nếu hai lớp đó tương thích và các đối số kiểu của chúng là giống nhau. 
Ví dụ, giả sử có chương trình như trên, việc ép kiểu sau là hợp lệ:

	(Gen<Integer>) iOb2 // hợp lệ

bởi vì iOb2 chứa một thể hiện của Gen<Integer>. Nhưng, việc ép kiểu sau:

	(Gen<Long>) iOb2 // không hợp lệ vì iOb2 không phải là một thể hiện của Gen<Long>.
*/

class Gen<T> {
	T ob;
	 
	Gen(T o) {
		ob = o;
	}
	
	T getob() {
		return ob;
	}
}

class Gen2 <T> extends Gen<T> {
	Gen2 (T o) {
		super(o);
	}
}
public class example {
	public static void main(String[] args) {
		Gen2<Double> iOb2 = 
				new Gen2<Double>(85.5);
		
//		Gen<Integer> castToInt = (Gen<Integer>) iOb2; compile error
		//Lý do vì iOb2 không phải là mội thể hiện của lớp Gen<Integer>
		//Lưu ý: để ép kiểu được thì hai lớp phải tương thích và cùng đối số kiểu
		
		//Ở ví dụ trên có cùng class là Gen2 tuy nhiên tham số kiểu lại không được
		//phép ép kiểu, Double không thể ép kiểu về Integer
		
//		Double a = new Double(10); 
//		Integer b = (Integer)a;			error
		
		
	}
}
