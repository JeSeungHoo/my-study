class Member extends Object
{
	private String id;
	private String password;
	private String name;
	
	public void setId(String string) {
		this.id = string;
	}
	public void setPassword(String string) {
		this.password = string;
	}
	public void setName(String string) {
		this.name = string;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(//this != null && o != null &&
			o instanceof Member) {
			Member m = (Member)o;
			if(this.id.equals(m.id) 
					&& 
			   this.password.equals(m.password)) {
				return true;
			}
		}
		return false;
	}
	
}

public class Test1_2 {

	public static void main(String[] args) {
		Member choi = new Member();
		choi.setId("id001");
		choi.setPassword("pw001");
		choi.setName("최기근");
		System.out.println(choi);
		
		Member park = new Member();
		park.setId("id001");
		park.setPassword("pw001");
		park.setName("박주신");
		System.out.println(park);
		
		System.out.println(choi.equals(park));
	}

}










