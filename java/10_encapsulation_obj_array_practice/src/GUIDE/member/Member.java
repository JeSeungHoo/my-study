package GUIDE.member;


public class Member {
	
	// 회원관리번호
	private int mNum;
	// 회원 이름
	private String mName;
	// 회원 아이디
	private String mId;
	// 회원 비밀번호
	private String mPw;
	
	
	public Member() {}

	// 회원 로그인 및 정보 검색용 생성자
	public Member(String mId, String mPw) {
		this.mId = mId;
		this.mPw = mPw;
	}

	// 회원가입 용
	public Member(int mNum, String mName, String mId, String mPw) {
		this.mNum = mNum;
		this.mName = mName;
		this.mId = mId;
		this.mPw = mPw;
	}
	
	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	
	public boolean equals(Member member) {
		if(member == null) return false;
		if(this.mId.equals(member.getmId()) && this.mPw.equals(member.getmPw())) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Member{ [mNum : "+this.mNum+"] [mName : " +this.mName +"] [ mId : " + this.mId+"]";
	}

}
