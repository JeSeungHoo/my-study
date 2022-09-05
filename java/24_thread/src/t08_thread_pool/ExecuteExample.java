package t08_thread_pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecuteExample {

	public static void main(String[] args) {
		// 초기 스레드 수 : 스레드풀이 생성될때 기본적으로 생성되는 스레드 수
		// 코어 스레드 수 : 스레드가 증가한 후 사용되지 않는 스레드를 
		// 				 스레드 풀에서 제거하지 않고 최소한으로 유지할 개수
		// 최대 스레드 수 : 스레드 풀에서 생성 관리하는 최대 스레드 수
		// newCachedThreadPool
		// 초기스레드 코어스레드 수가 0
		// 일이 없는 스레드가 60초 이상 유지되면 스레드를 종료시키고 제거
		ExecutorService exe;// = Executors.newCachedThreadPool();
		exe = Executors.newFixedThreadPool(3);
		for(int i=0; i<16; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor tpe =(ThreadPoolExecutor)exe;
					// 스레드 풀에서 관리하고 있는 스레드 수
					int poolSize = tpe.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 수 : "+poolSize+"] 작업 스레드 이름 : " + threadName);
					int i = Integer.parseInt("일");
				}
			};
			// 다쓴 스레드를 버림
			// 결과값을 반환하지 않음. 오류가 생기면 처리가 없음.
			//exe.execute(task);
			try {
				Future<?> f = exe.submit(task);
				f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				//e.printStackTrace();
			}
		}
		
		exe.execute(new Runnable() {
			public void run() {
				System.out.println("추가된 작업");
			}
		});
		// 이미 시작된 작업은 실행하고, 새로운 작업은 추가하지 않음.
		exe.shutdown();
		
		try {
			exe.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wait 완료");
		// 모든task 강제 종료
		exe.shutdownNow();
	}

}












