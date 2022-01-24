public class Test024{
	public static void main(String[] args){
		String t = "HelloWorld";
		System.out.println(t);
		
		char i = '한';
		
		char[] j = "HelloWorld".toCharArray();
		
		for(int p=0; p<j.length; p++){
			System.out.println(j[p]);
		}
		
	}
}

/*
	"HelloWorld"
	1. char는 자료형이지만, String은 자료형이 아닌 클래스이다.
	2. char는 1개의 문자에 해당하는 코드값(아스키코드)을 저장할 수 있는 변수선언이 가능하다.
	3. String은 ""로 감싼 문자열(0개 이상의 문자의 나열)을 대입할 수 있는 변수선언이 가능하다.
	사실 t는 변수명이 아니고 포인터이다.(배열처럼...)
*/