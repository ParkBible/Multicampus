
class Node{
	int data = 0;
	Node next = null;
	Node(int i, int j){    // 생성자.
		data = i;
		next = j;
	}
}

class XList{
	Node head = null;
	Node tail = null;
	XList(){    // XList의 생성자! 인스턴스 생성하는거 좀 외우자!! new 다음 자료형
		head = new Node(0, null);
		tail = head;
	}
	
	
	void add(int i){
		tail.next = new Node(i, null);
		tail = tail.next;
	}

}



public class Test105
	public static void main(String[] args){
		XList t = new XList();    // 이것도!
		t = add(10);
	}