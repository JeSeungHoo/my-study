package GUIDE_2;

import java.util.Collections;

public class BookManagement  extends AppBase{
	
	// 프로그램 종료
	public void terminate() {
		this.isRun = false;
		System.out.println("프로그램 종료");
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		String title = getData("등록할 도서의 제목을 입력해 주세요 >");
		String author = getData("등록할 도서의 저자를 입력해 주세요 >");
		
		Book book = new Book(++count,title,author,System.currentTimeMillis());
		if(bookList.contains(book)){
			System.out.println("동일 제목의 도서가 존재합니다.");
			return;
		}
		
		bookList = FileHelper.getBookList();
		if(!bookList.isEmpty()) {
			Collections.sort(bookList);
			count = bookList.get(bookList.size()-1).getNum();
			count++;
			book.setNum(count);
		}
		
		FileHelper.addBook(book);
		System.out.println("등록완료");
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(Book book : FileHelper.getBookList()) {
			System.out.println(book);
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		int bookNum = getNum("수정 하실 책의 관리번호를 입력해주세요.");
		bookList = FileHelper.getBookList();
		Book book = findBook(bookNum);
		if(book == null) {
			System.out.println("입력하신 번호의 책이 존재하지 않습니다.");
			return;
		}
		
		System.out.println(book);
		
		boolean isUpdate = true;
		while(isUpdate) {
			System.out.println("=============================");
			System.out.println("1.제목수정| 2.저자수정 | 3.수정완료");
			System.out.println("=============================");
			selectNo = getNum("번호 입력 > ");
			switch(selectNo) {
				case 1:
					System.out.println("제목수정");
					String title = getData("제목 입력 > ");
					book.setTitle(title);
					System.out.println("제목 수정 완료");
					break;
				case 2:
					System.out.println("저자수정");
					String author = getData("저자 입력>");
					book.setAuthor(author);
					System.out.println("저자 수정 완료");
					break;
				case 3:
					System.out.println("수정완료");
					isUpdate = false;
					FileHelper.updateBook(book);
					break;
				default :
					System.out.println("등록된 메뉴가 아닙니다.");
			}
		}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		int bookNum = getNum("삭제할 도서의 관리번호를 입력해주세요.");
		bookList = FileHelper.getBookList();
		Book book = findBook(bookNum);
		if(book == null) {
			System.out.println("입력하신 관리번호의 책이 존재하지 않습니다.");
			return;
		}
		FileHelper.deleteBook(book);
		System.out.println("삭제완료");
	}
	
	public static void main(String[] args) {
		new BookManagement();
	}

}




