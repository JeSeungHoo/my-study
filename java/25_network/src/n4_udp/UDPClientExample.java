package n4_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClientExample {

	public static void main(String[] args) {
		
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			for(int i=1; i < 4; i++) {
				String message = "message - " + i;
				byte[] bytes = message.getBytes();
				DatagramPacket datagramPacket 
								= new DatagramPacket(
										bytes,			// 전달할 데이터
										bytes.length,	// 전달할 데이터 크기
										// 전달할 위치
									new InetSocketAddress("192.168.1.113",5001)
								);
				datagramSocket.send(datagramPacket);
				System.out.println("[보낸 바이트 수 ] "+bytes.length);
			}
			System.out.println("[발신 완료]");
			datagramSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}







