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
				ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());    // �̷��� �ݴ��ʿ��� input �����ش�.
				ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
				
				String r = in.readUTF();    // Ŭ���̾�Ʈ���� ���� �� ����
				
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
							outFile.flush();    // ��Ʈ��ũ ���� ������ ���� ���� �ݵ�� flush() ȣ��
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