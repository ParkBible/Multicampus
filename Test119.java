interface ITemp<X>{
	public X getData();
}

public class Test119{
	public static void main(String[] args){
		int t = 200;    // anonymous class�� ����ϴ� ���ú���. �ٵ� ���� �̰� ���ú������ �� �� �ִ°�?
		
		/*
		ITemp<Integer> it = new ITemp<Integer>(){
			public Integer getData(){return t;}
		};
		*/
		
		Temp<Integer> it = new ITemp<Integer>(){
			public Integer getData(){
				t = t + 1;
				return t;
			}
		};
		
		int j = it.getData();
		System.out.println(j);
	}
}

/*
	���ú����� ���� anonymous class�� ����ϰ� �ִٸ� �ش� �ν��Ͻ��� �������÷��� ���� �ʴ� �ѿ���
	���ú����� �Լ� ȣ���� ������ �������� �ȵȴ�.
	
	���� anonymous Ŭ������ ������� ���ú����� ���� �����ؼ��� �ȵȴ�.
	
	�ʹ� ���� �������� ���� �׳� �ʿ��� �� �� �� ���� ��ŭ�� �˾Ƴ���!
*/