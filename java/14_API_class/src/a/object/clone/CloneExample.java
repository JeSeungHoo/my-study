package a.object.clone;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		Member member = new Member(
			"최기근", 
			28,
			new int[] {100,95,99},
			new Car("캐스퍼")
		);
		System.out.println(member);
		Member cloned = (Member)member.clone();
		System.out.println(cloned);
		cloned.scores[0] = 90;
		System.out.println(member);
		System.out.println(cloned);
		

	}

}





