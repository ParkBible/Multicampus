import java.net.*;

public class Test209{
	public static void main(String[] args) throws Exception{
		ServerSocket svr = new ServerSocket(7890);
		
		boolean alive = true;
		while(alive){
			Socket skt = svr.accept();
			
			String l = skt.getInetAddress().toString();
			System.out.println(l);    // Ŭ���̾�Ʈ�� ip�ּ� ���
			
			if(l.indexOf("127.0.0.1") != -1){
				alive = false;
			}
			
			skt.close();
		}
		
		svr.close();
	}
}

/*
	localtunnel : ���� IP�� ����ϴ� ��ǻ�Ϳ��� ���� ������ ������ �� �ܺο��� ���Ӱ�����
	�ͳ��� �վ��ִ� ���α׷�(�Ϲ� TCP ������ �ȵǰ� �� ������ ����)
	
	����� �������ϰ� �ٷ� ���� �ʰ�, ������ �ٽ� ��� ���·� ���ư��� �Ѵ�.
	
	skt.getInetAddress() : ������ Ŭ���̾�Ʈ�� ip�� �����Ѵ�.
	
	127.0.0.1 - �����⸦ ��ġ�� �ʰ� �� ��ǻ�Ϳ� ������ �� ���� IP
	192.168.*.* - �����⸦ ���ļ� �� ��ǻ�Ϳ� ������ �� ���� IP
	127.0.0.1�� �����ϸ� ����
*/