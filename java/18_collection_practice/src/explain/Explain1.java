package explain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Explain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >>");
		String value = sc.nextLine();
		System.out.println("입력 완료");
		
		// String.split(구분자)
		// StringTokenizer(문자열,구분자)
		// A B C D D F =>  ABCDDF
		value = value.replace(" ", "");
		char[] chars = value.toCharArray();
		System.out.println(Arrays.toString(chars));
		List<Character> charList = new ArrayList<>();
		for(char c : chars) {
			charList.add(c);
		}
		System.out.println(charList);
		double total = 0;
		
		for(char c : charList) {
			if(c == 'A') {
				total = total + 4;
			}else if(c == 'B') {
				total += 3;
			}else if(c == 'C') {
				total += 2;
			}else if(c == 'D') {
				total += 1;
			}else {
				total += 0;
			}
		}
		
		double avg = total / charList.size();
		System.out.printf("평균은 : %.2f %n",avg);
		System.out.println("시스템 종료");
		System.out.println("===========================");
 		//split
		System.out.println("다시 입력해 주세요 > ");
		value = sc.nextLine();
		String[] strs = value.split(" ");
		// [A,B,C,D,D,F]
		// Character.valueOf("문자열"); - 사용불가
		// (char)"문자열"	- 사용불가
		charList.clear();
		
		for(int i=0; i<strs.length; i++) {
			char c = strs[i].charAt(0);
			charList.add(c);
		}
		
		total = 0;
		
		for(int i=0; i<charList.size(); i++) {
			char c = charList.get(i);
			switch(c) {
				case 'A' : total += 4;
					break;
				case 'B' : total += 3;
					break;
				case 'C' : total += 2;
					break;
				case 'D' : total += 1;
					break;
				default : total += 0;
					break;
			}
		} // for end
		avg = total / charList.size();
		DecimalFormat df = new DecimalFormat("#.##");
		String result = df.format(avg);
		System.out.println("평균은 : " + result);
	}

}











