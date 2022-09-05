import java.util.Scanner;

public class PracticeStringPrint {

	public static void main(String[] args) {
		String str ="Hello Java!!";
		System.out.println(str);
		// println() - 넘겨받은 값을 console에 출력하고 줄바꿈
		// print() - 넘겨받은 값을 console에 출력하고 줄바꿈하지 않음
		// printf() - print format 형식화된 지시어를 통해 출력
		/*
		 	printf - 줄바꿈이 이루어지지 않음
		 	출력하려는 지시자(값)의 수만큼 필요한 값을 전달해야함.
		 	지시자
		 	%d	-	int(decimal) 10진법의 정수 형식
		 	%b	-	boolean 논리값
		 	%o	-	oct 8진법으로 표현
		 	%x	-	16진법으로 출력
		 	%f	-	float - 실수 형태로 출력
		 	%c	-	character - 문자형식으로 출력
		 	%s	-	string 문자형태로 출력
		 	%n	-	new line 줄바꿈
		 	
		 	%[-][0][n][.m][,n]
		 	%[n] : 출력할 전체 자리수를 지정(오른쪽 정렬)
		 	%5d , 1000	 == []1000
		 	%[0] : 전체 자리수가 지정되어 있을때 빈자리를 0으로 채움
		 	%05d , 1000	 == 01000
		 	%[-] : 전체 자리수가 지정된 경우 
		 		   왼쪽으로 정렬하고 빈칸에 공백 출력
 		    %[.m] : 소수점 아래 자리수를 지정.
 		            잘리는 소수점 자리는 반올림
        	%[,]  : 정수의 자리수 표현
        			10,000,000
			0,-	: 정수에서만 사용가능
		 */
		System.out.printf("%s의 교재는 %,020d입니다. %n","자바",10000000);
		System.out.printf("%s의 교재는 %20d입니다.\n","자바",10000000);
		System.out.printf("%s의 교재는 %-20d입니다.\n","자바",10000000);
		System.out.printf("자리수 지정 : %4d%n",1);
		System.out.printf("자리수 지정 : %4d%n",10);
		System.out.printf("자리수 지정 : %4d%n",100);
		System.out.printf("자리수 지정 : %4d%n",1000);
		
		System.out.printf("자리수 지정 : %d%n",1);
		System.out.printf("자리수 지정 : %d%n",10);
		// 소수점 자리 %.mf
		System.out.printf("%.2f %n",1234.123);
		System.out.printf("%.2f %n",1234.127);
		// 오류를 표현
		System.err.println("니가 잘못했네.");
		
		// 원의 면적
		double area, radius;
		System.out.println("반지름을 입력해 주세요 > ");
		Scanner sc = new Scanner(System.in);
		radius = sc.nextDouble();
		double pi = 3.14;
		area = radius * radius * pi;
		System.out.println(area);
		System.out.printf("반지름이 %.1f인 원의 면적은 : %.1f",radius,area);
		
		// sum
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		System.out.println("합은 : 55");
		
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			System.out.print(i+" ");
			sum = sum + i;
		}
		System.out.println();
		System.out.println("합은 : "+sum);
	}

}













