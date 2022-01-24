class Node{
	int name = 0;
	Node next = null;    // 멤버변수임과 동시에, 참조형 변수. 인스턴스를 가리킬 수 있다.
}

public class Test074{
	public static void main(String[] args){
		Node head = new Node();
		Node tail = head;
		
		Node tmp = new Node();
		tmp.name = 10;
		tmp.next = null;
		
		head.next = tmp;
		tail = tmp;
		
		tmp = new Node();   // tmp 변수는 이미 있으므로 새로 정의하지 않고, 대입만 한다.
		tmp.name = 20;
		tmp.next = null;
		
		tail.next = tmp;
		tail = tmp;
		
		for(Node t=head; t!=null; t=t.next){    // 0 10 20
			System.out.println(t.name);
		}
		
		// 이 코드가 왜 10 20을 날리는지 정리.
		Node post = head;
		Node pre = head.next;
		while(pre!=null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
		post = null;
		
	}
}

/*
	참조형 변수 : 인스턴스를 가리킬 수 있는 변수, 포인터로 선언되는 변수
	멤버 변수는 인스턴스가 생성되는 시점에 메모리를 할당
	참조형변수의 대입 :
	null : 모든 참조형 변수에 대입 가능. t=t.next를 한다음 t가 null인게 확인되면 종료.
*/