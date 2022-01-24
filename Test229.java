
import java.io.*;

public class Test229{
	public static void main(String[] args) throws IOException{
		try{
			Writer out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("��");     // 1 char ���� - �ȱ���
			out.close();
			
			Reader in = new FileReader("C:\\JavaWork\\a.txt");
			int r = in.read();
			in.close();
			
			System.out.println(r);    // 54620
			System.out.println((char)r);    // ��
		}
		catch(IOException e){}
	}
}

/*
	try catch �� �� ���� throws�� ����� �ִ� �͸����ε� ���� ������ �ƴϴ�.
	�߻��� �� �ִ� ������ ������ֱ⸸ �ص� try catch�Ƚᵵ ���������� �ƴ�����,,, ��������� �ʴ´�.
	������ �߻��ϸ� �׳� �ٷ� �ױ� ����. ���⼱ ���ο� �س����ϱ� ���� ���� ������ �ٷ� �״´�.
	
	out.write("��"); ���ְ�
	cmd���� type a.txt
	
	InputStream / OutputStream �� byte ������ �����Ѵ�.
	�ٵ� ���ڴ� char(2����Ʈ)�� ����. �׷��� �ʱ� java���� Ư�� ���ڸ� �����ϸ� �� ������.
	�̸� �ذ��ϰ��� ���� ������ ���ۿ� Ưȭ�Ǿ� char ������ ������ �����ϴ� Writer / Reader�� �����.
	���ڷ����� �������� ������� ���� �Ȱ���.
*/