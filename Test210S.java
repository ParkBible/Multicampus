/*
	"127.0.0.1" 에서 보낸 소켓이 올때를 제외하고는 끊어지지 않고 대기하는 서버
*/

import java.net.*;
import java.io.*;

public class Test210S{
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
			else{
				int[] id = {10101, 10102, 10103, 10104};
				
				// 아래 코드와 연동되는 Test210C를 작성해 보세요
				ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream());
				out.writeInt(id.length);    // 길이
				
				for(int i=0; i<id.length; i++){
					out.writeInt(id[i]);
				}
				
				out.flush();
				out.close();
			}
			
			skt.close();
		}
		
		svr.close();
	}
}

