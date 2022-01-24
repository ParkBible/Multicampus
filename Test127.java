
class Node{
	int name = 0;
	Node next = null;
	
	Node(int i, Node j){
		name = i;
		next = j;
	}
}

class YList{
	Node head = null;
	
	YList(){
		head = new Node(0,null);
	}
	
	// post는 tail의 역할을 한다. 맨 마지막에 pre가 null이 되면 맨 끝 노드에 위치하기 때문.
	// 그러나 10만개가 있다면 반복문이 10만번 돌아야 하므로 효율성이 떨어진다.
	void add(int i){
		Node post = head;
		Node pre = head.next;
		while(pre!=null && pre.name<i){    // && pre.name<i 라고 들어가면 오름차순으로 정렬되어 출력한다. head.next가 젤 작은 수.
			//System.out.println(pre.name);    //  2. 30(pre.name)과 40(i)을 비교하니 i가 더크다. 한칸 넘어간다.
												// 4. 40(pre.name)과 20(i)을 비교하니 pre.name이 더크다. 안넘어간다
			post = pre;	
			pre = pre.next;
			
			//System.out.println(post.name);
		}
		post.next = new Node(i, pre);   // 1. 일단 맨 먼저 post 다음에 30 추가
										// 3. post 다음에 40 추가.
	}									// 5. post와 pre 사이에 노드 하나를 추가해서 거기에 20(i)을 넣는다.
	
	
	void printAll(){
		for(Node t=head.next; t!=null; t=t.next){
			System.out.println(t.name);
		}
	}
}

public class Test127{
	public static void main(String[] args){
		YList l = new YList();
		l.add(30);
		l.add(40);
		l.add(20);
		l.add(30);
		l.printAll();
	}
}