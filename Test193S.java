import java.net.ServerSocket;
import java.net.Socket;

// 서버 프로그램
public class Test193S{
	public static void main(String[] args){
		try{
			ServerSocket svr = new ServerSocket(7890);    // 7890 : 포트 번호(네트워크 통로의 고유 번호)
			
			System.out.println("before accept");
			Socket skt = svr.accept();    // 뭔가가 올때까지 계속 대기. 오게되면 소켓 생성 후 리턴.
			
			System.out.println(skt.toString());    // 뭔가 오면 소켓 정보 찍힘.
			
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
