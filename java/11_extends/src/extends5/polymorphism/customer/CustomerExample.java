package extends5.polymorphism.customer;

public class CustomerExample {

	public static void main(String[] args) {
		Customer[] customerList = new Customer[10];
		Customer customerLee = new Customer(100110,"이주명");
		Customer customerHa = new Customer(100111,"하옥형");
		customerList[0] = customerLee;
		customerList[1] = customerHa;
		
		Customer customerPark = new GoldCustomer(100112,"박주신");
		customerList[2] = customerPark;
		
		Customer customerChoi 
				= new VIPCustomer(100113, "최은진", 12345);
		customerList[3] = customerChoi;
		System.out.println("== 고객 정보 == ");
		for(Customer c : customerList) {
			if(c != null) {
				System.err.println(c.showCustomerInfo());
			}
		}
		
		System.out.println("== 할인율과 보너스 포인트 계산 ==");
		int price = 100000; // 지불 금액
		for(Customer c : customerList) {
			if(c != null) {
				int cost = c.calcPrice(price);
				System.out.println(c.customerName+"님이 "+cost+"원 지불하셨습니다.");
				System.out.println(c.showCustomerInfo());
			}
		}
	}

}











