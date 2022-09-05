import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		// import
		Scanner sc = new Scanner(System.in);
		// while 문 반복을 벗어날 flag
		boolean isRun = true;
		// 사용자의 예금을 저장할 변수
		int money = 0;
		
		gigeun : while(isRun) {
			System.out.println("==========================");
			System.out.println("1.예금|2.출금|3.잔액확인|4.종료");
			System.out.println("==========================");
			System.out.println("번호를 입력해주세요(1~4) > ");
			int selectNo = sc.nextInt();
			switch(selectNo) {
				case 1 : 
					System.out.println("예금");
					System.out.println("입금하실 금액을 입력하세요.");
					int deposit = sc.nextInt();
					money = money + deposit;
					System.out.println(deposit+"원 입금이 완료되었습니다.");
					break;
				case 2 : 
					System.out.println("출금");
					System.out.println("출금하실 금액을 입력해 주세요.");
					deposit = sc.nextInt();
					if(deposit > money) {
						System.out.println("출금 금액이 예금된 금액보다 클 수 없습니다.");
						continue gigeun;
					}
					money = money - deposit;
					System.out.println(deposit+"원이 출금되었습니다.");
					break;
				case 3 : 
					System.out.println("잔액확인");
					System.out.println("잔액 : " + money+"원 입니다.");
					break;
				case 4 : 
					System.out.println("종료");
					// isRun = false;
					break gigeun;
			}
		}
	}
}









