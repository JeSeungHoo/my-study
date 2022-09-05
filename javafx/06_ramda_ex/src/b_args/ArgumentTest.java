package b_args;

public class ArgumentTest {

	public static void main(String[] args) {
		MyInterface i = new MyInterface() {
			@Override
			public void method(int x, int y) {
				int sum = x+y;
				System.out.println("sum : " + sum);
			}
		};
		i.method(10,20);
		
		i = (a, b)->{
			int result = a*b;
			System.out.println("result : " + result);
		};
		i.method(10, 20);
		
		SecondInterface si = s->{
			System.out.println(s);
		};
		si.method("참 쉽조잉");
	}

}





