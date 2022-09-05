package c1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
	/*
	 * Collection Framework
	 * 다수의 데이터를 쉽고 효과적으로 처리할 수 있도록
	 * 표준화된 방법을 제공하는 class의 집합
	 *  - 데이터를 저장하는 자료 구조와 데이터를 처리하는 알고리즘
	 *    을 구조화하여 클래스로 구현한 것
	 */
	public static void main(String[] args) {
		// 순서(index)가 존재하고 데이터 중복저장이 가능한 List
		ArrayList array = new ArrayList();
		array.add("문자열");
		array.add(100);
		
		String str = (String)array.get(0);
		System.out.println(array);
		
		ArrayList<String> strs = new ArrayList<>();
		strs.add("java");
		strs.add("JDBC");
		System.out.println(strs.size());
		strs.add("MYSQL");
		strs.add("mysql");
		String str2 = strs.get(0);
		System.out.println(str2);
		// System.out.println(strs.get(5));
		for(int i=0; i < strs.size(); i++) {
			System.out.println(strs.get(i));
		}
		for(String s : strs) {
			System.out.print(s+" ");
		}
		System.out.println();
		strs.add(2,"Servlet/JSP");
		System.out.println(strs);
		strs.add("JDBC");
		System.out.println(strs);
		// remove
		boolean isChecked = strs.remove("JDBC");
		System.out.println("isChecekd : " + isChecked);
		System.out.println(strs);
		
		String result = strs.remove(2);
		System.out.println(result);
		System.out.println(strs);
		
		isChecked = strs.contains("mysql");
		System.out.println("isChecked : " + isChecked);
		
		result = strs.set(2, "Oracle");
		System.err.println(result);
		System.out.println(strs);
		// list안에 값이 비어있는지 확인 비어있으면 true
		isChecked = strs.isEmpty();
		System.out.println("isEmpty : " + isChecked);
		// list안에 모든 값을 제거
		strs.clear();
		System.out.println(strs.size());
		System.out.println("isEmpty : " + strs.isEmpty());
		
		strs.add("JAVA");
		strs.add("Java");
		strs.add("JaVa");
		strs.add("java");
		System.out.println(strs);
		
		// list => array
		String[] ss = strs.toArray(new String[strs.size()]);
		System.out.println(Arrays.toString(ss));
		
		// Array => List
		List<String> list = Arrays.asList(ss);
		System.out.println(list);
		
	}
	
	
	

}













