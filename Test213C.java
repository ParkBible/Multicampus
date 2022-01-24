import java.net.*;
import java.io.*;

public class Test213C {
	public static void main( String[] args ) throws Exception {
		Socket skt = new Socket("192.168.200.171",7890);
		ObjectInputStream in = new ObjectInputStream( skt.getInputStream() );
		
		boolean alive = true;
		while( alive ) {
			String l = in.readUTF();
			System.out.println( l );
		}

		in.close();
		skt.close();
	}
}
/*
이것에 맞는 서버는 접속하고 곧바로 접속을 끊으면 안된다. 계속 열고 있어야 하고, String 을 보내야 한다.

*/