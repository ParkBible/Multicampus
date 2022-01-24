import java.net.*;
import java.io.*;
import java.io.File;

public class Test211S {
	public static void main( String[] args ) throws Exception {
		ServerSocket svr = new ServerSocket(7890);
		
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			
			String l = skt.getInetAddress().toString();
			if( l.indexOf("127.0.0.1") != -1 ) {
				alive = false;
			}
			else {
				System.out.println(skt.getInetAddress().toString());
				ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());    // 이러면 반대쪽에선 input 열어준다.
				ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
				
				String r = in.readUTF();    // 클라이언트에서 보낸 걸 읽음
				
				File f = new File(r);
				boolean file_exist = f.exists();
				System.out.println(file_exist);
				if(file_exist == true){
					out.writeInt(200);
					try{
						OutputStream outFile = skt.getOutputStream();
						InputStream inFile = new FileInputStream(r);
						int len = 0;
						byte[] buf = new byte[1024*128];
						while((len = inFile.read(buf))!=-1){
							outFile.write(buf, 0, len);
							outFile.flush();    // 네트워크 상의 전송은 보낸 다음 반드시 flush() 호출
						}
						//inFile.close();
						//outFile.close();
						
					} catch(Throwable e){}
					
					
				} else{
					out.writeInt(404);
				}
				
				in.close();
				out.close();
			}
			skt.close();
		}
		svr.close();
	}
}
/*

*/