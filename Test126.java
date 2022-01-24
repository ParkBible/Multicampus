
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class Test125{
	public static void main(String[] args){
		Set<String> l = new TreeSet<String>();
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		l.add("kiwi");    // Treeset은 중복 허용 안해서 kiwi는 두개 있지만 한번만 들어간다.
		System.out.println(l.size());
		
		Iterator<String> it = l.iterator();
		while(it.hasNext()){
			String t = it.next();
			System.out.println(t);
		}
	}
}

/*
	import의 대상은? 패키지가 아니고, 클래스임.
	Set 인터페이스에는 System.out.println(l.get(0)); 에서 에러 : get 함수 지원안함
	Set은 보관하되, 순서 개념이 없기 때문.
	하지만 List보다 더 빠른 검색과 효율적인 보관을 제공한다.
	
	TreeSet은 내부적으로 이진트리를 써서 보관한다. 중복입력을 허용하지 않는다.
	
	HashSet과 TreeSet은 전부 Set 인터페이스를 상속하므로 호환성이 생긴다.
	HashSet은 내부적으로 해쉬 알고리즘을 써서 보관한다.
	동작하는 내부 사정은 다르지만 사용함수는 같으므로 사용자는 같은 방법으로 이용할 수 있다.(LinkedList-ArrayList 처럼)
*/