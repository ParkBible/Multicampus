import java.io.*;

public class Test235{
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new FileReader("C:\\JavaWork\\2001.smi"));
		
		// InputStreamReader : ���� �а� ���� ���� ���ڵ� ����
		BufferedReader in = new BufferedReader( new InputStreamReader(new FileInputStream("C:\\JavaWork\\2001.smi"),"utf-8"));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\JavaWork\\2001c.smi"),"utf-8"));
		
		String r = null;
		while((r=in.readLine())!=null){
			// String r = in.readLine;
			System.out.println(r);
			out.println(r);
		}
		out.close();
		in.close();
	}
}

/*
	������ ����: java�� �����ڵ带 ����
	��� ���� �� ���ڰ� ���� �߰��� �� �ִ� �������� ����ü���� utf-8.
	�̰ɷ� ���ڵ��� �� �׳� ������ ������.
	�ٵ� 2001c.smi�� type���� ������ ������.(��� ����, Ư����ȣ �̷��� �ƴϸ� �����ٰ� ��)
*/