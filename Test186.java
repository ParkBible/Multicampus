import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test186{
	public static void main(String[] args){
		try{
			// window 디렉토리에서는 역슬래시 두개 써야된다.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import해줘야 한다.
			out.close();
		}
		catch(FileNotFoundException e){     // api 보면 public void close() throws IOException 이라고 적혀있음
		
		}
		
		catch(IOException e){     // api 보면 public void close() throws IOException 이라고 적혀있음
		
		}
		
	}
}

/*
	어선이 그물내릴때 멸치잡는그물, 고등어그물 있다...
	뭐부터 내려야지 바람직할까?  --> 고등어그물부터 내려야 따로따로 잡을 수 있다.
	FileNotFoundException과 IOException의 catch문 위치를 바꾸면 에러가 뜨는데...
	그 이유는 FileNotFoundException extends IOException이기 때문.
	catch(IOException e) 는 FileNotFoundException까지 다 잡아버린다.(멸치잡는그물)
	
	그래서 결국 이 코드에선 IOException 만 써도 당연히 무방하다.
*/