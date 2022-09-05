package c4_tree;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(87);
		treeSet.add(75);
		treeSet.add(new Integer(90));
		treeSet.add(80);
		treeSet.add(80);	// 중복 저장 안됨
		System.out.println(treeSet);
		Iterator<Integer> itr = treeSet.descendingIterator();
		while(itr.hasNext()) {
			int i = itr.next();
			System.out.print(i+" ");
		}
		System.out.println();
		TreeSet<Integer> decendingSet
			= (TreeSet<Integer>)treeSet.descendingSet();
		System.out.println(decendingSet);
		System.out.println(treeSet);
		
		int score = 0;
		// treeSet : [75, 80, 87, 90]
		score = treeSet.first();
		System.out.println("첫번째 값 : " + score);
		
		score = treeSet.last();
		System.out.println("마지막 값 : " + score);
		// [75, 80, 87, 90]
		score = treeSet.lower(87);
		System.out.println("87보다 낮은 수(바로 아래) : "+score);
		
		score = treeSet.higher(87);
		System.out.println("87보다 높은 수(바로 위) : "+score);
		
		score = treeSet.floor(85);
		System.out.println("85이거나 그 아래 수 : "+score);
		
		score = treeSet.ceiling(85);
		System.out.println("85이거나 그 위의 수 : "+score);
		
		score = treeSet.pollFirst();
		System.out.println("첫번째 값을 꺼내오고 set에서 삭제 : "+ score);
		System.out.println(treeSet);
		// [80, 87, 90]   score = 75
		
		score = treeSet.pollLast();
		System.out.println("마지막 값을 꺼내오고 set에서 삭제 : "+ score);
		System.out.println(treeSet);
	}

}











