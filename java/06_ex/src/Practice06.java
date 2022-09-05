import java.util.Scanner;

public class Practice06 {

	public static void main(String[] args) {
		byte[][] seats = new byte[10][10];
		boolean isRun = true;
		
		String strColumn = null;
		
		int intRow = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(isRun) {
			// 상영관 그리기 시작
			System.out.println("             [SCREEN]");
			for(int i=0; i<seats.length;i++) {
				if(i == 0) {
					for(int j=0; j<seats.length; j++) {
						System.out.print("["+(j+1)+"]");
					}
					System.out.println(" [행]");
				}
				
				for(int j=0; j<seats[i].length; j++) {
					if(seats[i][j] == 0) {
						System.out.print("[□]");
					}else {
						System.out.print("[■]");
					}
				}
				System.out.println(" ["+(char)(i+65)+"열]");
			} // 그리기 종료
			
			System.out.println("예약 하실 좌석의 열 이름을 입력해 주세요 > ");
			strColumn = sc.next();
			char inputColumn = strColumn.charAt(0);
			System.out.println("입력한 열의 이름은 : "+inputColumn);
			
			// 65 - A     74 - J
			if(inputColumn < 65 || inputColumn > 74) {
				System.out.println("선택할 수 없는 열 이름입니다.");
				continue;
			}
			
			// 배열 인덱스 번호로 변환
			int column = inputColumn - 65;
			
			System.out.println("예약하실 좌석의 행 번호를 입력하세요 > ");
			intRow = sc.nextInt();
			if(intRow < 1 || intRow > 10) {
				System.out.println("선택할 수 없는 행 번호 입니다.");
				continue;
			}
			
			System.out.printf("선택하신 좌석은 %s열 %d행입니다.",inputColumn, intRow);
			System.out.println("예약 하시겠습니까? y/n");
			String selected = sc.next();
			if(selected.equals("Y") || selected.equals("y") || selected.equals("ㅛ")) {
				// 행번호가 1 ~ 10이므로 -1을 하여 인덱스 번호로 변환
				if(seats[column][intRow-1] == 1) {
					System.out.println("이미 예약이 완료된 좌석입니다.");
					continue;
				}
				seats[column][intRow-1] = 1;
				System.out.println("예약이 완료 되었습니다.");
			}else {
				System.out.println("예약이 취소되었습니다.");
				isRun = false;
			}
		}
	}

}













