import java.io.*;
import java.net.*;

class Node{
	int num = 0;
	int score = 0;
	Node next = null;
	
	Node(int i, int k, Node j){
		num = i;
		score = k;
		next = j;
	}
}

class XList2{
	Node head = null;
	Node tail = null;
	private int len = 1;
	
	XList2(){
		head = new Node(0, 0, null);
		tail = head;
	}
	
	void add(int num, int score){
		tail.next = new Node(num, score, null);
		tail = tail.next;
		len = len + 1;
	}
	
	void printAll(){
		for( Node t=this.head; t!=null; t=t.next){
			//System.out.println(t.num + " " + t.score);
		}
	}
	
	boolean save(String l){
		System.out.println(l);
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(l));
			for( Node t=this.head; t!=null; t=t.next){
				out.writeUTF(t.num + " " + t.score);
				System.out.println(t.num + " " + t.score);
			}
			out.close();
			
		}
		catch(IOException e){
			System.out.println("에러");
			e.printStackTrace();    // 발생한 에러의 스택정보를 추적할 수 있도록 한다.
			
		}
		return true;
	}
	
	void deleteAll(){
		Node post = head;    // 포인터 2개로 움직이면서 작업 수행하는 아주 유~~용한 코드
		Node pre = head.next;
		
		while(pre != null){
			post.next = null;
			post = pre;
			pre = pre.next;
		}
	}
	
	void open(String l){
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("score.dat"));
			String r = null;
			for(int i=0; i<len; i++){
				r = in.readUTF();
				System.out.println(r);
			}

		}
		catch(IOException e){
			System.out.println("에러");
			e.printStackTrace();    // 발생한 에러의 스택정보를 추적할 수 있도록 한다.
			
		}
	}
	
	
}


public class Test202{
	public static void main(String[] args){
		XList2 l = new XList2();
		l.add(10101, 70);
		l.add(10102, 85);
		l.add(10103, 95);
		l.add(10104, 80);
		l.printAll();    // 이렇게 하면 학번, 성적이 모두 출력된다.
		
		boolean b = l.save("score.dat");
		System.out.println(b);
		
		
		l.deleteAll();    // 다 지우고 초기로 돌아간다.
		
		l.open("score.dat");
		l.printAll();    // 파일에 저장된 내역이 불려져서 출력된다.
		

		
	}
}

/*



*/