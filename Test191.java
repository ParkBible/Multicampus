import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class Test191{
	public static void main(String[] args){
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\01.mp3");    // 열어서
			OutputStream out = new FileOutputStream("C:\\JavaWork\\01a.mp3");    // 내보냄(파일이 달라서 동시에 해도 무방)
			
			int r = 0;
			while((r=in.read())!=-1){
				out.write(r);
			}
			
			out.close();
			in.close();
		}
		catch(IOException e){
		}
	}
}

/*
OutputStream out = new FileOutputStream("C:\\JavaWork\\b.dat");
			out.write(100);
			out.write(101);
			out.write(102);
			out.close();
			파일을 복사하는 프로그램이 되었다. 한바이트 읽고 끝이 아니면 쓴다.
			
			dir *.mp3
			
	근데 넘 느리다.
	read에는 두가지 오버로딩된 함수가 있다.
	int read() : 한 바이트를 읽어서 그 내용을 리턴한다.
	int read(byte[]) : 읽어서 byte[]에 내용을 복사하고 읽은 바이트수를 리턴한다.
	
	write에도 두가지 방법
	void write(int i) : 하위 8비트를 전송한다.
	void write(byte[] buf, int offset, int len)
	: buf 안의 내용을 offset부터 시작해서 len 크기만큼을 전송
	
*/