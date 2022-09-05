package n4_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerExample {

	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket 
									= new DatagramSocket(5001);
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							DatagramPacket packet 
								= new DatagramPacket(new byte[100],100);
							datagramSocket.receive(packet);
							String data = new String(packet.getData(),0,packet.getLength());
							System.out.println("[받은 내용 : ] "+data);
						} catch (IOException e) {
							System.out.println("수신 종료");
						}
					}
				}
			});
			t.start();
			Thread.sleep(30000);
			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

















