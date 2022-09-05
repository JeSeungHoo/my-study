package f.cooperation;

public class Student {
	String studentName;	// 학생이름
	int grade;			// 학년 - 1 :초등  2:중  3: 고등
	int money;			// 학생이 가지고 있는 금액
	
	Student(String studentName){
		this(studentName, 3, 10000);
		/*
		this.studentName = studentName;
		this.money = 10000;
		this.grade = 3;
		*/
	}
	
	Student(String studentName, int money){
		this(studentName,3,money);
		/*
		this.studentName = studentName;
		this.money = money;
		this.grade = 3;
		*/
	}
	
	// alt + s + a
	Student(String studentName, int grade, int money) {
		this.studentName = studentName;
		this.grade = grade;
		this.money = money;
	}
	
	void takeBus(Bus bus) {
		int pay = getPay();
		bus.take(pay);
		this.money -= pay;
	}
	
	void takeSubway(Subway subway) {
		int pay = getPay();
		subway.take(pay);
		this.money -= pay;
	}
	
	int getPay() {
		int pay = 0;
		switch(grade) {
			case 1 : pay = 600;
				break;
			case 2 : pay = 800;
				break;
			case 3 : pay = 1000;
				break;
		}
		return pay;
	}
	
	void showInfo() {
		System.out.println(
			studentName+"님의 남은 돈은 "+money+" 입니다."
		);
	}
}












