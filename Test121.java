
class Node <T>{
	T data = null;
	Node<T> next = null;
	Node(T i, Node<T> j){
		this.data = i;
		this.next = j;
	}
}

interface IList <Z>{
	public void add(Z i);
	//public void deleteAll();
	//public void printAll();
}	

class XList <X> implements IList<X>{
	Node<X> head = null;
	Node<X> tail = null;
	
	XList(){
		head = new Node<X>(null, null);
		tail = head;
	}
	
	public void add(X i){    // add의 매개변수를 어떻게 해야하지? 원래 int i   // 앞에 public 붙여야됨 위에도 붙였어서
		//tail.next = new Node<X>(null, null);
		//tail = tail.next;
		System.out.println(i);
	}
	
	
}


public class Test121{    // 제너릭과 인터페이스 기반으로 XList 고쳐주기. IList는 인터페이스입니다.
	public static void main(String[] args){
		/*
		IList<String> l = new XList<String>();
		
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		
		l.printAll();
		
		l.deleteAll();
		l.printAll();
		
		*/
		IList<Integer> t = new XList<Integer>();
		
		t.add(10);
		t.add(20);
		t.add(30);
		t.add(40);
		/*
		t.printAll();
		
		t.deleteAll();
		t.printAll();
		*/
		
		
	}
}

/*
	void printAll(){
		for( Node t=this.head; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node post = head;
		Node pre = post.next;
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
	}
	
	강사님의 20년 노하우
	1. 기본개념에 충실하자. 개념 이론 코드 다 외워야 실전에서 써먹는다.
	2. 막혔을때는 일단 다 막아버리고 하나씩만 푼다.
	3. 한꺼번에 여러가지 이론 생각하지 말고 한번에 하나씩만
	4. 확실한 자신이 생길때까지 사소한 거에는 관심을 끈다.
	
	인터넷상의 예제는 주로 자기 자랑용인 경우가 많다. (관종이 많아서)
	설명이 개떡같고 하나의 개념을 설명하면서 엉뚱한 코드도 섞인 경우가 허다하다.
	jdk 1.8 이후 추가된 기능은 신경 끄기.(1.5까진 중요한 변화)
*/