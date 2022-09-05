package f06_stream_reader_writer;

import java.io.Console;

public class ConsoleExample {

	public static void main(String[] args) {
		Console console = System.console();
		System.out.println("아이디 : ");
		String id = console.readLine();
		System.out.println("비밀번호 : ");
		char[] password = console.readPassword();
		System.out.println("--------------------");
		String strPassword = new String(password);
		System.out.println(id);
		System.out.println(strPassword);
	}

}






