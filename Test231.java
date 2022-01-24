
import java.io.*;

public class Test231{
	public static void main(String[] args) throws IOException{
		Writer out = null;
		try{
			out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("ÇÑ");     // 1 char Àü¼Û - ¾È±úÁü
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
		System.out.println((char)r);    // ÇÑ
			
	}
}

/*
¿¬½À
	public class Test231{
	public static void main(String[] args) throws IOException{
		Writer out = new FileWriter("C:\\JavaWork\\a.txt");
		out = new FileWriter("C:\\JavaWork\\a.txt");
		out.write("ÇÑ");     // 1 char Àü¼Û - ¾È±úÁü
		out.close();
		
		Reader in = new FileReader("C:\\JavaWork\\a.txt");
		int r = in.read();
		in.close();
		System.out.println((char)r);    // ÇÑ
			
	}
}
	
*/