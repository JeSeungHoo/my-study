package f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			File file = new File("C:\\Temp\\file2.txt");
			is = new FileInputStream(file);
			int readByte = 0;
			while(true) {
				// byte단위로 읽어와서 읽은 값을 int로 반환
				readByte = is.read();
				System.out.println(readByte);
				// EOF End Of File == -1
				if(readByte == -1)break;
				System.out.println((char)readByte);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {}
		}
		System.out.println("read 완료");
	}

}



