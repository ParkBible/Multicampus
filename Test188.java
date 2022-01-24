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
	OutputStream에 void write(int)가 있으면
	InputStream에는 int read()가 있다.
	FileInputStream은 순서대로 write된 내용을 순서대로 read하고 있다.
	더 이상 읽을 게 없다면 -1을 리턴한다. (187 코드와 연동해서 이해하자)
*/