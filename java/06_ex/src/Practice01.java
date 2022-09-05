import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		int[] array = new int[5];
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int i=0; i<array.length; i++) {
			System.out.print("성적을 입력하세요 > ");
			total += array[i] = sc.nextInt();
		}
		System.out.println("총점은 : " + total);
		double avg = (double)total / array.length;
		System.out.printf("평균 성적은 : %.1f 입니다.",avg);
		sc.close();
	}
}






