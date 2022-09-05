package explain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Explain1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >>");
		String value = sc.nextLine();
		System.out.println("입력 완료");
		
		//StringTokenizer st = new StringTokenizer(value," ");
		// 구분자를 포함한다.
		// StringTokenizer st = new StringTokenizer(value," ",true);
		// 구분자를 포함하지않음
		StringTokenizer st = new StringTokenizer(value," ",false);
		System.out.println(st.countTokens());
		List<Character> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			char c = st.nextToken().charAt(0);
			list.add(c);
		}
		System.out.println(list);
	}

}









