import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test1_3 {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("test.txt");
			Object o = new Object();
			Object o1 = new Object();
			o.equals(o1);
			is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
