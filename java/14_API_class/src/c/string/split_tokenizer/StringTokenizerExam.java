package c.string.split_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {
		String text = "이나영/김희선/박보영/원빈/장동건";
		StringTokenizer st = new StringTokenizer(text,"/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println("=====================");
		text = "홍길동|페이커,박태환&최기근\\하옥형\"이순신";
		st = new StringTokenizer(text,"|,&\\\"");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		
		
		
	}

}











