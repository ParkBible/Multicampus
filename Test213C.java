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
�̰Ϳ� �´� ������ �����ϰ� ��ٷ� ������ ������ �ȵȴ�. ��� ���� �־�� �ϰ�, String �� ������ �Ѵ�.

*/