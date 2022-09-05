package c.string.method;

public class StringIndexOfExam {

	public static void main(String[] args) {
		String str = "자바 프로그래밍을 자바!";
		// indexOf,   lastIndexOf
		// 매개변수로 넘겨받은 값이 문자열에 존재하는지
		// 확인하고 시작인덱스 값을 반환
		// 해당되는 값이 없으면 -1을 반환
		int location = str.indexOf("프로그래밍");
		System.out.println(location);
		
		if(str.indexOf("자바") != -1) {
			System.out.println("자바가 존재합니다.");
		}else {
			System.out.println("자바가 존재하지 않습니다.");
		}
		
		System.out.println(str.indexOf("자바"));
		System.out.println(str.lastIndexOf("자바"));
		
		String fileName = "cat.png";
		int index = fileName.lastIndexOf(".");
		String ext = fileName.substring(index+1);
		System.out.println(ext);
	}

}











