package f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadWriteExample {

	public static void main(String[] args) throws Exception{
		File file = new File("src/f03_input/ReadExample.java");
		InputStream is = new FileInputStream(file);
		int data;
		OutputStream os = System.out;
		while((data=is.read()) != -1) {
			os.write(data);
		}
		os.flush();
		os.close();
		is.close();
		System.out.println("끝!!");
		
	}

}







