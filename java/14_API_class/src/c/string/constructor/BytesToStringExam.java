package c.string.constructor;

import java.io.UnsupportedEncodingException;

public class BytesToStringExam {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = new byte[] {
		//	 H	e   l   l   o 공백 J  a   v  a
			72,101,108,108,111,32,74,97,118,97	
		};
		String str = new String(bytes);
		System.out.println(str);
		// 6번째 인덱스 부터 4개만큼 의 문자열 생성
		String str2 = new String(bytes,6,4,"UTF-8");
		System.out.println(str2);
		
		char[] strs = new char[] {'안','녕','하','세','요'};
		str = new String(strs);
		System.out.println(str);
		str = new String(strs, 0, 2);
		System.out.println(str);
		char[] charArray = str.toCharArray();
		for(char c : charArray) {
			System.out.print(c+" ");
		}
		System.out.println();
	}

}






