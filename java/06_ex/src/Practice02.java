import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		numbers = new int[10];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = i+1;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 번호를 입력하세요 > ");
		int number = sc.nextInt();
		
		for(int i=0; i<numbers.length; i++ ) {
			if(number == numbers[i]) {
				System.out.printf("%d는 [%d] index에 있습니다.",number,i);
				break;
			}
		}
	}
}






