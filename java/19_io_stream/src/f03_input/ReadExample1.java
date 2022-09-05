package f03_input;

import java.io.*;

public class ReadExample1 {

	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("C:\\Temp\\file2.txt");
		int readBytes = 0;
		byte[] bytes = new byte[100];
		String data = "";
		while(true) {
			readBytes = is.read(bytes);
			System.out.println("읽어들인 바이트 크기 : "+readBytes);
			if(readBytes == -1) break;
			data += new String(bytes);
		}
		System.out.println(data);
		is.close();
	}

}










