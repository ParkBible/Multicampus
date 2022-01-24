
import java.io.*;

public class Test230{
	public static void main(String[] args) throws IOException{
		Writer out = null;
		try{
			out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("��");     // 1 char ���� - �ȱ���

		}
		catch(IOException e){
			throw e;    // �ؿ��� ������ ��ұ� ������ ������ ������ �ȳ����� �𸣹Ƿ� ������ ���� �α׸� ����Ѵ�.
		}
		finally{
			// null ���� �Լ��� ȣ���ϸ� NullPointerException ������ ���.
			if(out!=null){
				out.close();
			}
			System.out.println("finally");    // ������ ���� �ȳ��� ������ ���.
		}
		
		Reader in = null;
		try{
			in = new FileReader("C:\\JavaWork\\a.txt");
			int r = in.read();
			System.out.println((char)r);    // ��
		}
		catch(IOException e){
			throw e;
		}
		finally{
			if(in!=null){
				in.close();
			}
			System.out.println("finally");
		}
			
	}
}

/*
	close()�� �ݵ�� ȣ��Ǿ�� �Ѵ�.(������ ����)
	finally�� ������ ���� ���� ������ ����ȴ�.
	{} �ȿ��� ����� ������ {} �ȿ����ۿ� ������.(�ڹ�Ư¡)
	�׷��� �ۿ��� �����ϰ� �ȿ��� ���Ը� ���ִ� ������ ���°� ����.
	
	java.lang.NullPointerException
	
*/