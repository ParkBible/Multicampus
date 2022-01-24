import java.net.*;
import java.io.*;

public class Test211C {
	public static void main( String[] args ) throws Exception {
		Socket skt = new Socket("192.168.200.171",7890);
		
		ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
		
		String l = "C:\\MP3\\01.mp3";
		
		out.writeUTF(l);    // 서버에 l을 보낸다
		out.flush();    // 일단 write 했으면 flush를 해준다.
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
//	클라이언트에서 파일 이름을 보내면(writeUTF) 해당 파일의 이름이 실제로 있는 파일인지 확인한다.
//  파일이 있으면 서버는 클라이언트에 200을 보내고 없으면 404를 보낸다.
//  404면 끝, 200이면 클라이언트는 다운을 받게 한다.