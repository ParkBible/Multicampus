/*
class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, Node j){
		name = i;
		next = j;
	}
}

class XList{
	Node head = null;
	Node tail = null;
	XList(){   // 생성자 꼭 클래스 이름과 같게 해줘야 한다. 안그러면 리턴타입 입력하라고 오류뜬다. Xlist라고 잘못써서 한참헤맸다;;
		head = new Node(0, null);
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
	
}

public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
		
	}
}
*/



// 심오한 객체지향의 세계... 한줄이라도 모르면 아무것도 못한다.
/*
class Node{
	int name = 0;   // 이거랑 밑줄은 변수 자료형 정의만 해줌. 실질적인 생성 부분은 Node함수.
	Node next = null;
	
	Node(int i, Node j){    // Node의 생성자! 이름은 꼭!! 클래스와 같게 해주어야 한다!
		name = i;
		next = this;  // head 노드 자체를 가리킨다.
	}
}

class XList{
	Node head = null;
	Node tail = null;
	
	XList(){    // XList의 생성자!
		head = new Node(0, null);   // next는 인스턴스 생성할때 대입안하고 나중에 대입하도라..
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
}

public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
	}
}

*/


class Node{
	int name = 0;
	Node next = null;
	Node(int i, Node j){
		name = i;
		next = j;
	}
}

class XList{
	Node head = null;
	Node tail = null;
	XList(){
		head = new Node(0, null);
		tail = head;
	}
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}
	
	void printAll(){
		for(Node t=head.next;t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node pre = head.next;
		Node post = head;
		
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
		
	}
	
	int removeLikeQueue(){
		// 비어있을때는 동작하면 안된다.
		if(head.next == null){
			return -1;
		}
		
		
		Node post = head;
		Node pre = head.next;
		
		// 초기 1회 시행 : 
		post.next = pre.next;    // 날릴 노드를 가리키고 있던 post.next가 가리키는 것을 건너뛰게 한다. 현재 pre 한칸 앞 노드를 가리킴.
		//pre.next = null;    // pre.next가 가리키던 것을 null로 한다(없앤다).
	
		// 포인터의 ==는 같은 대상을 가리키면 true. 이런 현상이 발생할 때는 노드가 하나일때밖에 없다.
		if(tail==pre){
			tail = head;
		}
		
		return pre.name;
		// 이 과정이 끝나면 post.next = pre.next; 코드에 의해 pre가 가리키고 있던 노드는 사라진다.
	}
}

/*
	스택 & 큐 : 스택은 늦게 들어온순대로 나감, 큐는 먼저들어온게 먼저나감.
*/


public class Test080{
	public static void main(String[] args){
		XList l = new XList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		
		int n = l.removeLikeQueue();
		System.out.println(n);
		System.out.println(l.removeLikeQueue());
		
		l.printAll();
		l.deleteAll();
	}
}