import java.net.*;
import java.io.*;

public class Test227S {
	public static void main( String[] args ) throws Exception {
		ServerSocket svr = new ServerSocket( 7890 );
		
		boolean alive = true;
		while( alive ) {
			Socket skt = svr.accept();
			System.out.println( skt.toString() );
			
			InputStream fin = new FileInputStream("C:\\JavaWork\\01.zip");	// 1.4G
			OutputStream out = skt.getOutputStream();
			
			int len = 0;
			byte[] buf = new byte[1024*64];
			
			while( ( len = fin.read( buf ) ) != -1 ) {
				out.write( buf, 0, len );
				out.flush();
			}
			
			out.close();
			fin.close();
			
			skt.close();
		}
		svr.close();
	}
}