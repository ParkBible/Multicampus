import java.net.Socket;
import java.io.InputStream;

// 클라이언트 프로그램
public class Test194C{
	public static void main(String[] args){
		try{
			// 서버 프로그램의 Socket skt = svr.accept(); 와 별개의 인스턴스이다.
			// 각자 돌아가는 각각의 프로그램은 메모리를 공유할 수 없다.
			Socket skt = new Socket("192.168.200.171", 7890);    // 소켓 생성. 찾아가서 접속시도
			
			InputStream in = skt.getInputStream();
			// int r = in.read();    // 1바이트 읽어들일때 씀
			
			byte[] buf = new byte[4];    // 4바이트 읽어들인다.
			int len = in.read(buf);
			
			in.close();
			
			for(int i=0; i<len; i++){
				System.out.println(buf[i]);
			}
			
			//System.out.println(r);
			skt.close();
		}
		catch(Throwable e) {e.printStackTrace();}
	}
}

/*
	서버에서 전송하는 데이터를 받아들임.
	
	업로드 & 다운로드 과정 : 서버의 로컬 파일을 소켓으로 복사하고, 클라이언트는 소켓을 받은 뒤 로컬 파일로 저장한다.
*/