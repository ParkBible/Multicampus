class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, Node j){
		this.name = i;
		this.next = j;
	}
}

class XList
{
	Node head = null;
	Node tail = null;
	
	XList(){
		head = new Node(0,null);    // head는 name이 0, next가 null인 Node를 가리킨다.
		tail = head;   // head가 가리키는 것을 tail도 가리킨다.
	}
	
	void add(int i){
		tail.next = new Node(i, null);   // tail.next가 가리키는 새로운 Node를 생성한다.
		tail = tail.next;    	// tail.next가 가리키는 노드는 tail이 가리키게 되고 tail은 항상 맨 뒤 노드를 가리키게 된다.
	}
	
	void printAll(){
		// 자바는 반복문 앞에 t 선언 따로 안해줘도 된다.
		for( Node t=this.head; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
	
	void deleteAll(){
		Node post = head;    // 포인터 2개로 움직이면서 작업 수행하는 아주 유~~용한 코드
		Node pre = head.next;
		
		while(pre != null){
			System.out.println(pre.name); // 10 20
			
			post.next = null;
			post = pre;
			pre = pre.next;
			
			System.out.println(post.name);  // 10 20
		}
	}
}

public class Test079{
	public static void main(String[] args){
		XList l = new XList();    // 인스턴스가 생성되었다. 자료형도 Xlist. 생성자 호출됨.
		l.add(10);    // 레퍼런스 l 안에 있는 함수인 add를 호출한다. 
		l.add(20);
		l.printAll();
		
		l.deleteAll();
		

	}
}


/*
	만들어야 할 것 : 멤버변수, 멤버함수, 생성자함수, this
	자바에서는 로컬변수와 이름이 겹치지만 않으면 멤버변수를 사용할때 쓰는 this는 생략할 수 있다.
	즉 this.next를 next로 쓸수있다.
	멤버변수는 인스턴스 생성시 메모리 할당. 알아서 소거. 수거되는 시점은 가리키는 포인터가 0개 되었을 때.
*/