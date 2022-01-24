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
	java에선 변수 선언할 때 초기값을 주는 게 좋다.
	int i;
	i = j;
	
	i와 j는 각각 별도의 기억공간에 100이라는 값을 저장한다
	i = i + 1;은 i의 기억공간에 있는 값만 증가시킴.
	
*/