package c7_comparable;

public class Person implements Comparable<Person>
{
	
	private String name;
	private int age;
	
	// 생성자 and toString
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		int result = 0;
		// 내가 가진 값이 크면 음수
		// 매개변수로 넘겨받은 객체의 age가 크면 양수
		/*
		result = o.age - this.age;
		System.out.println(o.age+"-"+this.age);
		*/
		result = this.age - o.age;
		System.out.println(this.age+"-"+o.age);
		System.out.println(result);
		return result;
	}
	
	
	
}
