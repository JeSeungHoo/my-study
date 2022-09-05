package c9_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=45; i++) {
			list.add(i);
		}
		System.out.println(list);
		// 섞는다.
		Collections.shuffle(list);
		System.out.println(list);
		List<Integer> lotto = list.subList(0, 6);
		System.out.println(lotto);
		Collections.sort(lotto);
		System.out.println(lotto);
		
		Collections.shuffle(list);
		List<Integer> myLotto = list.subList(0, 7);
		System.out.println(myLotto);
		
		System.out.println(Collections.max(myLotto));
		System.out.println(Collections.min(myLotto));
		
		Collections.sort(list);
		Collections.reverse(list);
		
		System.out.println(list);
		
	}

}










