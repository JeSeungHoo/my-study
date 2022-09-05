package f02_output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		String path = "C:\\Temp\\file2.txt";
		
		try {
			OutputStream os = new FileOutputStream(path,true);
			String s = "EFG";
			byte[] bytes = s.getBytes();
			/*
			for(int i=0; i<bytes.length; i++) {
				os.write(bytes[i]);
			}
			*/
//			os.write(bytes);
			os.write(bytes,1,2);
			
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}






