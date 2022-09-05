package guide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	
	static File file;
	
	static {
		// 정적 멤버 실행 블럭
		// class 설계 정보가 메모리에 등록된 후 즉시 실행
		try {
			file = new File("member.dat");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getPath());
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("member.dat 파일 생성 완료");
			}
		} catch (IOException e) {
			System.out.println("파일 생성 실패 : " + e.getMessage());
		}
	}
	
	// 파일에서 회원 목록 정보 가져오기
	@SuppressWarnings("unchecked")
	public static List<Member> getList(){
		if(!file.exists() || file.length() == 0) {
			System.out.println("등록된 회원 정보가 없습니다.");
			return null;
		}
		List<Member> memberList = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			memberList = (ArrayList<Member>)ois.readObject();
			ois.close();
			fis.close();
		}catch(Exception e) {}
		return memberList;
	}
	
	// 회원정보 파일에 저장
	public static void setList(List<Member> list) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {}
	}
}






