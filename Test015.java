public class Test015{
	public static void main(String[] args){
		boolean i = true;
		i = false;
		
		i = (100 > 50);
		System.out.println(i);
	}
}

/*
	C의 경우는 정수값이 boolean의 역할을 대신한다.
	java는 boolean이라는 별도의 자료형이 존재한다.
	100 > 50 이러한 종류의 연산의 결과는 true/false로 나타내고, 그 값을 담는 변수가 boolean으로 선언된 변수임.
	이런건 boolean 변수에밖에 못받음.
	6가지 boolean연산 : > >= < <= == !=
*/