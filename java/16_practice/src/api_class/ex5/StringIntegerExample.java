package api_class.ex5;

import java.util.Arrays;

public class StringIntegerExample {

	public static void main(String[] args) {
		String scores = "34,50,70,100,25,65";
		// 총점
		int total = 0;
		// 평균
		double avg = 0.0;
		// 작성
		String [] score = scores.split(",");
		System.out.println(Arrays.toString(score));
		for(String s : score) {
			System.out.print(s+" ");
			total += Integer.parseInt(s);
		}
		avg = (double)total / score.length;
		System.out.println();
		System.out.println(scores);
		System.out.println("총점 : "+total + "점");
		System.out.printf("평균 : %.1f",avg);
	} 

}




