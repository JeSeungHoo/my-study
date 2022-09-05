package c.string.method;

public class StringCaseTrimExam {

	public static void main(String[] args) {
		String str1 = "Java Programming!";
		String str2 = "JAVA Programming!";
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1);
		System.out.println(lowerStr2);
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.toUpperCase());
		
		// trim - 문자열의 좌우에 생성된 공백 제거
		String tel1 = "               02";
		String tel2 = "1234             ";
		String tel3 = "    1234         ";
		String tel4 = "  010 9486 7166  ";
		System.out.println(tel1+tel2+tel3);
		System.out.println(tel1.trim()+tel2.trim()+tel3.trim());
		System.out.println(tel4.trim());
		
		
	}

}











