
class Node{
	int data = 0;
	Node next = null;
	Node(int i, int j){    // ������.
		data = i;
		next = j;
	}
}

class XList{
	Node head = null;
	Node tail = null;
	XList(){    // XList�� ������! �ν��Ͻ� �����ϴ°� �� �ܿ���!! new ���� �ڷ���
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
		XList t = new XList();    // �̰͵�!
		t = add(10);
	}