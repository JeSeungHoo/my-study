package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTask implements Runnable {
	
	// 현재 task에 등록된 client 정보를 저장
	Socket client;
	
	PrintWriter pw; 	// client에게 메세지를 전달할 스트림
	BufferedReader br;	// client에게 메세지를 전달 받을 스트림
	String userID;		//현재 작업의 사용자 ID
	
	// server로 부터 accept된 Client의 Socket 정보를
	// 생성자의 매개변수로 전달 받아 초기화 진행
	public ServerTask(Socket client) {
		this.client = client;
		
		try {
			//pw = new PrintWriter(기반스트림,autoFlush);
			pw = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									client.getOutputStream())),true);
			
			br = new BufferedReader(
					new InputStreamReader(client.getInputStream())
				);
			
			Runnable run = new Runnable() {
				public void run() {
					while(true) {
						System.out.println("ID 입력대기");
						try {
							// ID 입력전까지 blocking
							userID = br.readLine();
						} catch (IOException e) {}
						System.out.println(userID);
						if(userID.trim().equals("") || ChatServer.ht.containsKey(userID)) {
							// 아이디를 입력한 client에게 사용불가능한 아이디라고 출력
							pw.println("사용할 수 없는 아이디입니다. 다시 요청해주세요.");
							// server 콘솔에 잘못된 요청이 들어왔다고 출력
							System.err.println(userID+" 사용할 수 없는 아이디로 요청");
							// 아이디를 다시 입력받도록 while문으로 돌아감.
							continue;
						}
						ChatServer.ht.put(userID,pw);
						System.out.println(userID+"님이 입장하셨습니다. 방인원은 : "+ChatServer.ht.size());
						broadCast(userID+"님이 입장하셨습니다. 방인원은 : "+ChatServer.ht.size());
						ChatServer.serverPool.submit(ServerTask.this);
						break;
					}
				}
			};
			ChatServer.serverPool.submit(run);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	// client에서 출력되는 내용을 입력받는 receive 
	@Override
	public void run() {
		while(true) {
			/*
			 *   /quit -> 종료
			 *   /w 아이디 메세지 -> 귓속말
			 *   나머지는 전체메세지
			 */
			try {
				// 각 클라이언트가 전달하는 메세지를 입력받음.
				String receiveData  = br.readLine();
				if(receiveData.trim().equals("/quit")) {
					break;
				}else if(receiveData.indexOf("/w") > -1) {
					sendMsg(receiveData);
				}else {
					broadCast(userID+" : "+receiveData);
				}
			} catch (IOException e) {
				System.out.println("Client 통신 오류");
				break;
			}
		} // while 문 종료
		
		// 종료한 사용자 정보 hashtable에서 삭제
		ChatServer.ht.remove(userID);
		broadCast(userID+"님이 나가셨습니다. 방인원 : "+ChatServer.ht.size());
	}
	
	// message를 전달 받아 연결된 모든 사용자에게 메세지 전달
	public void broadCast(String message) {
		// hashtable에 저장된 values 묶음을 가지고 와서 순회하면서 출력
		for(PrintWriter p : ChatServer.ht.values()) {
			if(this.pw != p) p.println(message);
		}
		System.out.println(message);
	}
	
	// 특정 사용자에게만 메세지 전달(귓속말)
	// /w 아이디 메세지
	public void sendMsg(String message) {
		int begin = message.indexOf(" ")+1;
		int end = message.indexOf(" ",begin);
		if(end != -1) {
			String id = message.substring(begin,end);
			String msg = message.substring(end+1);
			PrintWriter pw = ChatServer.ht.get(id);
			if(pw != null) {
				// 아이디가 일치하는 사용자 존재
				pw.println(userID+"님의 귓속말 : " + msg);
			}else {
				// 일치하는 사용자 정보가 없음
				this.pw.println(id+"님이 존재하지 않습니다.");
			}
		}
	}
}







