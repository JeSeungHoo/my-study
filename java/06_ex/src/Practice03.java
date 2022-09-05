public class Practice03 {

	public static void main(String[] args) {
		int s[] = {12, 3, 19, 6, 18, 8, 12, 4, 1, 19};
		int minimum;
		minimum = s[0];
		for(int i : s) {
			if(i < minimum) minimum = i;
		}
		System.out.println("최소값은 : " + minimum);
	}
}







