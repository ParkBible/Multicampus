import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;

// ���� ���α׷�
public class Test195S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : ��Ʈ ��ȣ(��Ʈ��ũ ����� ���� ��ȣ)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // ������ �ö����� ��� ���. ���ԵǸ� ���� ���� �� ����.
	
			
			OutputStream out = skt.getOutputStream();
			InputStream in = new FileInputStream("C:\\JavaWork\\01.mp3");
			
			int len = 0;
			byte[] buf = new byte[1024*128];
			while((len = in.read(buf))!=-1){
				out.write(buf, 0, len);
				out.flush();
			}
			
			in.close();
			out.close();    // ��Ʈ��ũ ���� ������ ���� ���� �ݵ�� flush() ȣ��
			
			skt.close();
			svr.close();
		}
		catch(Throwable e){}
	}
}