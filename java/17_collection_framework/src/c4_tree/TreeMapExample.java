package c4_tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(100, "최기근");
		map.put(15, "박주신");
		map.put(88, "하옥형");
		map.put(97,"박잼민");
		map.put(80, "박태환");
		System.out.println(map);
		
		Map.Entry<Integer, String> entry = null;
		entry = map.firstEntry();
		System.out.println("가장 낮은 키 값 : "+entry.getKey());
		System.out.println("가장 낮은 value: "+entry.getValue());
		
		int i = map.firstKey();
		System.out.println("첫번째 키값 : " + i);
	}

}



