import java.net.Socket;
import java.io.InputStream;

// Ŭ���̾�Ʈ ���α׷�
public class Test194C{
	public static void main(String[] args){
		try{
			// ���� ���α׷��� Socket skt = svr.accept(); �� ������ �ν��Ͻ��̴�.
			// ���� ���ư��� ������ ���α׷��� �޸𸮸� ������ �� ����.
			Socket skt = new Socket("192.168.200.171", 7890);    // ���� ����. ã�ư��� ���ӽõ�
			
			InputStream in = skt.getInputStream();
			// int r = in.read();    // 1����Ʈ �о���϶� ��
			
			byte[] buf = new byte[4];    // 4����Ʈ �о���δ�.
			int len = in.read(buf);
			
			in.close();
			
			for(int i=0; i<len; i++){
				System.out.println(buf[i]);
			}
			
			//System.out.println(r);
			skt.close();
		}
		catch(Throwable e) {e.printStackTrace();}
	}
}

/*
	�������� �����ϴ� �����͸� �޾Ƶ���.
	
	���ε� & �ٿ�ε� ���� : ������ ���� ������ �������� �����ϰ�, Ŭ���̾�Ʈ�� ������ ���� �� ���� ���Ϸ� �����Ѵ�.
*/