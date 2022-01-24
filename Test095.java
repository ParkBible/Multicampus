
/*
	오버로딩을 쓰는 이유 : 거의 비슷한 동작을 하는 함수들의 이름은 차라리 그냥 통일시키는 게 불러쓰기 편하더라
*/
public class Test095{
	public static void main(String[] args){
		String t = "HelloWorld";
		// 서브스트링에서 매개변수 하나짜리는 두개짜리랑 어떻게 다를까?
		System.out.println(t.substring(3));
		// 인덱스 3인 문자열부터 출력 -> 거의 비슷한 동작 수행. 매개변수 개수만 다르고 이름은 같다.
		
		System.out.println(t.indexOf("loW",1));
	}
}