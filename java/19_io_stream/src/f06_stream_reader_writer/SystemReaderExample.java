package f06_stream_reader_writer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SystemReaderExample {

	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		int readData = 0;
		char[] cbuf = new char[100];
		System.out.println("입력대기중... ");
		while((readData = reader.read(cbuf)) != -1) {
			String data = new String(cbuf,0,readData);
			// 입력한 문자열이 quit 로 시작하면 true
			if(data.startsWith("quit")) break;
			System.out.println(data);
		}
		reader.close();
		is.close();
		System.out.println("종료");
	}

}






