import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class OneClient {
	private Socket socket = null;
	private ObjectOutputStream out = null;
	
	public OneClient( Socket s ) {
		this.socket = s;
		try {
			out = new ObjectOutputStream( s.getOutputStream() );
		}
		catch( IOException e ){}
		
		clients.add( this );
		
		//	들어있는거 그냥 찍어나보자...
		for( OneClient oc : clients ) {
			System.out.println( oc.toString() );
		}
	}
	
	private static List<OneClient> clients = null;
	static {
		clients = new ArrayList<OneClient>();
	}
	
	public static void broadcast(String l){
		for(OneClient c : clients){
			try{
				c.out.writeUTF(l);
				c.out.flush();
			}
			catch(IOException e){}
		}
		
	}
}

public class Test213S {
	public static void main( String[] args ) throws Exception {
		ServerSocket svr = new ServerSocket(7890);
		
		// 무한루프 1 : 스캐너 무한루프
		new Thread( new Runnable(){
			public void run() {
				Scanner sc = new Scanner( System.in );
				boolean alive = true ;
				while( alive ) {
					String l = sc.nextLine();
					OneClient.broadcast(l);
				}
			}
		} ).start();
		
		// 무한루프 2 : 클라이언트 무한루프
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			new OneClient( skt );
		}
		svr.close();
	}
}
/*
	클라이언트가 서버에 접속하면 클라이언트 정보가 서버에 출력됨.
	서버에서 스캐너로 사용자가 입력한 것을 받아서 클라이언트에 전송하여 클라이언트에는 해당 문자열이 출력됨.
	
	문자방송 코드 저거 정말 교육효과 만빵으로 좋은 코드니까 ... 다들 한번씩 짜보고 분석해보라고 권하고 싶습니다.

	보통 다섯번쯤 짜니까 알것같다고는 하더라구요

*/