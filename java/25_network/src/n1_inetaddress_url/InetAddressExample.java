package n1_inetaddress_url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			// 내컴퓨터 아이피 주소
			System.out.println(address.getHostAddress());
			
			// naver 아이피 주소 확인
			InetAddress[] iar = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iar) {
				System.out.println("naver.com  IP 주소 : "+remote.getHostAddress());
			}
			
			URL url = new URL("https://www.hanatour.com/");
			
			try {
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr); 
				
				File file = new File("hanatour.html");
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				String isLine = "";
				while((isLine = br.readLine()) != null) {
					bw.write(isLine);
					bw.newLine();
				}
				bw.flush();
				bw.close();
				br.close();
				System.out.println("끝");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}





