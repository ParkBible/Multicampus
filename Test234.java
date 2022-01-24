import java.io.*;

public class Test233{
	public static void main(String[] args) throws IOException{
		Write out = new OutputStreamWriter(new FileOutputStream("C:\\JavaWork\\c.txt"));
		out.write("한");
		out.close();
		
		// inputstream은 바이트 단위, reader는 char 단위이다.
		// 캐릭터 단위로 읽었는데 공급책(c.txt)은 바이트 단위로 공급한다.
		// 이걸 바꿔줘야 해서 inputstreamreader 을 쓴다.
		Reader in = new InputStreamReader(new FileInputStream("C:\\JavaWork\\c.txt"));
		char r = (char)in.read();
		in.close();
		System.out.println(r);
	}
}
/*
	out.write(10000);   -- 1 char 내보낸다. 1 byte아니고
	OutputStreamWriter(OutputStream out)
	Writer의 자손인데 생성자에 OutputStream??
	
	대상은 new FileOutputStream("C:\\JavaWork\\c.txt") 인데 1 char를 내보낸다?
	
	OutputStreamWriter : char 입출력을 byte 입출력으로 바꾸는 일종의 어댑터(220V > 110V)
	InputStreamReader : byte 단위 입력을 char 단위 입력으로 바꾸는 어댑터.
*/