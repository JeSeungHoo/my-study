package n3_chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ChatServerExample {
	
	ServerSocket serverSocket;
	
	static List<Client> clients = new Vector<>();
	
	public ChatServerExample(){
		startServer();
	}
	
	// server 포트를 할당받아 시작하고
	// client의 연결을 담당
	public void startServer() {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(
				new InetSocketAddress("192.168.1.113",5002)
			);
			System.out.println("[Server Open ]"+serverSocket.getLocalSocketAddress());
		} catch (IOException e) {}
		while(true) {
			try {
				System.out.println("[ Client 연결 대기중....]");
				Socket client = serverSocket.accept();
				InetSocketAddress isa 
					= (InetSocketAddress)client.getRemoteSocketAddress();
				String host = isa.getHostName();
				System.out.println("[연결수락 : "+host+"]");
				clients.add(new Client(client));
				System.out.println("연결된 클라이언트 수 : " + clients.size());
			} catch (IOException e) {
				System.out.println("서버 종료 : " + e.getMessage());
				stopServer();
				break;
			}
		}
	}
	
	// server가 안전하게 종료될 수 있도록 자원해제
	public void stopServer() {
		System.out.println("서버 종료");
		try {
			for(Client client : clients) {
				if(!client.socket.isClosed()) {
					client.socket.close();
				}
			}
			// serverSocket 닫기
			if(!serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {}
	}
	

	public static void main(String[] args) {
		new ChatServerExample();
	}

}


