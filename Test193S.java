import java.net.ServerSocket;
import java.net.Socket;

// ���� ���α׷�
public class Test193S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : ��Ʈ ��ȣ(��Ʈ��ũ ����� ���� ��ȣ)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // ������ �ö����� ��� ���. ���ԵǸ� ���� ���� �� ����.
			
			System.out.println(skt.toString());    // ���� ���� ���� ���� ����.
			
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
