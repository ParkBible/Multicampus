import java.net.Socket;

// 클라이언트 프로그램
public class Test193C{
	public static void main(String[] args){
		try{
			// 서버 프로그램의 Socket skt = svr.accept(); 와 별개의 인스턴스이다.
			// 각자 돌아가는 각각의 프로그램은 메모리를 공유할 수 없다.
			Socket skt = new Socket("192.168.200.171", 7890);    // 소켓 생성. 찾아가서 접속시도
			skt.close();
		}
		catch(Throwable e) {}
	}
}

/*
	실제로 내가 쓰는 IP주소 확인하는법 : whatismyip (117.55.180.233)
	
	별개의 소켓이지만 연결되어 있기때문에 서로 정보를 주고받을 수 있다.
	클라이언트에서 소켓을 생성하고, 7890으로 연결한다.
	소켓은 해당 ip어드레스를 가진 서버를 찾아간다. 이때 7890이라는 포트(통로)를 통해 서버로 들어간다.
	클라이언트에서 요청을 보내면 서버에 소켓 정보가 찍힌다.
*/