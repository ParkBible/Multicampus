public class Test004{
	public static void main(String[] avg){
		System.out.println("HelloWorld");
		
		int i, j;
		
		i = 100;
		j = 100;
		
		i = i + 1;
		
		System.out.println(i);
		System.out.println(j);
		
	}
}

/*
	int i,j;
	- 각각의 이름에 별개의 기억공간이 존재함(값이 같더라도)
	- 하나의 이름에 두 개의 기억공간이 주어지는 경우는 거의 모든 언어가 지원하지 않는다.
	- C++의 레퍼런스 개념이 유사하긴 한데 그거 안 써도 먹고 산다.
	
	- 결론 : 의문이 있으면 그걸 해결할 수 있는 코드 정도는 짤 수 있어야 한다.
*/