import java.io.File;
import java.io.IOException;

public class Test2_2 {

	public static void main(String[] args) {
		String path = "C:\\Test\\text.txt"; 
		String dir = "C:\\Test";
		File dirFile = new File(dir);
		File file = new File(path);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
			System.out.println("디렉토리 생성 완료");
		}
		boolean isDerictory = file.isDirectory();
		System.out.println("디렉토리 인가 : "+ isDerictory);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("파일 생성 완료");
			} catch (IOException e) {}
		}
	}
}




