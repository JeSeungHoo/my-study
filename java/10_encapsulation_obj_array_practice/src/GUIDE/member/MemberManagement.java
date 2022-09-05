package GUIDE.member;

import java.util.Scanner;

public class MemberManagement{
	

	// 사용자 입력
	private Scanner sc = new Scanner(System.in);
	
	// 회원정보 저장
	private Member[] members = new Member[100];
	
	// 관리자 계정
	private Member master = new Member(100,"master","root","root");
	
	// 로그인한 회원
	private Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	private boolean isRun = true;
	
	// 메뉴 번호 선택
	private int selectNo;
	
	// 프로그램 실행용 생성자
	public MemberManagement() {
		members[members.length-1] = master;
		isRun();
	}


	private void isRun() {
		System.out.println("프로그램 시작!");
		while (isRun) {
			System.out.println("===========================================================");
			System.out.println("1.회원가입 |2.로그인 |3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램종료");
			System.out.println("===========================================================");
			System.out.println("메뉴 선택 > ");
			
			if(!sc.hasNextInt()){
				System.out.println("번호를 입력해주세요. ");
				sc.next();
				continue;
			}

			selectNo = sc.nextInt();
			switch (selectNo) {
				case 1:
					System.out.println("== 회원가입 == ");
					join();
					break;
				case 2:
					System.out.println("== 로그인 == ");
					login();
					break;
				case 3:
					System.out.println("== 회원목록 == ");
					select();
					break;
				case 4:
					System.out.println("== 회원정보수정 == ");
					update();
					break;
				case 5:
					System.out.println("== 회원탈퇴 == ");
					delete();
					break;
				case 6:
					System.out.println("== 종료 == ");
					terminate();
					break;
				default:
					System.out.println("선택할 수 없는 번호입니다.");
			}
		}
	}

	
	private void terminate() {
		isRun = false;
	}

	private void join() {
		System.out.println("아이디를 입력해주세요");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String mPw = sc.next();
		System.out.println("비밀번호를 한번 더 입력해주세요");
		String rePw = sc.next();

		if (!memberIdCheck(mId) || !mPw.equals(rePw)) {
			System.err.println("사용 할 수없는 아이디 이거나 비밀번호가 일치하지 않습니다.");
			return;
		}

		System.out.println("이름을 입력해주세요");
		String mName = sc.next();
		for (int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				members[i] = new Member(i + 1, mName, mId, mPw);
				System.err.println("회원가입 완료");
				break;
			}
		}
	}

	private void login() {
		System.out.println("아이디를 입력해주세요 > ");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요 >");
		String mPw = sc.next();

		Member m = findMember(new Member(mId, mPw));

		if (m != null) {
			loginMember = m;
			System.out.println("정상적으로 로그인 되었습니다.");
			System.out.println(m.toString());
			if(m.getmName().equals("master")) {
				System.out.println("관리자 계정입니다.");
			}
			return;
		}
		System.err.println("일치하는 회원 정보가 없습니다.");
	}

	private void select() {
		if (loginMember != null && loginMember.equals(master)) {
			for (Member m : members) {
				if (m != null)
					System.out.println(m);
			}
		} else {
			System.err.println("관리자만 확인 가능한 메뉴입니다.");
		}
	}

	private void update() {
		// 개인회원 - 자기정보(이름) 만 수정 가능
		// 관리자 - 전체 회원 정보(이름) 수정 가능

		if (loginMember == null) {
			System.err.println("로그인 후 사용가능 한 메뉴입니다.");
			return;
		}

		if (loginMember.equals(master)) {
			// 관리자
			System.out.println("== 관리자 회원정보 수정");
			select();
			System.out.println("수정할 회원 번호를 입력해 주세요.");
			int mNum = sc.nextInt();

			for (int i = 0; i < members.length; i++) {
				if (members[i] != null && members[i].getmNum() == mNum) {
					System.out.println("수정할 회원의 이름을 입력해 주세요 > ");
					String name = sc.next();
					members[i].setmName(name);
					System.err.println("수정완료");
					return;
				}
			}
		} else {
			// 일반 회원
			System.out.println("= 내 정보 수정 =");
			System.out.println("비밀번호를 한번더 입력해 주세요.");
			String pw = sc.next();
			if (loginMember.getmPw().equals(pw)) {
				System.out.println("수정할 이름을 입력해주세요 > ");
				String name = sc.next();
				loginMember.setmName(name);
				System.err.println("수정이 완료되었습니다.");
				System.err.println(loginMember);
				return;
			}
			System.err.println("비밀번호가 일치하지 않습니다.");
		}
	}

	private void delete() {
		if (loginMember == null || loginMember.equals(master)) {
			System.err.println("회원 정보를 삭제할 수 없습니다.");
			return;
		}

		System.err.println("정말로 삭제 하시겠습니까? y/n");
		char str = sc.next().charAt(0);
		switch (str) {
		case 'Y': case 'y': case 'ㅛ':
			deleteMember();
			break;
		default:
			System.err.println("삭제가 취소되었습니다.");
			return;
		}
	}
	
	// 회원 정보 삭제
	private void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
	
	// 사용자 아이디 중복 체크
	private boolean memberIdCheck(String mId) {
		for(Member m : members) {
			if(m != null && m.getmId().equals(mId)) {
				return false;
			}
		}		
		return true;
	}
	
	// 회원 아이디와 비밀번호로 회원 찾기
	private Member findMember(Member m) {
		for(Member member : members) {
			if(member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
}
