package c.string.method;

public class StringSubstringExam {

	public static void main(String[] args) {
		String ssn = "880815-1234567";
		int index = ssn.indexOf("-");
		String firstNum = ssn.substring(0,index);
		System.out.println(firstNum);
		
		String last = ssn.substring(index+1);
		System.out.println(last);
		char gender = ssn.charAt(7);
		System.out.println(gender);
	}

}





