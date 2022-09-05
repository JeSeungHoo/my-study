package f09_object.serializable;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializableOutputExample {

	public static void main(String[] args) throws Exception{
		File file = new File("person.dat");
		
		
		ObjectOutputStream oos = null;
		if(!file.exists() || file.length() == 0) {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("person.dat",true)
					)
				);
		}else {
			oos = new ObjectAppendStream(
					new BufferedOutputStream(
						new FileOutputStream("person.dat",true)
					)
				);
		}
		
		Person p = new Person();
		p.setName("이순신");
		p.setAge(500);
		oos.writeObject(p);
		
		Person p1 = new Person();
		p1.setName("최기근");
		p1.setAge(25);
		oos.writeObject(p1);
		oos.flush();
		oos.close();
	}

}






















