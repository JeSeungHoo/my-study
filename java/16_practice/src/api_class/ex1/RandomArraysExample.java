package api_class.ex1;

import java.util.Arrays;
import java.util.Random;

public class RandomArraysExample {

	public static void main(String[] args) {
		int[] numbers = new int[10];
		Random random = new Random();
		
		System.out.print("최초의 리스트 : ");
		for(int i=0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100)+1;	// 1~100
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
		Arrays.sort(numbers);	// 오름차순 정렬
		System.out.print("정렬된 리스트 : ");
		for(int i : numbers) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}




