package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.NoticeVO;
import utils.DBCPUtil;

public class NoticeDAOImpl implements NoticeDAO{
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public boolean noticeWrite(NoticeVO vo) {
		boolean isSuccess = false;
		conn = DBCPUtil.getConnection();
		String sql = "INSERT INTO notice_board VALUES(null,?,?,?,?,now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNotice_category());
			pstmt.setString(2, vo.getNotice_author());
			pstmt.setString(3, vo.getNotice_title());
			pstmt.setString(4, vo.getNotice_content());
			if(pstmt.executeUpdate() != 0) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			isSuccess = false;
		} finally {
			DBCPUtil.close(pstmt,conn);
		}
		return isSuccess;
	}

	@Override
	public ArrayList<NoticeVO> noticeList(int startRow, int count) {
		ArrayList<NoticeVO> list = new ArrayList<>();
		
		conn = DBCPUtil.getConnection();
		String sql = "SELECT * FROM notice_board "
				   + " ORDER BY n_num DESC "
				   + " limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO n = new NoticeVO(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getTimestamp(6)						
							);
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		conn = DBCPUtil.getConnection();
		int listCount = 0;
		String sql = "SELECT count(*) FROM notice_board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs,pstmt,conn);
		}
		return listCount;
	}

	@Override
	public NoticeVO noticeDetail(int notice_num) {
		NoticeVO notice = null;
		conn = DBCPUtil.getConnection();
		String sql = "SELECT * FROM notice_board WHERE n_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = new NoticeVO(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getTimestamp(6)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs,pstmt,conn);
		}
		return notice;
	}

	@Override
	public boolean noticeUpdate(NoticeVO vo) {
		boolean isSuccess = false;
		String sql = " UPDATE notice_board SET "
					+ " n_category = ? ,"
					+ " n_author = ? ,"
					+ " n_title = ? ,"
					+ " n_content = ? , "
					+ " n_date = now() "
					+ " WHERE n_num = ? ";
		conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNotice_category());
			pstmt.setString(2, vo.getNotice_author());
			pstmt.setString(3, vo.getNotice_title());
			pstmt.setString(4, vo.getNotice_content());
			pstmt.setInt(5, vo.getNotice_num());
			
			if(pstmt.executeUpdate() > 0) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			isSuccess = false;
		} finally {
			DBCPUtil.close(pstmt,conn);
		}
		return isSuccess;
	}

	@Override
	public boolean noticeDelete(int notice_num) {
		boolean isSuccess = false;
		conn = DBCPUtil.getConnection();
		String sql = "DELETE FROM notice_board WHERE n_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			if(pstmt.executeUpdate() > 0) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			isSuccess = false;
		} finally {
			DBCPUtil.close(pstmt,conn);
		}
		return isSuccess;
	}
}




