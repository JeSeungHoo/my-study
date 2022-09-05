package c.methods;

public class AccountExample {

	public static void main(String[] args) {
		Account choi = new Account();
		choi.deposit(1000000);
		choi.withdraw(10000000);
		
		Account eraser = new Account();
		eraser.deposit(1000);
		eraser.withdraw(100000000);
		eraser.deposit(-20000);
		
		System.out.println("choi balance : "+ choi.balance);
		System.out.println("eraser balance : "+ eraser.balance);
	}

}











