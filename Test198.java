import java.io.*;

public class Test198 {
	public static void main(String[] args){
		int i = 2342698;
		try{
			OutputStream out = new FileOutputStream("C:\\JavaWork\\c.dat");
			out.write(i);
			out.write(i >>> 8);
			out.write(i >>> 16);
			out.write(i >>> 24);    // �������� ������ �ѹ���Ʈ�� �ڷ� �����.
			out.close();
			
			InputStream in = new FileInputStream("C:\\JavaWork\\c.dat");
			int a = in.read();
			int b = in.read();
			int c = in.read();
			int d = in.read();
			in.close();
			
			// ��ȣ ���ϴϱ� 0����.. ��Ʈ�����ں��� ���� �켱������ ���� �� ����.
			System.out.println(a + (b<<8) + (c<<16) + (d<<24));    
			}
		catch(IOException e) {}	
	}
}

/*
	import java.io.*;
	�ش� ��Ű���� ���� ��� Ŭ������ ����Ʈ. ���������� ���� ���� : Ŭ���� �̸��� ��ġ�� ��å����.
	
	������ c�� �Ǿ������� �̷������� ����Ʈ������ ������ ¥�ߵȴ�.
	
	Ŭ���̾�Ʈ�� c�̰� ������ java�� ��� �̷��� ������ ¥ �ִ� ��찡 ������,
	C�� �ü���� ���� C�� int�� java int�� ȣȯ�� �ȵ� ��찡 �ִ�.
	Ŭ���̾�Ʈ �� ȯ���� ��Ʋ�ε���̳� ���ε���̳Ŀ� ���� �� �ڵ尡 �޶��� ���� �ִ�.
*/