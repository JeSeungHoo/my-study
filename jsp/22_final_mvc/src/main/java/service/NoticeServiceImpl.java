package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.NoticeVO;
import repositories.NoticeDAO;
import repositories.NoticeDAOImpl;
import utils.Criteria;
import utils.PageMaker;

public class NoticeServiceImpl implements NoticeService{
	
	NoticeDAO dao = new NoticeDAOImpl();
	
	@Override
	public boolean noticeWrite(HttpServletRequest request) {
		NoticeVO vo = new NoticeVO(
						request.getParameter("notice_category"),
						request.getParameter("notice_author"),
						request.getParameter("notice_title"),
						request.getParameter("notice_content")
					);
		System.out.println(vo);
		return dao.noticeWrite(vo);
	}

	@Override
	public void noticeList(HttpServletRequest request) {
		int page = 1;
		String requestPage = request.getParameter("page");
		if(requestPage != null) {
			page = Integer.parseInt(requestPage);
		}
		Criteria cri = new Criteria(page, 10);
		ArrayList<NoticeVO> list 
				= dao.noticeList(cri.getStartRow(), cri.getPerPageNum());
		request.setAttribute("noticeList", list);
		
		int listCount = dao.getTotalCount();
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(listCount);
		System.out.println("NoticeList PageMaker : " + pm);
		request.setAttribute("pm", pm);
	}

	@Override
	public void noticeDetail(HttpServletRequest request) {
		String num = request.getParameter("notice_num");
		int notice_num = Integer.parseInt(num);
		request.setAttribute("notice", dao.noticeDetail(notice_num));
	}

	@Override
	public boolean noticeUpdate(HttpServletRequest request) {
		int notice_num = Integer.parseInt(
			request.getParameter("notice_num")
		);
		String notice_category = request.getParameter("notice_category");
		String notice_author = request.getParameter("notice_author");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		
		NoticeVO notice = new NoticeVO(
							notice_category,
							notice_author,
							notice_title,
							notice_content
						);
		notice.setNotice_num(notice_num);
		System.out.println("update : " + notice);
		return dao.noticeUpdate(notice);
	}

	@Override
	public boolean noticeDelete(HttpServletRequest request) {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		return dao.noticeDelete(notice_num);
	}
	
}











