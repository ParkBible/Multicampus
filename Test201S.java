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
	Decorator ���Ͽ� ���� ���ظ� ��������
	java.io ��Ű������ �����ϴ� �پ��� Decorator ���� Ŭ������ Socket�� �����ϴ� ��.
	
	public ObjectOutputStream(OutputStream out) throws IOException
	-- FileOutputStream�� �ƴϴ��� OutputStream���� ��ӹ޾����� �����ڿ� ���� �� �ִ�.
	
*/