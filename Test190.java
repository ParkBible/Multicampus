import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class Test190{
	public static void main(String[] args){
		try{
			OutputStream out = new FileOutputStream("C:\\JavaWork\\b.dat");
			out.write(100);
			out.write(101);
			out.write(102);
			out.close();
			
			InputStream in = new FileInputStream("C:\\JavaWork\\b.dat");
			for(int i=0; i<4; i++){
				int r = in.read();
				System.out.println(r);
			}
			in.close();
		}
		catch(IOException e){
		}
	}
}

/*
	Stream ������ java�� ������ ���ۿ� �־ ���� �⺻�� �Ǵ� �����̴�.
	1. ������ byte�̴�.
	2. ������� �ְ� ������� �޴´�.
	3. �� ������ �ݵ�� close�� �ؾ� �Ѵ�!
	
*/