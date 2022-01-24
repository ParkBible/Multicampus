
import java.io.*;

public class Test231{
	public static void main(String[] args) throws IOException{
		Writer out = null;
		try{
			out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("��");     // 1 char ���� - �ȱ���
		}
		catch(IOException e){
			throw e;
		}
		finally{
			if(out!=null){
				out.close();
			}
		}
		
		Reader in = new FileReader("C:\\JavaWork\\a.txt");
		int r = in.read();
		in.close();
		System.out.println((char)r);    // ��
			
	}
}

/*
����
	public class Test231{
	public static void main(String[] args) throws IOException{
		Writer out = new FileWriter("C:\\JavaWork\\a.txt");
		out = new FileWriter("C:\\JavaWork\\a.txt");
		out.write("��");     // 1 char ���� - �ȱ���
		out.close();
		
		Reader in = new FileReader("C:\\JavaWork\\a.txt");
		int r = in.read();
		in.close();
		System.out.println((char)r);    // ��
			
	}
}
	
*/