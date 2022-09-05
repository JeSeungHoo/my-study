package generic04_extends;

public class Child<T,M,C> extends Parent<T,M>{
	
	private C company;

	// getter setter toString 정의
	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Child [company=" + company + "]";
	}
	
}










