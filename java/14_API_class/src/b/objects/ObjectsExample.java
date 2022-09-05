package b.objects;

import java.util.Objects;

class A{}

public class ObjectsExample {

	public static void main(String[] args) {
		A a = null;
		A a1 = null;
		
		boolean isChecked = Objects.isNull(a);
		// a는 널인가 ? true : false;
		System.out.println(isChecked);
		isChecked = Objects.nonNull(a1);
		// a1은 널이 아닌가 ? true : false;
		System.out.println(isChecked);
		//isChecked = a.equals(a1);
		isChecked = Objects.equals(a, a1);
		System.out.println(isChecked);
		A c = new A();
		A d = c;
		isChecked = Objects.equals(a1, c);
		System.out.println(isChecked);
		
		isChecked = Objects.equals(d, c);
		System.out.println(isChecked);
		
		System.out.println("===================");
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		isChecked = Objects.equals(arr1, arr2);
		System.out.println(isChecked);
		
		isChecked = Objects.deepEquals(arr1, arr2);
		System.out.println(isChecked);
		
		System.out.println("=====================");
		//System.out.println(a1.toString());
		System.out.println(Objects.toString(arr2));
		System.out.println(Objects.toString(a));
		System.out.println(Objects.toString(a,"a는 참조하는 값이 없습니다."));
	}

}











