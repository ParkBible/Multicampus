import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test186{
	public static void main(String[] args){
		try{
			// window ���丮������ �������� �ΰ� ��ߵȴ�.
			OutputStream out = new FileOutputStream("C:\\JavaWork\\a.dat");    // import����� �Ѵ�.
			out.close();
		}
		catch(FileNotFoundException e){     // api ���� public void close() throws IOException �̶�� ��������
		
		}
		
		catch(IOException e){     // api ���� public void close() throws IOException �̶�� ��������
		
		}
		
	}
}

/*
	��� �׹������� ��ġ��±׹�, ����׹� �ִ�...
	������ �������� �ٶ����ұ�?  --> ����׹����� ������ ���ε��� ���� �� �ִ�.
	FileNotFoundException�� IOException�� catch�� ��ġ�� �ٲٸ� ������ �ߴµ�...
	�� ������ FileNotFoundException extends IOException�̱� ����.
	catch(IOException e) �� FileNotFoundException���� �� ��ƹ�����.(��ġ��±׹�)
	
	�׷��� �ᱹ �� �ڵ忡�� IOException �� �ᵵ �翬�� �����ϴ�.
*/