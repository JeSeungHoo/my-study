package i.arrays;

import java.util.Arrays;

public class Arrays04EqualsExample {

	public static void main(String[] args) {
		int[][] original = {
								{1,2},{3,4}
						   };
		int[][] copy = Arrays.copyOf(original,original.length);
		System.out.println(original.equals(copy));
		System.out.println(Arrays.equals(original,copy));
		System.out.println(Arrays.deepEquals(original,copy));
		System.out.println("== 깊은 복제 ==");
		int[][] copy2 = Arrays.copyOf(original, original.length);
		copy2[0] = Arrays.copyOf(original[0], original[0].length);
		copy2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println(original.equals(copy2));
		System.out.println(Arrays.equals(original,copy2));
		copy2[1][0] = 100;
		System.out.println(Arrays.deepEquals(original, copy2));
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy2));
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy2));
		
	}

}










