import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test189{
	public static void main(String[] args){
		try{
			InputStream in = new FileInputStream("C:\\JavaWork\\a.dat");
			int r = 0;
			while((r = in.read()) != -1){    // r=in.read()�� -1�� �ƴ� ���ȿ� ��� ����. �ʼ��ϱ�!
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
					alive = false;    // ���� r�� -1�̶��(���� �����Ͱ� ���ٸ�) �ݺ����� �������´�.
				} else{
					System.out.println(r);
				}
			}
*/