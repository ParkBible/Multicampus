/*
	"127.0.0.1" ���� ���� ������ �ö��� �����ϰ�� �������� �ʰ� ����ϴ� ����
*/

import java.net.*;
import java.io.*;

public class Test210S{
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
			else{
				int[] id = {10101, 10102, 10103, 10104};
				
				// �Ʒ� �ڵ�� �����Ǵ� Test210C�� �ۼ��� ������
				ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
				out.writeInt(id.length);    // ����
				
				for(int i=0; i<id.length; i++){
					out.writeInt(id[i]);
				}
				
				out.flush();
				out.close();
			}
			
			skt.close();
		}
		
		svr.close();
	}
}

