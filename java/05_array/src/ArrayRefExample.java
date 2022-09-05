
public class ArrayRefExample {

	public static void main(String[] args) {
		int[] scores = {70,60,50,40,60,60};
		System.out.println(scores);
		int[] scores2 = scores;
		System.out.println(scores2);
		scores[0] = 80;
		System.out.println(scores[0]);
		System.out.println(scores2[0]);
		System.out.println(scores == scores2);
		
		int a = 10;
		int b = a;
		b = 20;
		System.out.println(b == a);
	
		
		int arrays[];
		arrays = null;
//		arrays[0] = 10;
		if(arrays == null) {
			arrays = new int[6];
		}
		arrays[arrays.length-1] = 100;
		
		char chars[] = new char[26];
		char c = 'A'; 	// 65
		
		for(int i=0; i < chars.length; i++, c++) {
			chars[i] = c;
		}
		
		for(int i=0; i<chars.length; i++) {
			System.out.print("["+chars[i]+"]");
		}
		System.out.println();
		
		// 실수
		double[] doubles = new double[3];
		doubles[1] = 3.14;
		for(int i=0; i<doubles.length; i++) {
			System.out.print(doubles[i]+" ");
		}
		System.out.println();
		
		// 논리형 - 초기값 false
		boolean[] tasks = new boolean[5];
		System.out.println(tasks[tasks.length-1]);
		
		// 참조 타입의 배열
		String[] strs;
		strs = new String[]{"C언어","포트란","JAVA"};
		System.out.println(strs[0]);
		System.out.println(strs);
		strs = new String[3];
		System.out.println(strs);
		
		for(String str : strs) {
			System.out.print(str+" ");
		}
		System.out.println();
		
		// 참조타입 배열 - 다차원 배열
		// 이차원 배열
		int[] array2[] = {
							{1,2,3},
							{4,5,6,7},
							{7,8,9}
						 };
		System.out.println(array2.length);
		System.out.println(array2[0].length);
		System.out.println(array2[1].length);
		System.out.println(array2[2].length);
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				System.out.print(array2[i][j]+" ");
			}
			System.out.println();
		}
		
		int[][] array3 = new int[3][];
		array3[0] = new int[3];
		array3[1] = new int[6];
		array3[2] = new int[4];
		
		
		
	} // main 종료

}












