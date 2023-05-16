package q_OverrideMethodInGenericClass;
class Gen<T> {
	T ob;
	
	Gen(T o) {
		ob = o;
	}
	
	T getob() {
		System.out.print("Gen's getob() : ");
		return ob;
	}
}

class Gen2<T> extends Gen<T> {
	Gen2 (T o) {
		super(o);
	}

	@Override
	T getob() {
		// TODO Auto-generated method stub
		System.out.print("Gen2's getob(): ");
		return ob;
	}
}
public class example {
	public static void main(String[] args) {
		Gen<Integer> iOb = 
				new Gen<Integer>(97);
		
		Gen2<Integer> iOb2 =
				new Gen2<Integer>(45);
		
		Gen2<String> strOb2 = 
				new Gen2<String>("Generic test");
		
		System.out.println(iOb.getob());
		
		System.out.println(iOb2.getob());
		
		System.out.println(strOb2.getob());
	}
}
