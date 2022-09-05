package static_test;

class Student{
	
	static String school;
	
	String name;
	int age;
	String grade;
	
}

public class StaticTest {

	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.age = 30;
		stu1.grade = "A";
		stu1.name= "최기근";
		
		Student.school = "한국기술교육직업전문학교";
		//Student.age = 10;
		System.out.println(stu1.age);
		System.out.println(stu1.grade);
		System.out.println(stu1.name);
		System.out.println(stu1.school);
		
		Student stu2 = new Student();
		stu2.age = 20;
		stu2.grade = "D";
		stu2.name = "하옥형";
		System.out.println(stu2.age);
		System.out.println(stu2.grade);
		System.out.println(stu2.name);
		System.out.println(stu2.school);
		
		Student.school = "부산교도소";	
		System.out.println(stu1.school);
		System.out.println(stu2.school);
		System.out.println(stu1.school == stu2.school);
		
		Math.random();
	}

}





