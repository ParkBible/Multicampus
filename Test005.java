public class Test005 {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		
		i = 100;
		j = i;
		
		i = i + 1;
		j = j + 1;
		
		System.out.println(i);
		System.out.println(j);
		
		int a = 8;
		int b = 34;
		int c = 26;
		
		int first = a;
		int second = a + b;
		int third = a + b + c;
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
	}
}

/*
	java���� ���� ������ �� �ʱⰪ�� �ִ� �� ����.
	int i;
	i = j;
	
	i�� j�� ���� ������ �������� 100�̶�� ���� �����Ѵ�
	i = i + 1;�� i�� �������� �ִ� ���� ������Ŵ.
	
*/