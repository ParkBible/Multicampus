import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test185{
	public static void main(String[] args){
		try{
			// window ���丮������ �������� �ΰ� ��ߵȴ�.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import����� �Ѵ�.
			out.close();
		}													
		catch(FileNotFoundException e){
			
		}
		catch(IOException e){     // api ���� public void close() throws IOException �̶�� ��������
		
		}
	}
}

/*
	�Ʒ� �ڵ尡 �ܰ躰�� �� ������ & ������ �Ƿ���?
	
	1. OutPutStream out = null;
		�ϴ� �� Ŭ������ ���ٽ�ߵǴϱ� import���ش�.
	2. OutPutStream out = new FileOutputStream("C:\\JavaWork\\a.dat");
		FileOutputStream�� ��ߵǴϱ� import���ش�.
		�ٵ� FileNotFoundException�� throws�� ������ �Ǿ��ִ�.
		FileNotFoundException �� import���ش�.
	3. out.close();
		2�� ���. IOException import�Ѵ�.
*/