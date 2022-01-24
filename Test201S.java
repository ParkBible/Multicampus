import java.io.*;
import java.net.*;

public class Test201S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);
			Socket skt = svr.accept();
			
			ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
			
			out.writeInt(2323232);
			out.writeDouble(3.141692);
			out.flush();
			
			out.close();
			
			skt.close();
			svr.close();
		}
		catch(Throwable e) {e.printStackTrace();}
	}
}

/*
	Decorator 패턴에 대한 이해를 바탕으로
	java.io 패키지에서 제공하는 다양한 Decorator 역할 클래스를 Socket에 응용하는 예.
	
	public ObjectOutputStream(OutputStream out) throws IOException
	-- FileOutputStream이 아니더라도 OutputStream으로 상속받았으면 생성자에 넣을 수 있다.
	
*/