package c8_comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		
		TreeSet<Fruit> treeSet = new TreeSet<>(new DecendingComparator());
		treeSet.add(new Fruit("포도",3000));
		treeSet.add(new Fruit("딸기",1500));
		treeSet.add(new Fruit("수박",10000));
		System.out.println(treeSet);
		
		Comparator<Fruit> compare = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};
		
		TreeSet<Fruit> treeSet2 = new TreeSet<>(compare);
		treeSet2.add(new Fruit("포도",3000));
		treeSet2.add(new Fruit("딸기",1500));
		treeSet2.add(new Fruit("수박",10000));
		System.out.println(treeSet2);
	}
}











