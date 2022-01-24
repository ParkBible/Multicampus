import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test129{
	public static void main(String[] args){
		List<String> lst = new LinkedList<String>();
		
		long time = System.currentTimeMillis();
		
		for(int i=0; i<200000; i++){
			lst.add("apple"+i);
		}
		
		
		while(lst.isEmpty() == false){    // 지울땐 엄청난 시간이 걸림.
			lst.remove(0);
		}
		
		time = (System.currentTimeMillis() - time);    // for문 돌아가는데 어느정도의 시간이 걸렸는지
		System.out.println(time);
	}
}

/*
	ArrayList : 저장에 배열을 이용한다. 그냥 쌓아놓기에 훨씬 빠르다. 중간에 삭제가 일어나면 오버헤드가 크다.
	LinkedList : 저장에 노드를 이용한다. 동작속도는 느리지만 중간삭제가 일어날 때 부담이 적다.
	
	중간에 삭제가 빈번히 일어나면 LinkedList, 그런일이 적고 그냥 쭉 쌓았다가 풀어내면 ArrayList
	
	System.currentTimeMillis() : 현재의 시간을 long형태의 정수로 밀리세컨드 단위로 출력한다.
	이걸로 시간 재 보니 ArrayList가 빠르다.
	
	ArrayList : 모자라면 기존 공간의 2배를 마련하여 이사가는데 단순 쌓기는 최고로 빠르다.
	도중삭제가 일어나면 비어있는 자리를 뒤에서 하나씩 땡겨와서 느리다.
	
	LinkedList : 도중삭제가 일어나면 포인터만 하나 바꾸고 Node 하나만 삭제한다. 도중삭제에 강하다.
*/