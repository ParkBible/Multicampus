import java.net.*;
import java.io.*;

public class Test211C {
	public static void main( String[] args ) throws Exception {
		Socket skt = new Socket("192.168.200.171",7890);
		
		ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
		
		String l = "C:\\MP3\\01.mp3";
		
		out.writeUTF(l);    // ������ l�� ������
		out.flush();    // �ϴ� write ������ flush�� ���ش�.
		int r = in.readInt();    
		System.out.println(r);
		
		if(r == 200){
			try{
				InputStream inFile = skt.getInputStream();
				OutputStream outFile = new FileOutputStream("C:\\JavaWork\\down_A.mp3");
				
				int len = 0;
				byte[] buf = new byte[1024*128];
				
				while((len=inFile.read(buf))!=-1){
					outFile.write(buf, 0, len);
				}
				//outFile.close();
				//inFile.close();
				
			} catch(Throwable e) {e.printStackTrace();}
			
		}
		
		out.close();
		in.close();
		skt.close();
	}
}

//	ipconfig
//	Ŭ���̾�Ʈ���� ���� �̸��� ������(writeUTF) �ش� ������ �̸��� ������ �ִ� �������� Ȯ���Ѵ�.
//  ������ ������ ������ Ŭ���̾�Ʈ�� 200�� ������ ������ 404�� ������.
//  404�� ��, 200�̸� Ŭ���̾�Ʈ�� �ٿ��� �ް� �Ѵ�.