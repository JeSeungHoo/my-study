package extends5.polymorphism;

public class PersonExample {

	public static void main(String[] args) {
		Person person = new Person("최기근",26,70,186);
		System.out.println(person.toString());
		System.out.println("=======================");
		System.out.println(person);
		
		Person student = new Student(
			"하옥형",500,68, 168,"902호","45번","3"
		);
		System.out.println(student);
		// student.study();
		Person teacher = new Teacher(
			"최기근",25,74,187,"ESD-82","체육","3"
		);
		System.out.println(teacher);
		//teacher.teach();
		Teacher t = (Teacher)teacher;
		t.teach();
		if(teacher instanceof Student) {
			Student s = (Student)teacher;
			s.study();
		}else {
			System.out.println("Student 타입이 아닙니다.");
		}
	}
}











