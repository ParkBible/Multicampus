
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test130{
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String l = bin.readLine();
			
			if(l.equals("quit")){    // equals : ���ڿ� �� �޼ҵ�. �Է��� ���ڿ��� quit�̸� ����.
				break;
			}
			System.out.println(l);
		}
		
		bin.close();
	}
}

/*
	readLine : �ܼ�â���� �Է��ϰ� ���� ������ �ش� ������ ���ڿ��� �����Ѵ�.
*/