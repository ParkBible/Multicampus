import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test187{
	public static void main(String[] args){
		try{
			// window ���丮������ �������� �ΰ� ��ߵȴ�.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import����� �Ѵ�.
			out.write(100);
			out.write(101);
			out.write(123456);    // ������ 64�� ���´�. ��?
			out.close();
		}
		
		catch(IOException e){     // api ���� public void close() throws IOException �̶�� ��������
			System.out.println(e);
		}
		
	}
}

/*  dir a.dat

	FileOutputStream : �ش� ���Ͽ� ������ ����ϰ� �� �ִ� Ŭ����
	write : �ѹ� ȣ���� �� �ѹ���Ʈ�� ���(�� �ڵ忡�� 3����Ʈ�� ����)
	close : �� ������ ȣ���� ��� �ϳ� ����...
	
	int�� 32��Ʈ¥���ε�? ������ �̰� �ѹ���Ʈ���� ����ϹǷ� 256�� �Ѿ�� ©���� ����.
*/