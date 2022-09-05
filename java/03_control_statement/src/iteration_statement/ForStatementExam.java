package iteration_statement;

public class ForStatementExam {
	public static void main(String[] args) {
		// 연속된 연산을 반복하며 수행하는 문장
		int sum = 1+2+3+4+5+6+7+8+9+10;
		// 1~100 까지 합을 구하시오.
		sum = 0;
		//int i;
		for(int i=1; i<=100; i++) {
			sum = sum + i;
		}
		// System.out.println(i);
		System.out.println(sum);
		
		//for(;;) {} // 무한히 반복
		int i = 1;
		sum = 0;
		for(;;i++) {
			if(i>10) {
				break;
			}
			sum += i;
		}
		
		for(i = 2; i<=9; i++) {
			System.out.print(i+"단\t|");
			for(int j=1; j<=9; j++) {
				System.out.print(i+" * "+j+" = "+(i*j)+"\t");
			}
			System.out.println();
		}
		
	}
}




