import java.net.*;
import java.io.*;

public class Test228C{
	public static void main(String[] args) throws Exception{
		long time = System.currentTimeMillis();
		Socket skt = new Socket("192.168.200.171", 7890);
		
		InputStream in = skt.getInputStream();
		
		// args[0] : 실행 할때 뒤에 씀 (java Test228C banana)
		OutputStream fout = new FileOutputStream("C:\\JavaWork\\" + args[0] + "01d.zip");  
		
		int len = 0;
		byte[] buf = new byte[1024*64];
		
		while((len=in.read(buf)) != -1){
			fout.write(buf, 0, len);
		}
		
		fout.close();
		in.close();
		
		skt.close();
		
		System.out.println(System.currentTimeMillis() - time);
	}
}

/*
	3개 클라이언트가 거의 동시에 들어왔는데,,,
	
	기본적으로 쓰레드를 고려하지 않고 서버를 쓰면 이런 일이 벌어진다.
	동영상을 빨리 다운받는 경우와 느리게 다운받는 경우 시간당 CPU 소모량은 거의 같다.
	
	네트워크 응용 프로그램을 만들 때 성능향상의 최고 기법은? 가까이에 서버를 두는거다.
	
	일단 서버를 사용자들이 많이 있는 곳 근처로 옮기고
	그 다음에는 쓰레드를 도입하는 것이 중요하다.
	쓰레드를 도입하면, 앞에서 다운 받는 동안 우회하여 다른 쓰레드에 의해 다운받을 수 있다.
	
	쓰레드의 개수는 동시 접속자 인원만큼 있으면 적절할 듯 하다.
*/