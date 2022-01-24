import java.net.*;
import java.io.*;


public class Test210C{
	public static void main(String[] args) throws Exception{
		Socket skt = new Socket("192.168.200.171", 7890);
		ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
		int len = in.readInt();
		
		for(int i=0; i<len; i++){
			int a = in.readInt();
			System.out.println(a);
		}
		
		in.close();
		skt.close();
		
		System.out.println(len);
		
	}
}

/*
	192.168.200.171
	
	명단을 몇개 보낼지 어떻게 알 수 있을까? : 서버에서 몇 개 보낼건지 미리 말해준다.
	
*/