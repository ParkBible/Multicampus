
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
	별을 10만개 출력하고 싶다.
	하지만 이 코드는 엄청나게 비효율적이다... 원인이 뭘까?
	*
	**
	***
	이런식으로 새로운 인스턴스를 계속 만들기 때문.
	String은 내용을 변경하지 않기 때문인데... 차라리 내용을 변경하면 인스턴스 1개로 끝나지 않을까?
	-> String과 비슷한데 철저히 자신의 내용을 변경시키는 형태로 동작하는 클래스 : StringBuffer
	
	결론. 고정된 문자열은 ""를 이용하고 이어붙여 문자열 만들때는 StringBuffer를 써라.
*/