package n2_socket_serversocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		System.out.println("[ 서버에 연결 요청 ]");
		try {
			Socket socket = new Socket("192.168.1.113",5001);
			System.out.println("[ 서버 연결 완료 ]");
			
			OutputStream os = socket.getOutputStream();
			String message = "누가 보낸거게?";
			byte[] bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 전송 완료]");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
