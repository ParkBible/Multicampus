import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test187{
	public static void main(String[] args){
		try{
			// window 디렉토리에서는 역슬래시 두개 써야된다.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import해줘야 한다.
			out.write(100);
			out.write(101);
			out.write(123456);    // 읽으면 64가 나온다. 엥?
			out.close();
		}
		
		catch(IOException e){     // api 보면 public void close() throws IOException 이라고 적혀있음
			System.out.println(e);
		}
		
	}
}

/*  dir a.dat

	FileOutputStream : 해당 파일에 정보를 기록하게 해 주는 클래스
	write : 한번 호출할 때 한바이트씩 기록(위 코드에선 3바이트가 나옴)
	close : 다 끝나면 호출해 줘야 하나 보다...
	
	int는 32비트짜리인데? 하지만 이건 한바이트씩만 기록하므로 256이 넘어가면 짤려서 들어간다.
*/