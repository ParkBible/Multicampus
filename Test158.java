
public class Test158{
	public static void main(String[] args){
		StringBuffer l = new StringBuffer("*");
		for(int i=0; i<100000; i++){
			l.append("*");
		}
		//System.out.println(l.toString());
	}
}

/*	
public class Test157{
	public static void main(String[] args){
		String l = "*";
		for(int i=0; i<100000; i++){
			l = l + "*";
		}
		System.out.println(l);
	}
}
	���� 10���� ����ϰ� �ʹ�.
	������ �� �ڵ�� ��û���� ��ȿ�����̴�... ������ ����?
	*
	**
	***
	�̷������� ���ο� �ν��Ͻ��� ��� ����� ����.
	String�� ������ �������� �ʱ� �����ε�... ���� ������ �����ϸ� �ν��Ͻ� 1���� ������ ������?
	-> String�� ����ѵ� ö���� �ڽ��� ������ �����Ű�� ���·� �����ϴ� Ŭ���� : StringBuffer
	
	���. ������ ���ڿ��� ""�� �̿��ϰ� �̾�ٿ� ���ڿ� ���鶧�� StringBuffer�� ���.
*/