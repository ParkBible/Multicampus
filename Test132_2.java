import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Test132_2 {
	public static void main( String[] args ) throws Exception {
		List<String> lst = new ArrayList<String>();
		lst.add("apple");
		lst.add("banana");
		lst.add("orange");
		lst.add("kiwi");
		
		/*
		// 리스트 요소 지우기
		for(int i=0; i<lst.size(); i++){    // 바람직하지 않은 방법이다. lst.size()가 계속 줄어들고, 인덱스가 당겨지기 때문.
			String t = lst.remove(i);		// 쉽게말해서 인덱스 0인 apple이 지워지면 0에는 banana가 들어옴.
			System.out.println(t);   
		}
		
		// 뒤쪽부터 지워 나가고, size()는 고정값으로 쓴다.
		// arraylist를 지울 때 앞에서부터 지우면 밀려올라가기 때문에 느리다고 했으니까 뒤에서부터 지우면 속도도 빠르다.
		int len = lst.size();
		for(int i=len-1; i>=0; i--){
			lst.remove(i);
		}
		*/
		
		Iterator<String> it = lst.iterator();
		while(it.hasNext()){
			String t = it.next();
			it.remove();    // it.next() 했을 때 튀어나올 그넘을 지워준다.
		}
		
		for(int i=0; i<lst.size(); i++){
			String t = lst.get(i);
			System.out.println(t);
		}
	
	}
}
