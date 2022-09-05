package f09_object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectStreamExample {

	public static void main(String[] args) {
		// try with resources 절
		try(
				FileInputStream fis = new FileInputStream("object.dat");
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				FileOutputStream fos = new FileOutputStream("object.dat");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				
			){
			oos.writeObject(new Integer(100));
			oos.writeObject(new Double(3.14));
			oos.writeObject(new int[] {1,2,3,4});
			oos.writeObject(new String("최기근"));
			oos.flush();
			
			Integer obj1 = (Integer)ois.readObject();
			Double obj2 = (Double)ois.readObject();
			int[] obj3 = (int[])ois.readObject();
			String obj4 = (String)ois.readObject();
			
			System.out.println(obj1);
			System.out.println(obj2);
			System.out.println(Arrays.toString(obj3));
			System.out.println(obj4);
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

