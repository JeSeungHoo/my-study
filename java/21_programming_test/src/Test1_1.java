
class Animal{}

class Cat extends Animal{}

class Tiger extends Animal{}

public class Test1_1 {

	public static void main(String[] args) {
		Animal c = new Cat();
		Animal t = new Tiger();
		if(t instanceof Cat) {
			Cat cat = (Cat)t;
			System.out.println("Cat type입니다.");
			System.out.println(cat);
		}else {
			System.out.println("Cat type이 아닙니다.");
		}
	}

}



