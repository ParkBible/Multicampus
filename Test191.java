import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class Test191{
	public static void main(String[] args){
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\01.mp3");    // ���
			OutputStream out = new FileOutputStream("C:\\JavaWork\\01a.mp3");    // ������(������ �޶� ���ÿ� �ص� ����)
			
			int r = 0;
			while((r=in.read())!=-1){
				out.write(r);
			}
			
			out.close();
			in.close();
		}
		catch(IOException e){
		}
	}
}

/*
OutputStream out = new FileOutputStream("C:\\JavaWork\\b.dat");
			out.write(100);
			out.write(101);
			out.write(102);
			out.close();
			������ �����ϴ� ���α׷��� �Ǿ���. �ѹ���Ʈ �а� ���� �ƴϸ� ����.
			
			dir *.mp3
			
	�ٵ� �� ������.
	read���� �ΰ��� �����ε��� �Լ��� �ִ�.
	int read() : �� ����Ʈ�� �о �� ������ �����Ѵ�.
	int read(byte[]) : �о byte[]�� ������ �����ϰ� ���� ����Ʈ���� �����Ѵ�.
	
	write���� �ΰ��� ���
	void write(int i) : ���� 8��Ʈ�� �����Ѵ�.
	void write(byte[] buf, int offset, int len)
	: buf ���� ������ offset���� �����ؼ� len ũ�⸸ŭ�� ����
	
*/