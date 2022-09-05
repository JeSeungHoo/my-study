package f04_writer_reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class ReaderExample {

	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("c:\\Temp\\data.txt");
			int readData;
			/*
			while(true) {
				readData = reader.read();
				if(readData == -1)break;
				System.out.print((char)readData);
			}
			*/
			char[] cBuf = new char[100];
			while((readData = reader.read(cBuf)) != -1) {
				System.out.println(readData);
				System.out.println(Arrays.toString(cBuf));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
