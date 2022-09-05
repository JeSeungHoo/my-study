package encapsulation;

public class StudentTest {

	public static void main(String[] args) {
		Student choi = new Student();
		choi.name = "최기근";
//		choi.age = -40;
		choi.setAge(-60);
		choi.setGrade(4);
		System.out.println(choi.getAge());
		System.out.println(choi.getGrade());
		choi.setAge(26);
		choi.setGrade(3);
		String choiInfo = choi.toString();
		System.out.println(choiInfo);
	}

}










