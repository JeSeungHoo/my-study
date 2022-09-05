package extends5.polymorphism;

public class Person {
	
	String name;
	int age;
	int weight;
	int height;
	
	public Person() {
		super();
	}

	public Person(String name, int age, int weight, int height) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	// Object의 toString() 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + "]";
	}
	
}











