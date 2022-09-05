package generic.ex1;

import java.util.Arrays;

public class GenericMethod1 {

	public static void main(String[] args) {
		Integer[] iArray = {10,20,30,40,50};
		Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5};
		Character[] cArray = {'K','O','R','E','A'};
		
		printArray(iArray);
		GenericMethod1.<Double>printArray(dArray);
		printArray(cArray);
	}
	
	private static <T> void printArray(T[] t) {
		System.out.println(Arrays.toString(t));
	}
	
	/*
	private static void printArray(Double[] dArray) {
		// TODO Auto-generated method stub
		
	}

	private static void printArray(Integer[] iArray) {
		System.out.println(Arrays.toString(iArray));
	}
	*/
}
