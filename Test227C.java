import java.net.*;
import java.io.*;

public class Test227C{
	public static void main(String[] args) throws Exception{
		long time = System.currentTimeMillis();
		Socket skt = new Socket("192.168.200.171", 7890);
		
		InputStream in = skt.getInputStream();
		OutputStream fout = new FileOutputStream("C:\\JavaWork\\01d.zip");
		int len = 0;
		byte[] buf = new byte[1024*64];
		
		while((len=in.read(buf)) != -1){
			fout.write(buf, 0, len);
		}
		
		fout.close();
		in.close();
		
		skt.close();
		
		System.out.println(System.currentTimeMillis() - time);
	}
}

/*
	3�� Ŭ���̾�Ʈ�� ���� ���ÿ� ���Դµ�,,,
	
	�⺻������ �����带 ������� �ʰ� ������ ���� �̷� ���� ��������.
	�������� ���� �ٿ�޴� ���� ������ �ٿ�޴� ��� �ð��� CPU �Ҹ��� ���� ����.
	
	��Ʈ��ũ ���� ���α׷��� ���� �� ��������� �ְ� �����? �����̿� ������ �δ°Ŵ�.
	
	�ϴ� ������ ����ڵ��� ���� �ִ� �� ��ó�� �ű��
	�� �������� �����带 �����ϴ� ���� �߿��ϴ�.
	�����带 �����ϸ�, �տ��� �ٿ� �޴� ���� ��ȸ�Ͽ� �ٸ� �����忡 ���� �ٿ���� �� �ִ�.
*/