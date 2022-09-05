import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 프로그램 종료 flag
		boolean isRun = true;
		// 학생점수를 입력받아 저장할 배열
		int[] scores = null;
		// 학생 수를 입력받아 저장할 변수
		int studentNum = 0;
		
		while(isRun) {
			System.out.println("====================================");
			System.out.println("1.학생수|2.점수입력|3.전체점수|4.분석|5.종료");
			System.out.println("====================================");
			System.out.println("선택하실 기능의 번호를 입력하세요 >");
			
			int selectNo = sc.nextInt();
			System.out.println("선택하신 번호는 : "+selectNo);
			/*
			 	1. 학생 수를 입력 받아 점수를 저장할 수 있는 배열 생성
			 	2. 배열의 크기만큼 점수를 입력받아서 배열에 순차적으로 저장
			 	3. 배열에 저장된 점수를 출력
			 	4. 분석 - 배열에 저장된 점수를 가지고
			 	         (총점,평균,최고점수,최저점수) 출력
	 	        5. 프로그램 종료 
			 */
			if(selectNo!= 1 && scores == null) {
				System.out.println("학생 수를 먼저 입력해주세요.");
				continue;
			}
			
			switch(selectNo) {
				case 1 : 
					// 학생수 
					System.out.println("학생수를 입력해 주세요>");
					studentNum = sc.nextInt();
					scores = new int[studentNum];
					System.out.println("등록된 학생 수는 : "+scores.length);
					break;
				case 2 : 
					// 점수 입력
					System.out.println("학생 점수 입력");
					for(int i = 0; i<scores.length; i++) {
						System.out.println((i+1)+"번째 학생의 점수를 입력하세요 > ");
						scores[i] = sc.nextInt();
					}
					System.out.println("점수 입력 완료");
					break;
				case 3 : 
					// 등록된 점수 출력
					System.out.println("== 등록된 학생 점수 출력 ==");
					for(int score : scores) {
						System.out.println("등록된 학생의 점수는 : "+score);
					}
					break;
				case 4 : 
					// 분석 출력
					System.out.println("== 분석 ==");
					int sum = 0; 			// 총점
					double avg = 0;			// 평균
					int max = 0;			// 최고점수
					int min = scores[0];	// 최저점수
					for(int i : scores) {
						sum += i;
						if(max < i) max = i;
						if(min > i) min = i;
					}
					System.out.println("총점 : " + sum);
					System.out.println("최고 : " + max);
					System.out.println("최저 : " + min);
					avg = sum / (double)studentNum;
					System.out.printf("평균 : %.1f %n" , avg);
					break;
				default :
					System.out.println("프로그램 종료");
					isRun = false;
			}
		}
	}

}



