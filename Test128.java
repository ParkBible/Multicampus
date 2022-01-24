
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Test128{
	public static void main(String[] args){
		Map<String,String> mp = new TreeMap<String,String>();
		mp.put("apple","사과");
		mp.put("banana","바나나");
		mp.put("orange","오렌지");
		mp.put("kiwi","키위");
		mp.put("kiwi","키위2");
		
		String val = mp.get("banana");
		System.out.println(val);
		
		// 요런 식으로 자료형을 교차하여 쓸 수도 있을까? 가능하다.
		Map<Integer,String> mp2 = new HashMap<Integer,String>();    // TreeMap이라고 해도 된다.
		mp2.put(100, "apple");
		mp2.put(103, "banana");
		
		String val2 = mp2.get(103);
		System.out.println(val2);
	}
}

/*
	위와 같이 제너릭이 여러 개 들어가는 경우도 있다.
	
	이런 쌍을 key, value라고 이야기한다.(앞에꺼가 key) a=b와 같은 형태로 정보를 저장한다.
	보통 key를 이용해서 value를 얻어내는 형태로 사용한다. mp.get("banana");
	
	같은 key로 중복해서 입력하면 앞의 값은 밀어내고 없다.(마치 변수 대입하듯이) mp.put("kiwi","키위2");
	
	이러한 형태로 저장하는 인터페이스를 Map이라 하고, 딕셔너리 라고 하는 언어도 있다.
	Map<String,String에서 앞이 key에 해당하는 제너릭, 뒤가 value에 해당하는 제너릭이다.
	
	...
	
	자바 안에는 기본적으로 많이 사용하는 자료구조들이 제공된다. 크게 3가지 인터페이스를 상속받아 만든다.
	1. List(ArrayList LinkedList) : 순서개념있고 중복 허용
	2. Set(HashSet TreeSet) : 순서개념없고 중복불허
	3. Map(HashMap TreeMap) : key=value 형태, 중복불허
	
	이것들을 총칭해서 Collection이라고 부른다.
*/
