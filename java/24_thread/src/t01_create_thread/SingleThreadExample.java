package t01_create_thread;

import java.awt.Toolkit;

public class SingleThreadExample {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		// 현재 명령문이 수행되고 있는 thread객체를 반환
		System.out.println(Thread.currentThread());
		for(int i=0; i<5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		
		// 운영체제 하드 웨어 제어
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++){
			tool.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		
		System.out.println("Main 종료");
	}

}









