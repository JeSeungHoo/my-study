package GUIDE_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	
	static File file;
	
	static {
		try {
			file = new File("book2.dat");
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 책정보 추가
	public static void addBook(Book book) {
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			ObjectOutputStream oos = null;
			if(file.length() > 0) {
				oos = new ObjectOutputStream(fos) {
					@Override
					protected void writeStreamHeader() throws IOException {
						// do nothing
					}
				};
			}else {
				oos = new ObjectOutputStream(fos);
			}
			oos.writeObject(book);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {}
	}
	
	// 책정보 수정
	public static void updateBook(Book book){
		List<Book> list = getBookList();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getNum() == book.getNum()) {
				list.set(i, book);
				break;
			}
		}
		setBookList(list);
	}
	
	// 책정보 삭제
	public static void deleteBook(Book book){
		List<Book> list = getBookList();
		list.remove(book);
		setBookList(list);
	}
	
	// 책목록 불러오기
	public static List<Book> getBookList(){
		if(!file.exists() || file.length() == 0) {
			return new ArrayList<>();
		}
		List<Book> books = new ArrayList<>();
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			){
			while(true) {
				Book book = (Book)ois.readObject();
				books.add(book);
			}
		} catch (Exception e) {}
		return books;
	}
	
	// 책정보 저장하기
	private static void setBookList(List<Book> bookList){
		try (FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			for(Book b : bookList) {
				oos.writeObject(b);
			}
			oos.flush();
		} catch (Exception e) {}
	}
}










