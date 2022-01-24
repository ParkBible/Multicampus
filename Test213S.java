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
		
		//	����ִ°� �׳� ������...
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
		
		// ���ѷ��� 1 : ��ĳ�� ���ѷ���
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
		
		// ���ѷ��� 2 : Ŭ���̾�Ʈ ���ѷ���
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			new OneClient( skt );
		}
		svr.close();
	}
}
/*
	Ŭ���̾�Ʈ�� ������ �����ϸ� Ŭ���̾�Ʈ ������ ������ ��µ�.
	�������� ��ĳ�ʷ� ����ڰ� �Է��� ���� �޾Ƽ� Ŭ���̾�Ʈ�� �����Ͽ� Ŭ���̾�Ʈ���� �ش� ���ڿ��� ��µ�.
	
	���ڹ�� �ڵ� ���� ���� ����ȿ�� �������� ���� �ڵ�ϱ� ... �ٵ� �ѹ��� ¥���� �м��غ���� ���ϰ� �ͽ��ϴ�.

	���� �ټ����� ¥�ϱ� �˰Ͱ��ٰ�� �ϴ��󱸿�

*/