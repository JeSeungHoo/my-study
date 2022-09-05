package i.arrays;

import java.util.Arrays;

public class Arrays03SearchExample {

	public static void main(String[] args) {
		int [] scores = {1, 10, 5, 8, 7};
		//				 0   1  2  3  4 
		// 값을 찾지 못했을 경우 마지막 검색 위치를 음수로 반환
		// 				 -1 -2 -3 -4 -5 -6
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 10);
		System.out.println("찾은 인덱스 : " + index);
	}

}














