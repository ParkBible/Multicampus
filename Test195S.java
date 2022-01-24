import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;

// 서버 프로그램
public class Test195S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : 포트 번호(네트워크 통로의 고유 번호)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // 뭔가가 올때까지 계속 대기. 오게되면 소켓 생성 후 리턴.
	
			
			OutputStream out = skt.getOutputStream();
			InputStream in = new FileInputStream("C:\\JavaWork\\01.mp3");
			
			int len = 0;
			byte[] buf = new byte[1024*128];
			while((len = in.read(buf))!=-1){
				out.write(buf, 0, len);
				out.flush();
			}
			
			in.close();
			out.close();    // 네트워크 상의 전송은 보낸 다음 반드시 flush() 호출
			
			skt.close();
			svr.close();
		}
		catch(Throwable e){}
	}
}