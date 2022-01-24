import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test188{
	public static void main(String[] args){
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\a.dat");
			int a = in.read();
			int b = in.read();
			int c = in.read();
			int d = in.read();
			
			in.close();
			
			System.out.println(a);    // 101
			System.out.println(b);    // 102
			System.out.println(c);    // 64
			System.out.println(d);    // -1
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}

/*
	OutputStream�� void write(int)�� ������
	InputStream���� int read()�� �ִ�.
	FileInputStream�� ������� write�� ������ ������� read�ϰ� �ִ�.
	�� �̻� ���� �� ���ٸ� -1�� �����Ѵ�. (187 �ڵ�� �����ؼ� ��������)
*/