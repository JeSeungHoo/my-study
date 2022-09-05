package i.arrays;

import java.util.Arrays;

public class Arrays01SortExample {

	public static void main(String[] args) {
		int[] scores = {100,99,98,97,96};
		System.out.println(scores);
		String result = Arrays.toString(scores);
		System.out.println(result);
		
		// sort - 분류 - 오름차순 정렬
		// Arrays.sort(배열, 시작인덱스, 마지막인덱스-1);
		// {100,99,98,97,96}
		// {100,99,98,97,96}
		Arrays.sort(scores, 2, 4);
		System.out.println(Arrays.toString(scores));
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		
		String[] names = {"홍길동","박주신","김민수","전지현"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		// fill - 배열의 값을 매개변수로 전달한 값으로 채운다
		Arrays.fill(names, 1,3,"이주명"); // 1 , 2
		System.out.println(Arrays.toString(names));
		Arrays.fill(names, null);
		System.out.println(Arrays.toString(names));
		
	}

}











