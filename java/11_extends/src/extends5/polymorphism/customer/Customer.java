package extends5.polymorphism.customer;

public class Customer {
	int customerID;			// 고객 아이디
	String customerName;	// 고객 이름
	String customerGrade;	// 고객 등급
	int bonusPoint;			// 보너스 포인트
	double bonusRatio;		// 보너스 포인트 적립율
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		initCustomer();
	}
	
	// 고객 등급과 보너스 적립율 초기화
	private void initCustomer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	// 보너스 포인트 적립 후 구매 가격 알림
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName+"님의 등급은 "+customerGrade+"이며"
				+ " 보너스 포인트는 : "+bonusPoint+"입니다.";
	}
}














