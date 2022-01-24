import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test185{
	public static void main(String[] args){
		try{
			// window 디렉토리에서는 역슬래시 두개 써야된다.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import해줘야 한다.
			out.close();
		}													
		catch(FileNotFoundException e){
			
		}
		catch(IOException e){     // api 보면 public void close() throws IOException 이라고 적혀있음
		
		}
	}
}

/*
	아래 코드가 단계별로 다 컴파일 & 실행이 되려면?
	
	1. OutPutStream out = null;
		일단 이 클래스를 갖다써야되니까 import해준다.
	2. OutPutStream out = new FileOutputStream("C:\\JavaWork\\a.dat");
		FileOutputStream도 써야되니까 import해준다.
		근데 FileNotFoundException를 throws로 쓰도록 되어있다.
		FileNotFoundException 도 import해준다.
	3. out.close();
		2와 비슷. IOException import한다.
*/