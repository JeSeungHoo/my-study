import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test2_3 {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Test\\test.txt");
			FileOutputStream fos = new FileOutputStream(file);
			String name = "최기근";
			fos.write(name.getBytes());
			fos.flush();
			fos.close();
			
			Writer writer = new FileWriter(file,true);
			writer.write("박주신");
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}










