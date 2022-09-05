package api_class.ex3;

import java.util.Scanner;

public class StringMethodExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("문자열을 입력해 주세요 > ");
			String s = sc.nextLine();
			// java
			// indexOf ,  lastIndexOf
//			if(s.indexOf("java") != -1) {
			if(s.contains("java")) {
				System.out.println("java가 존재합니다.");
				System.err.println("시스템을 종료합니다.");
				break;
			}
			System.out.println("java가 존재 하지 않습니다.");
		}
	}
}




