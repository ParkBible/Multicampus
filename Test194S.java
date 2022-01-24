import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

// 서버 프로그램
public class Test194S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : 포트 번호(네트워크 통로의 고유 번호)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // 뭔가가 올때까지 계속 대기. 오게되면 소켓 생성 후 리턴.
			
			byte[] buf = new byte[]{100,101,102,103};    // 4바이트 보내기
			
			OutputStream out = skt.getOutputStream();
			//out.write(100);
			
			out.write(buf, 0, buf.length);
			out.flush();
			out.close();    // 네트워크 상의 전송은 보낸 다음 반드시 flush() 호출
			
			skt.close();
			svr.close();
		}
		catch(Throwable e){}
	}
}

/*
	svr.accept() 여기서 멈춰서 대기하고 있는 상황이다.
	ipconfig : ipv4주소 확인. 192.168.200.171
	
*/
