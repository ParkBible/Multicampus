import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class Test192{
	public static void main(String[] args){
		long time = System.currentTimeMillis();
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\01.mp3");    // ���
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.mp3");    // ������(������ �޶� ���ÿ� �ص� ����)
			
			int len = 0;
			// buf�� ũ�⸦ �뷫������ �����ϴٺ��� ������ �ӵ��� ������ ������ �ִ�.
			byte[] buf = new byte[1024*32];
			
			// buf�� ũ�Ⱑ �Ѳ����� �а� �������� ũ��(�絿��)
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			
			out.close();
			in.close();
		}
		catch(IOException e){
		}
		System.out.println(System.currentTimeMillis() - time);
	}
}


/*
	read���� �ΰ��� �����ε��� �Լ��� �ִ�.
	int read() : �� ����Ʈ�� �о �� ������ �����Ѵ�.
	int read(byte[]) : �о byte[]�� ������ �����ϰ� ���� ����Ʈ���� �����Ѵ�.
	
	write���� �ΰ��� ���
	void write(int i) : ���� 8��Ʈ�� �����Ѵ�.
	void write(byte[] buf, int offset, int len)
	: buf ���� ������ offset���� �����ؼ� len ũ�⸸ŭ�� ����
	
	���� ���� �ӵ��� �ſ� ��������.
	
	�칰�� ���� �۳���
	1. ����������    -- ���ݾ��ۿ� ���۳���
	2. �絿�̷�
	3. �巳������    -- �ѹ��� ���� �۳��� ������ ��� �����
	
	�Ѳ����� Ǫ�� �絿���� ũ��� ȯ�濡 ���� �ٸ����� �и� ����� ������ ��ģ��.
	buf�� ũ�Ⱑ �絿���� ũ��� ������ ������ �ȴ�.
	���Ͻý����� �ڹٿ��� �����ϴ� ����� �ƴ϶� OS�� ����� ������ ����Ѵ�.(�ý��� ��)
	�� java�� �ڽ��� ��ġ�� OS�� �Ƿ��ؼ� ���Ͻý��ۿ� ���� �����ϴ�.
*/