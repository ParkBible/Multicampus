import java.io.*;

public class Test233{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:\\JavaWork\\2001.smi"));
		PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaWork\\2001b.smi"));
		
		String r = null;
		while((r=in.readLine())!=null){
			// String r = in.readLine;
			out.println(r);
		}
		
		out.close();
		in.close();
	}
}

/*
	���ڵ��� UTF�� ���־ ���� ������ ������ �뷮�� ���� ���̰� ���ٰ� �Ѵ�.
*/