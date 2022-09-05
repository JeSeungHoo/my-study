package a.object.equals;

public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member("id001");
		Member member1 = new Member("id001");
		Member member2 = new Member("id002");
		// 주소값 비교
		System.out.println(member == member1);
		System.out.println(member == member2);
		// 두객체간 id값 비교
		System.out.println(member.equals(member1));
		System.out.println(member.equals(member2));
	}

}






