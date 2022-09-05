package t02_priority;

public class PriorityExample {

	public static void main(String[] args) {
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		for(int i=1; i<=10; i++) {
			Thread calc = new CalcThread("THREAD-"+i);
			if(i == 10) {
				calc.setPriority(Thread.MAX_PRIORITY);
			}
			calc.start();
		}
	}
}












