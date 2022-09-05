package test3.throw_exam;

import java.util.Calendar;
import java.util.Scanner;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(10000);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("출금할 금액을 입력해주세요.");
			int money = sc.nextInt();
			try {
				account.withdraw(money);
			} catch (BalanceInsufficientException e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		
	}

}









