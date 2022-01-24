import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test189{
	public static void main(String[] args){
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\a.dat");
			int r = 0;
			while((r = in.read()) != -1){    // r=in.read()가 -1이 아닌 동안에 계속 돈다. 필수암기!
				System.out.println(r);
			}
			
			in.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}

/*
boolean alive = true;
			while(alive){
				int r = in.read();
				if(r == -1){
					alive = false;    // 만약 r이 -1이라면(다음 데이터가 없다면) 반복문을 빠져나온다.
				} else{
					System.out.println(r);
				}
			}
*/