package extends5.polymorphism.customer;

public class GoldCustomer extends Customer{
	
	double saleRatio;		// 할인율

	public GoldCustomer(int customerID, 
						String customerName) {
		super(customerID, customerName);
		super.customerGrade = "GOLD";
		super.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += (price * bonusRatio);
		return price - (int)(price * saleRatio);
	}

}






