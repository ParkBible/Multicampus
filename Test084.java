
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
}


public class Test084{
	public static void main(String[] args){
		XList l;
		l = new XList();
		l.add(10);
	}
}


/*
	클래스 인스턴스 참조형변수 자료형 로컬변수 멤버변수 멤버함수 new 가비지콜렉션 생성자함수 null
	
	객체지향 언어의 3대 특징
	1. 상속성 - 클래스를 상속받아 클래스를 만든다.
	2. 은닉성 - 감추고자 하는 것들을 감출 수 있어야 한다.(존재하지만 접근할 수 없는)
	3. 다형성 - 하나의 심볼(이름 - 변수명 함수명) 이 다양한 대상에 접근할 수 있어야 한다.
*/