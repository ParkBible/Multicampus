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
	Stream 개념은 java의 데이터 전송에 있어서 가장 기본이 되는 개념이다.
	1. 단위는 byte이다.
	2. 순서대로 주고 순서대로 받는다.
	3. 다 쓰고나면 반드시 close를 해야 한다!
	
*/