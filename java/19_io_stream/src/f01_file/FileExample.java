package f01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {
		String dir = "C:/Temp/dir/aaa";
		dir = "C:\\Temp\\dir\\aaa";
		String fileName = "text.java";
		
		String separator = File.separator;
		System.out.println(separator);
		dir = "C:"+separator+"Temp"+separator+"dir"+separator+"aaa";
		System.out.println(dir);
		
		File file = new File(dir);
		// file.exists()
		// 해당 위치에 폴더나 파일이 존재하면 true
		// 존재하지 않으면 false
		if(!file.exists()) {
			// 디렉토리가 존재하지 않음
			System.out.println("디렉토리 존재하지 않음");
			// 경로에 있는 디렉토리 중 마지막에 정의된 디렉토리만 생성
//			boolean isMake = file.mkdir();
			// 경로 상에 정의된 모든 디렉토리를 생성
			boolean isMake = file.mkdirs();
			System.out.println("디렉토리 생성 여부 : "+isMake);
		}
		file = new File(dir,fileName);
		if(file.exists() == false) {
			System.out.println("파일이 존재하지 않음");
			try {
				// 파일 생성
				file.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : "+e.getMessage());
			}
		}
		
		File file1 = new File("C:\\Temp\\file1.txt");
		if(!file1.exists()) {
			// alt + s + w - 예외 처리 블럭 생성
			try {
				boolean isMake = file1.createNewFile();
				System.out.println("파일생성 여부 : " + isMake);
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : " + e.getMessage());
			}
		}
		String path = file1.getAbsolutePath();
		System.out.println("file1 의 절대 경로 : " + path);
		File temp = new File("C:\\Temp");
		File[] temps = temp.listFiles();
		System.out.println(temps.length);
		
		SimpleDateFormat sdf
		= new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		for(File f : temps) {
			// 폴더나 파일의 마지막 수정 시간
			long modified = f.lastModified();
			// java.util.Date
			Date date = new Date(modified);
			String lastModified = sdf.format(date);
			System.out.print(lastModified);
			// 디렉토리면 true 아니면 false
			if(f.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t"+f.getName());
			}else {
				System.out.println("\t<FILE>\t\t\t"+f.getName());
			}
		} // for문 종료
		
		// 디렉토리 파일 삭제
		File file2 = new File("C:\\Temp\\dir\\aaa\\text.java"); //
		boolean isDeleted = false;
		isDeleted = file2.delete();
		System.out.println("파일 삭제 여부 : " + isDeleted);
		
		file2 = new File("C:\\Temp\\dir\\aaa");
		file2.delete();
		System.out.println("디렉토리 삭제 여부 : " + isDeleted);
	} // main 종료

}





