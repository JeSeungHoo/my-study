package iteration_statement;

import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		// ctrl + shift + o // 자동 import
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("구구단 단수를 정수로 입력 > ");
			// 사용자에게 값을 입력받아 값이 정수면 true
			// 정수값이 아니면 false를 반환
			isRun = sc.hasNextInt();
			if(isRun) {
				int i = sc.nextInt();
				System.out.print(i+"단 ");
				for(int j=1; j<10; j++) {
					System.out.print(i+" * "+j+" = "+(i*j)+"\t");
				}
				System.out.println();
			}
		}
	}
}












