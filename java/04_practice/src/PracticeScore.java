import java.util.Scanner;

public class PracticeScore {

	public static void main(String[] args) {
		// import
		Scanner sc = new Scanner(System.in);
		int score = 0;
		boolean isRun = true;
		while(isRun) {
			System.out.println("점수를 입력해 주세요>");
			if(!sc.hasNextInt()) {
				System.out.println("정수값이 아닙니다.\n다시입력하세요.");
				// break;
				sc.next();
				continue;
			}
			score = sc.nextInt();
			if(score >= 90) {
				System.out.println("A학점입니다.");
			}else if(score >= 80) {
				System.out.println("B학점입니다.");
			}else if(score >= 70) {
				System.out.println("C학점입니다.");
			}else if(score >= 60) {
				System.out.println("D학점입니다.");
			}else {
				System.out.println("F학점입니다.");
			}
		}
	}

}











