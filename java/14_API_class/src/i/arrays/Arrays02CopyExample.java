package i.arrays;

import java.util.Arrays;

public class Arrays02CopyExample {

	public static void main(String[] args) {
		int[] scores = {100,60,70,80,90};
		System.out.println(Arrays.toString(scores));
		int[] scores2 = new int[scores.length+1];
		for(int i=0; i<scores.length; i++) {
			scores2[i] = scores[i];
		}
		System.out.println(Arrays.toString(scores2));
		
		char[] arr1 = {'J','A','V','A'};
		// Arrays.copyOf(원본배열, 복사할 길이);
		System.out.println(Arrays.toString(arr1));
		char[] arr2 = Arrays.copyOf(arr1, 3);
		System.out.println(Arrays.toString(arr2));
		char[] arr3 = Arrays.copyOf(arr1, arr1.length+1);
		System.out.println(arr1.length);
		System.out.println(arr3.length);
		System.out.println(Arrays.toString(arr3));
		// J A V A
		// 0 1 2 3
		char[] arr4 = Arrays.copyOfRange(arr1, 1, 3);// 1~2
		System.out.println(Arrays.toString(arr4));
	}

}











