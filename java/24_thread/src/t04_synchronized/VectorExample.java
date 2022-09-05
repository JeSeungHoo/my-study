package t04_synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		//List<String> array = new ArrayList<>();
		List<String> array = new Vector<>();
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0; i<10000; i++) {
					array.add("최기근");
				}
				System.out.println("t1 종료");
			}
		};
		t1.start();
		System.out.println("==========================");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					array.add("천재");
				}
				System.out.println("t2 종료");
			}
		});
		t2.start();
		
		while(true) {
			if(t1.getState() == Thread.State.TERMINATED
					&&
			   t2.getState() == Thread.State.TERMINATED) {
				System.out.println("t1 , t2 작업 종료");
				System.out.println("array : "+array.size());
				break;
			}
		}
		
		System.out.println("Main 종료");
	}

}















