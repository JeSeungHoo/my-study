package test3.throw_exam;

public class Account {
	// 잔고
	private long balance;
	
	// 입금
	public void deposit(int money) {
		balance += money;
	}
	// 출금
	public void withdraw(int money) 
				throws BalanceInsufficientException {
		if(balance < money) {
			String message
			= "잔고 부족 오류 : "+(money- balance)+"원 모자람";
			System.out.println(message);
			throw new BalanceInsufficientException(message);
		}
		balance -= money;
	}
}










