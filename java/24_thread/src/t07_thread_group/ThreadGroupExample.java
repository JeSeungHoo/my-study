package t07_thread_group;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("MyGroup");
		Thread threadA = new WorkThread(group,"WorkThreadA");
		Thread threadB = new WorkThread(group,"WorkThreadB");
		
		threadA.start();
		threadB.start();
		System.out.println("[MyGroup List 정보]");
		group.list();	// 스레드 그룹에 포함된 스레드 정보 출력
		System.out.println();
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		group.interrupt();
		
		
	}

}









