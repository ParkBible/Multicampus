import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;

// Ŭ���̾�Ʈ ���α׷�
public class Test195C{
	public static void main(String[] args){
		try{
			// ���� ���α׷��� Socket skt = svr.accept(); �� ������ �ν��Ͻ��̴�.
			// ���� ���ư��� ������ ���α׷��� �޸𸮸� ������ �� ����.
			Socket skt = new Socket("192.168.200.171", 7890);    // ���� ����. ã�ư��� ���ӽõ�
			
			InputStream in = skt.getInputStream();
			OutputStream out = new FileOutputStream("C:\\JavaWork\\down.mp3");
			
			int len = 0;
			byte[] buf = new byte[1024*128];
			
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			
			out.close();
			in.close();
			
			skt.close();
		}
		catch(Throwable e) {e.printStackTrace();}
	}
}

/*
	�������� �����ϴ� �����͸� �޾Ƶ���.
	
	���ε� & �ٿ�ε� ���� : ������ ���� ������ �������� �����ϰ�, Ŭ���̾�Ʈ�� ������ ���� �� ���� ���Ϸ� �����Ѵ�.
*/