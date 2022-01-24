import java.io.*;

public class Test198 {
	public static void main(String[] args){
		int i = 2342698;
		try{
			OutputStream out = new FileOutputStream("C:\\JavaWork\\c.dat");
			out.write(i);
			out.write(i >>> 8);
			out.write(i >>> 16);
			out.write(i >>> 24);    // 조각으로 나눠서 한바이트씩 뒤로 땡긴다.
			out.close();
			
			InputStream in = new FileInputStream("C:\\JavaWork\\c.dat");
			int a = in.read();
			int b = in.read();
			int c = in.read();
			int d = in.read();
			in.close();
			
			// 괄호 안하니까 0나옴.. 비트연산자보다 덧셈 우선순위가 높은 것 같다.
			System.out.println(a + (b<<8) + (c<<16) + (d<<24));    
			}
		catch(IOException e) {}	
	}
}

/*
	import java.io.*;
	해당 패키지에 속한 모든 클래스를 임포트. 실전에서는 절대 비추 : 클래스 이름이 겹치면 대책없다.
	
	서버가 c로 되어있으면 이런식으로 바이트단위로 나눠서 짜야된다.
	
	클라이언트가 c이고 서버가 java인 경우 이렇게 일일이 짜 주는 경우가 많은데,
	C의 운영체제에 따라서 C의 int와 java int가 호환이 안될 경우가 있다.
	클라이언트 쪽 환경이 리틀인디언이냐 빅인디언이냐에 따라 이 코드가 달라질 때가 있다.
*/