package member.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.vo.BackUpMemberVO;
import member.vo.MemberVO;
import util.DBUtils;

public class MemberDAOImpl implements MemberDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	ResultSet rs;
	
	// MemberVO 정보를 넘겨받아서 회원가입을 진행하고
	// 가입 완료된 회원의 정보를 검색하여 Member type으로 반환
	@Override
	public MemberVO join(MemberVO memberVO) {
		MemberVO m = null;
		// 작성
		conn = DBUtils.getConnection();
		
		try {
			/*
			String sql = "INSERT INTO tbl_member(mName,mId,mPw,reg) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getmName());
			pstmt.setString(2, memberVO.getmId());
			pstmt.setString(3, memberVO.getmPw());
			pstmt.setLong(4, System.currentTimeMillis());
			pstmt.executeUpdate();
			
			sql = "SELECT * FROM tbl_member WHERE mNum = LAST_INSERT_ID()";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int mNum = rs.getInt(1);
				String mName = rs.getString(2);
				String mId = rs.getString(3);
				String mPw = rs.getString(4);
				long reg = rs.getLong(5);
				m = new MemberVO(mNum,mName,mId,mPw,reg);
			}
			*/
			String sql = "CALL insert_member(?,?,?,?)";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, memberVO.getmName());
			cstmt.setString(2, memberVO.getmId());
			cstmt.setString(3, memberVO.getmPw());
			cstmt.setLong(4, System.currentTimeMillis());
			rs = cstmt.executeQuery();
			if(rs.next()) {
				m = new MemberVO(
					rs.getInt(1),		// mNum
					rs.getString(2),	// mName
					rs.getString(3),	// mId
					rs.getString(4),	// mPw
					rs.getLong(5)		// reg
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBUtils.close(rs,stmt,pstmt);
			DBUtils.close(rs,cstmt);
		}
		return m;
	}
	
	// 로그인 - id 와 pw 가 일치하는 사용자일시 정보 전달
	@Override
	public MemberVO selectMember(String mId, String mPw) {
		MemberVO member = null;
		// 작성
		String sql = "SELECT * FROM tbl_member "
					+"WHERE mId = ? AND mPw = ?";
		conn = DBUtils.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO(
						rs.getInt("mNum"),
						rs.getString("mName"),
						rs.getString("mId"),
						rs.getString("mPw"),
						rs.getLong("reg")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs,pstmt);
		}
		return member;
	}
	
	// 회원번호로 회원 정보 검색
	@Override
	public MemberVO selectMember(int mNum) {
		MemberVO member = null;
		// 작성
		String sql ="SELECT * FROM tbl_member WHERE mNum = "+mNum;
		conn = DBUtils.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				member = new MemberVO(
						rs.getInt("mNum"),
						rs.getString("mName"),
						rs.getString("mId"),
						rs.getString("mPw"),
						rs.getLong("reg")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs,stmt);
		}
		return member;
	}

	// 기존에 동일한 아이디가 존재하는지 확인
	// true 사용가능 - 아이디가 존재하지 않으면
	// false 사용불가 - 아이디가 존재하면
	@Override
	public boolean selectMember(String mId) {
		boolean isChecked = true;
		// 작성
		conn = DBUtils.getConnection();
		
		try {
			pstmt = conn.prepareStatement(
				"SELECT * FROM tbl_member WHERE mId = ?"
			);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) isChecked = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs,pstmt);
		}
		return isChecked;
	}

	// 전체 회원 목록을 ArrayList에 담아서 반환
	@Override
	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> members = new ArrayList<>();
		// 작성
		String sql = "SELECT * FROM tbl_member ORDER BY mNum DESC";
		
		conn = DBUtils.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO member = new MemberVO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getLong(5)
				);
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(rs,stmt);
		}
		return members;
	}
	
	// mNum이 일치하는 사용자의 회원이름 정보 수정
	@Override
	public int update(MemberVO member) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_member SET mName = ? WHERE mNum = ?";
		
		conn = DBUtils.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getmName());
			pstmt.setInt(2, member.getmNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(pstmt);
		}
		return result;
	}
	
	// 회원 탈퇴 - 회원번호를 입력받아 일치하는 회원 정보 삭제
	/*
	@Override
	public int delete(int mNum) {
		int result = 0;
		// 작성
		conn = DBUtils.getConnection();
		MemberVO member  = selectMember(mNum);
		String sql = "INSERT INTO back_up_member "
					+"VALUES(?,?,?,?,?,now())";
		try {
			System.out.println(conn.getAutoCommit());
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getmNum());
			pstmt.setString(2, member.getmName());
			pstmt.setString(3, member.getmId());
			pstmt.setString(4, member.getmPw());
			pstmt.setLong(5, member.getRealReg());
			pstmt.executeUpdate();
			
			sql = "DELETE FROM tbl_member WHERE mNum = "+member.getmNum();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {}
		} finally {
			DBUtils.close(stmt,pstmt);
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {}
		}
		return result;
	}
	*/
	@Override
	public int delete(int mNum) {
		int result = 0;
		conn = DBUtils.getConnection();
		String sql = "DELETE FROM tbl_member WHERE mNum = "+mNum;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(stmt);
		}
		return result;
	}
	
	// 탈퇴한 회원 정보 검색
	@Override
	public ArrayList<BackUpMemberVO> deleteMember() {
		ArrayList<BackUpMemberVO> deletes = new ArrayList<>();
		// 작성
		conn = DBUtils.getConnection();
		String sql = "SELECT * FROM back_up_member "
					+" ORDER BY deleteDate DESC";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BackUpMemberVO vo = new BackUpMemberVO(
						rs.getInt(1),		//mNum
						rs.getString(2),	//mName
						rs.getString(3),	//mId
						rs.getString(4),	//mPw
						rs.getLong(5),		//reg
						rs.getTimestamp(6)	//deleteDate
				);
				deletes.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs,stmt);
		}
		return deletes;
	}
}
















