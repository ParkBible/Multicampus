import java.io.*;

public class Test233{
	public static void main(String[] args) throws IOException{
		Write out = new OutputStreamWriter(new FileOutputStream("C:\\JavaWork\\c.txt"));
		out.write("��");
		out.close();
		
		// inputstream�� ����Ʈ ����, reader�� char �����̴�.
		// ĳ���� ������ �о��µ� ����å(c.txt)�� ����Ʈ ������ �����Ѵ�.
		// �̰� �ٲ���� �ؼ� inputstreamreader �� ����.
		Reader in = new InputStreamReader(new FileInputStream("C:\\JavaWork\\c.txt"));
		char r = (char)in.read();
		in.close();
		System.out.println(r);
	}
}
/*
	out.write(10000);   -- 1 char ��������. 1 byte�ƴϰ�
	OutputStreamWriter(OutputStream out)
	Writer�� �ڼ��ε� �����ڿ� OutputStream??
	
	����� new FileOutputStream("C:\\JavaWork\\c.txt") �ε� 1 char�� ��������?
	
	OutputStreamWriter : char ������� byte ��������� �ٲٴ� ������ �����(220V > 110V)
	InputStreamReader : byte ���� �Է��� char ���� �Է����� �ٲٴ� �����.
*/