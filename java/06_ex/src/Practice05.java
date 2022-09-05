import java.util.Scanner;

public class Practice05 {

	public static void main(String[] args) {
		final int size = 10;
		int[] seats = new int[size];
		
		while(true) {
			System.out.println("--------------------");
			for(int i=0; i<size; i++) 
				System.out.print((i+1)+" ");
			System.out.println("\n--------------------");
			for(int i=0; i<size; i++) 
				System.out.print(seats[i]+" ");
			System.out.println("\n--------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) : ");
			
			Scanner scan = new Scanner(System.in);
			
			int s = scan.nextInt();
			if(s == -1) {
				System.out.println("시스템이 종료되었습니다.");
				break;
			}
			
			if(s < 1 || s > 10) {
				System.out.println("선택 할 수 없는 자리입니다.");
				continue;
			}
			
			if(seats[s-1] == 1) {
				System.out.println("이미 예약이 완료된 자리입니다.");
				continue;
			}
			
			seats[s-1] = 1;
			System.out.println("예약이 완료되었습니다.");
		}
	}
}








