import java.util.Scanner;

public class PracticeControlTest {

	public static void main(String[] args) {
		int odd = 0;
		for(int i = 1; i<=100; i+=2) {
			System.out.print(i+" ");
			odd +=i;
		}
		System.out.println("\n 홀수의 합은 : "+odd);
		odd = 0;
		for(int i=1; i<=100; i++) {
			if(i % 2 == 1) {
				odd += i;
			}
		}
		System.out.println("홀수의 총합은 : "+odd);
		
		// 사다리꼴 의 넓이
		// (윗변 + 아랫변)*높이 / 2 , 소수점
		int top = 5;
		int bottom = 10;
		int height = 7;
		double area = (top + bottom) * height / 2.0;
		System.out.println("사다리꼴의 넓이 : "+area);
		
		// 급여 명세서
		Scanner sc = new Scanner(System.in);
		System.out.println("사원명을 입력해주세요 > ");
		String 사원명 = sc.next();
		System.out.println("시급을 입력하세요 > ");
		int 시급 = sc.nextInt();
		System.out.println("근무시간을 입력하세요 > ");
		int 근무시간 = sc.nextInt();
		int 급여금액 = 시급 * 근무시간;
		System.out.println("==== 급여명세서 ====");
		System.out.println("사원명 : " + 사원명);
		System.out.println("급여금액 : "+급여금액);
		int 공제합계 = 급여금액 * 3 / 100; // 급여금액 * 0.03
		공제합계 = (int)(급여금액 * 0.03);
		System.out.println("공제합계 : "+공제합계);
		int 실지급액 = 급여금액 - 공제합계;
		System.out.println("실지급액 : "+실지급액);
		
		// max 찾기
		System.out.print("첫번째 정수 : ");
		int first = sc.nextInt();
		
		System.out.println();
		System.out.print("두번째 정수 : ");
		int second = sc.nextInt();
		if(first > second) {
			System.out.println("큰수는 : "+first);
		}else {
			System.out.println("큰수는 : "+second);
		}
		
		int max = 0;
		if(first > second) {
			max = first;
		}else {
			max = second;
		}
		System.out.println("큰 수는 : " + max);
		max = (first > second) ? first : second ;
		System.out.println("큰 수는 : " + max);
	}

}











