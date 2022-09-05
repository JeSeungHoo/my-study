package c2_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>();
		s1.add("A");
		//s1.add(0,"B");
		s1.add("D");
		s1.add("B");
		s1.add("C");
		System.out.println(s1);
		
		Iterator<String> iterator = s1.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(s1.contains("B"));
		s1.add("C");
		System.out.println(s1);
		
		Set<String> s2 = new HashSet<>();
		s2.add("A");
		s2.add("D");
		s2.add("E");
		System.out.println(s2);
		
		Set<String> s3 = new HashSet<>(s1);
		// 합집합
		s3.addAll(s2);
		System.out.println(s3);
		
		Set<String> s4 = new HashSet<>(s1);
		System.out.println("s4 : " + s4);
		System.out.println("s2 : " + s2);
		
		// 교집합
		boolean isOk = s4.retainAll(s2);
		System.out.println("isOK : " + isOk);
		System.out.println("s4 : "+s4);
		
		for(String s : s1) {
			System.out.print(s+" ");
			if(s.equals("A")) {
				//s1.remove(s);
			}
		}
		System.out.println();
		
		Iterator<String> itr2 = s1.iterator();
		while(itr2.hasNext()) {
			String s = itr2.next();
			// s1.remove(s);
			System.out.print(s+" ");
			if(s != null) {
				itr2.remove();
			}
		}
		System.out.println();
		System.out.println(s1.size());
		
		s1.add(null);
		s1.add("안녕");
		s1.add(null);
		System.out.println(s1);
		
	}

}


