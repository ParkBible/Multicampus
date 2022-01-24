
import java.io.*;

public class Test229{
	public static void main(String[] args) throws IOException{
		try{
			Writer out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("한");     // 1 char 전송 - 안깨짐
			out.close();
			
			Reader in = new FileReader("C:\\JavaWork\\a.txt");
			int r = in.read();
			in.close();
			
			System.out.println(r);    // 54620
			System.out.println((char)r);    // 한
		}
		catch(IOException e){}
	}
}

/*
	try catch 문 안 쓰고 throws에 명시해 주는 것만으로도 문법 에러는 아니다.
	발생할 수 있는 에러를 명시해주기만 해도 try catch안써도 문법에러는 아니지만,,, 권장되지는 않는다.
	에러가 발생하면 그냥 바로 죽기 때문. 여기선 메인에 해놨으니까 에러 나면 메인이 바로 죽는다.
	
	out.write("한"); 해주고
	cmd에서 type a.txt
	
	InputStream / OutputStream 은 byte 단위로 전송한다.
	근데 문자는 char(2바이트)를 쓴다. 그래서 초기 java에서 특히 문자를 전송하면 다 깨진다.
	이를 해결하고자 문자 데이터 전송에 특화되어 char 단위의 전송을 지원하는 Writer / Reader가 생겼다.
	데코레이터 패턴으로 만들어진 것은 똑같다.
*/