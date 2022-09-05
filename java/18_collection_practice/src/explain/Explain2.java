package explain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**	 - 문서 주석 
 * 해당 국가의 수도 맞추기 게임을 프로그램으로 만들고자 한다. 
   나라 이름(country)과 수도(capital)로 구성된 
   Nation 클래스를 작성하고 
   ArrayList<Nation> 컬렉션을 이용하여 
   프로그램을 작성시오.
   (ArrayList에 8개의 국가에 대한 기본적인 정보 입력)
 */
class Nation{
	
	private String country;	// 나라 이름
	private String capital;	// 수도 이름
	
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Nation) {
			Nation n = (Nation)obj;
			if(this.country.equals(n.getCountry())) {
				return true;
			}
		}
		return false;
	}
}


public class Explain2 {
	
	private ArrayList<Nation> store = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public Explain2(){
		store.add(new Nation("한국","서울"));
		store.add(new Nation("프랑스","파리"));
		store.add(new Nation("그리스","아테네"));
		store.add(new Nation("스페인","마드리드"));
		store.add(new Nation("중국","베이징"));
		store.add(new Nation("영국","런던"));
		store.add(new Nation("미국","워싱턴"));
		store.add(new Nation("독일","베를린"));
		store.add(new Nation("러시아","모스크바"));
	}
	
	// program start
	public void run() {
		System.out.println("*** 수도 맞추기 게임을 시작합니다.");
		while(true) {
			System.out.println("입력:1, 퀴즈:2, 종료:3 >>");
			int menu = sc.nextInt();
			switch(menu) {
			case 1 :
				// 국가별 수도 정보를 추가
				input();
				break;
			case 2 : 
				// 국가 이름으로 수도 정보 맞추기
				quiz();
				break;
			case 3 : 
				System.out.println("게임을 종료합니다.");
				return;
			default : 
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void input() {
		int n = store.size();
		System.out.println("현재 "+n+"개의 나라와 수도가 입력되어 있습니다.");
		a : while(true) {
			System.out.printf("국가 입력(현재:%d번재 국가 등록 / q는 종료)",store.size()+1);
			String country = sc.next();
			if(country.equals("q")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			System.out.println("수도 입력 >>");
			String capital = sc.next();
			Nation nation = new Nation(country,capital);
			if(store.contains(nation)) {
				System.out.println(country+"(은)는 이미 존재합니다.");
				continue;
			}
			/*
			for(int i=0; i<store.size(); i++) {
				Nation na = store.get(i);
				//if(na.getCountry().equals(nation.getCountry())) {
				if(nation.equals(na)) {
					System.out.println(country+"(은)는 이미 존재합니다.");
					continue a;
				}
			}
			*/
			store.add(nation);
		}
	}
	
	private void quiz() {
		
		if(store.isEmpty()) {
			System.out.println("모두 확인했습니다.");
			System.out.println("나라 정보를 추가하거나 종료하세요~!");
			return;
		}
		
		
		// store.size() - 1
		/*
		int index = (int)(Math.random()*store.size());
		Nation nation = store.get(index);
		*/
		Collections.shuffle(store);
		Nation nation = store.get(0);
		String question = nation.getCountry();
		String answer = nation.getCapital();
		System.out.println(question+"의 수도는? ");
		
		String capitalFromUser = sc.next();
		if(answer.equals(capitalFromUser)) {
			System.err.println("정답");
			// 맞힌 정보는 삭제
			// store.remove(nation);
			store.remove(0);
		}else {
			System.out.printf("아닙니다! %s의 수도는 %s입니다. %n",question,answer);
		}
	}

	public static void main(String[] args) {
		new Explain2().run();
		/*
		Explain2 e = new Explain2();
		e.run();
		*/
	}

}














