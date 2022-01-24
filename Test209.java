import java.net.*;

public class Test209{
	public static void main(String[] args) throws Exception{
		ServerSocket svr = new ServerSocket(7890);
		
		boolean alive = true;
		while(alive){
			Socket skt = svr.accept();
			
			String l = skt.getInetAddress().toString();
			System.out.println(l);    // 클라이언트의 ip주소 출력
			
			if(l.indexOf("127.0.0.1") != -1){
				alive = false;
			}
			
			skt.close();
		}
		
		svr.close();
	}
}

/*
	localtunnel : 유동 IP를 사용하는 컴퓨터에서 서버 소켓을 열었을 때 외부에서 접속가능한
	터널을 뚫어주는 프로그램(일반 TCP 소켓은 안되고 웹 서버는 가능)
	
	통신을 마무리하고 바로 끊지 않고, 서버는 다시 대기 상태로 돌아가야 한다.
	
	skt.getInetAddress() : 접속한 클라이언트의 ip를 추출한다.
	
	127.0.0.1 - 공유기를 거치지 않고 내 컴퓨터에 접속할 때 쓰는 IP
	192.168.*.* - 공유기를 거쳐서 내 컴퓨터에 접속할 때 쓰는 IP
	127.0.0.1로 연결하면 끊기
*/