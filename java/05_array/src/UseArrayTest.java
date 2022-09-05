
public class UseArrayTest {

	public static void main(String[] args) {
		// 배열 생성 방법
		// 1. 정해진 값이 있을 시
		// 정해진 값으로 크기가 결정되므로 크기를 지정할 필요가 없음
		int[] array = new int[]{10,20,30,40,50};
		
		// 2. 선언과 동시에 값을 지정할때는 new 연산자를 생략가능
		int array2[] = {50,60,70,80};
		
		// 3. 생성 시 값이 정해져 있지 않을 때는
		//    공간만 생성 가능
		//    공간에 기본값으로 자동 초기화
		// 정수 - 0 | 실수 - 0.0 | 논리 - false | 참조 - null
		int[] array3 = new int[5];
		// int형 정수값 5개를 저장 할 수 있는 공간을 확보
		// 변수에 위치를 저장해 놓는다.
		// 변수를 통해서 배열에 접근이 가능하고
		// 배열의 각각 값에 접근할때는 인덱스 번호를 이용
		
		// array3 = [0][0][0][0][0];
		//           0  1  2  3  4
		
		// 배열의 크기를 저장하고 있는 값 - 배열변수.length
		System.out.println(array3);
		System.out.println(array3.length);
		// 참조 타입은 null 로 초기화가 가능
		int[] array4 = null;
		System.out.println(array4);
		//System.out.println(array4.length);
		array4 = new int[3];
		//array4.length = 10;
		
		int a = array4[0];
		System.out.println(a);
		array4[0] = 30;
		array4[1] = 50;
		array4[2] = 70;
// 인덱스를 벗어난 번호의 공간은 존재하지 않음 오류 발생
//		array4[3] = 80;
// 타입이 일치하지 않는 값의 대입은 컴파일 오류 발생
//		array4[2] = 70.0;
// 순차적으로 증가하는 인덱스 번호를 가지고 있으므로
// 반복문을 이용하여 배열의 값에 접근이 용이하다.
// 0 ~ 배열의 length -1 까지 1씩 순차적으로 증가
		for(int i=0; i < array4.length; i++) {
			System.out.println(array4[i]);
		}
		
		
		final int value = 10;
		//value = 100;
		System.out.println(value);
	}

}


















