
import java.io.*;

public class Test230{
	public static void main(String[] args) throws IOException{
		Writer out = null;
		try{
			out = new FileWriter("C:\\JavaWork\\a.txt");
			out.write("한");     // 1 char 전송 - 안깨짐

		}
		catch(IOException e){
			throw e;    // 밑에서 에러를 잡았기 때문에 에러가 났는지 안났는지 모르므로 에러가 나면 로그를 출력한다.
		}
		finally{
			// null 값이 함수를 호출하면 NullPointerException 오류가 뜬다.
			if(out!=null){
				out.close();
			}
			System.out.println("finally");    // 에러가 나든 안나든 무조건 출력.
		}
		
		Reader in = null;
		try{
			in = new FileReader("C:\\JavaWork\\a.txt");
			int r = in.read();
			System.out.println((char)r);    // 한
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
	close()는 반드시 호출되어야 한다.(에러가 나도)
	finally는 에러가 나건 말건 무조건 실행된다.
	{} 안에서 선언된 변수는 {} 안에서밖에 못쓴다.(자바특징)
	그래서 밖에서 선언하고 안에서 대입만 해주는 식으로 쓰는게 보통.
	
	java.lang.NullPointerException
	
*/