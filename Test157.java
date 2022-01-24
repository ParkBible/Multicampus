
public class Test157{
	public static void main(String[] args){
		String t = "HelloWorld";
		String r = "HelloWorld";
		System.out.println(r == t);    // 같다. t와 r이 같은 인스턴스를 가리키고 있다는 뜻.
		
		String l = t.substring(2,5);
		System.out.println(l);
		
		// llo?? HelloWorld?
		System.out.println(r);    // HelloWorld
		
	}
}

/*
	포인터의 비교는 같은 인스턴스를 가리킬때 ==이 true 나온다.(내용이 같을때가 아님. 그땐 equals)
	substring이 가리키는 문자열의 내용을 변경하는 형태면 llo
	substring이 새로운 문자열을 만들어내는 형태면 HelloWorld이다.
	
	재사용되는 인스턴스는 함부로 내용을 바꾸면 지금 누가 쓰고 있는데 갑자기 내용이 변할 수 있기에
	함부로 변경하면 안된다.
	
	그래서 string의 모든 메소드들은 내용을 바꾸지 않는 형태로 동작한다.
*/