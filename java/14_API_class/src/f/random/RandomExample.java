package f.random;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// Random class
		// 랜덤 클래스가 생성 되어 실행될 때 시드값이 동일하면
		// 동일한 난수를 발생
		// 10억분의 1초
		long time = System.nanoTime();
		System.out.println(time);
		// 1000/1초
		long mTime = System.currentTimeMillis();
		System.out.println(mTime);
		
		Random random = new Random(5);
		for(int i=0; i<6; i++) {
			System.out.print(random.nextInt(45)+1+" ");
		}
		
		random = new Random(mTime);
		for(int i = 0; i<6; i++) {
			System.out.println(random.nextBoolean());
			System.out.println(random.nextInt());
			System.out.println(random.nextDouble());
			System.out.println(random.nextInt(100));
		}
	}

}


