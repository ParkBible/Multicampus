
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import java.util.ArrayList;

/*
	List : 인터페이스이다.
	LinkedList : 이것을 상속받아 만들어진 클래스.
	List를 상속받아 만들어진 클래스들의 특징
	- add(T t)를 이용하여 넣는다.
	- int size()로 개수를 센다.
	- T get(int i) 로 특정 순서의 요소 포인터를 얻는다.
	- Iterator로 순차탐색을 진행한다.
	- 넣은 순서를 유지하는 형태로 자료를 보관한다.
	
	인터페이스는 클래스간 호환성을 만든다. List가 인터페이스니까 이를 상속받은 LinkedList와 ArrayList는 상호간 호환성이 있다.
	그래서 밑에 있는 LinkedList를 ArrayList로 바꿔도 문제가 없다.
*/

public class Test125{
	public static void main(String[] args){
		// List l = new LinkedList();    // 제너릭쓸때 제너릭에 자료형 지정 안해주면 경고(Note)뜬다. 
		List<String> l = new LinkedList<String>();    // 제공되는 LinkedList가 제너릭이라는 뜻. ArrayList로 바꿔도 결과 같다.
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		
		System.out.println(l.size());
		for(int i=0; i<l.size(); i++){
			String t = l.get(i);
			System.out.println(t);
		}
		Iterator<String> it = l.iterator();    // 위에거랑 같은 결과(순차탐색). 자바 표준 방법. 외우기
		while(it.hasNext()){
			String t = it.next();
			System.out.println(t);
		}
	}
}


/*
	기본적인 자료구조(링크드 리스트 등)는 java에서 제공한다. 근데 Tree랑 Graph는 없다.
	그것들은 제너릭기반으로 되어 있다.
	
	넣은대로 순서대로 출력하는 코드. get()은 순서에 해당하는 입력된 것의 포인터를 리턴한다.
*/


/*
import java.util.LinkedList
import java.util.List

public class Test125{
	public static void main(String[] args){
		List<String> l = new LinkedList<String>();
		
		l.add("apple");
		l.add("banana");
		
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
	}
}
*/