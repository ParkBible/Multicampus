import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

// ���� ���α׷�
public class Test194S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : ��Ʈ ��ȣ(��Ʈ��ũ ����� ���� ��ȣ)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // ������ �ö����� ��� ���. ���ԵǸ� ���� ���� �� ����.
			
			byte[] buf = new byte[]{100,101,102,103};    // 4����Ʈ ������
			
			OutputStream out = skt.getOutputStream();
			//out.write(100);
			
			out.write(buf, 0, buf.length);
			out.flush();
			out.close();    // ��Ʈ��ũ ���� ������ ���� ���� �ݵ�� flush() ȣ��
			
			skt.close();
			svr.close();
		}
		catch(Throwable e){}
	}
}

/*
	svr.accept() ���⼭ ���缭 ����ϰ� �ִ� ��Ȳ�̴�.
	ipconfig : ipv4�ּ� Ȯ��. 192.168.200.171
	
*/
