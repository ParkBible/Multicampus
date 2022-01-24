import java.io.*;
import java.net.*;

public class Test201C{
	public static void main(String[] args){
		try{
			Socket skt = new Socket("192.168.200.171", 7890);
			
			ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
			int r = in.readInt();
			double d = in.readDouble();
			in.close();
			
			System.out.println(r);
			System.out.println(d);
			
			// Test201S.java와 연동되도록 나머지 코드를 짜넣으세요.
			skt.close();
		}
		catch(Throwable e){e.printStackTrace();}
	}
}