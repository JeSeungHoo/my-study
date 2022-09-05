package generic03_method1;

class Util{
	//Box<String> box1 = Util.<String>boxing("사과");
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setType(t);
		return box;
	}
}

public class MethodExample {
	public static void main(String[] args) {
		Box<String> box1 = Util.<String>boxing("사과");
		System.out.println(box1.getType());
		
		Box<String> box2 = Util.boxing("오렌지");
		System.out.println(box2.getType());
		
		// Box<String> errorBox = Util.boxing(1);
		Box<Integer> box3 = Util.<Integer>boxing(3);
		System.out.println(box3.getType());
	}
}






