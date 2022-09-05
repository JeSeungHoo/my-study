package b.field;

public class FieldExample {
	// main() 가 포함이 되어있는 실행가능한 클래스
	public static void main(String[] args) {
		// Field.a
		Field f = new Field();
		// 객체,인스턴스의 필드 값을 읽어옴
		System.out.println(f.i);
		System.out.println(f.b);
		System.out.println(f.d);
		System.out.println(f.s);
		
		Field f2 = new Field();
		// 객체,인스턴스의 필드에 값을 저장
		f2.i = 100;
		f2.d = 3.14;
		f2.b = true;
		f2.s = "최기근";
	}
}







