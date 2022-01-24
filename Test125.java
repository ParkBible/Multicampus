
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import java.util.ArrayList;

/*
	List : �������̽��̴�.
	LinkedList : �̰��� ��ӹ޾� ������� Ŭ����.
	List�� ��ӹ޾� ������� Ŭ�������� Ư¡
	- add(T t)�� �̿��Ͽ� �ִ´�.
	- int size()�� ������ ����.
	- T get(int i) �� Ư�� ������ ��� �����͸� ��´�.
	- Iterator�� ����Ž���� �����Ѵ�.
	- ���� ������ �����ϴ� ���·� �ڷḦ �����Ѵ�.
	
	�������̽��� Ŭ������ ȣȯ���� �����. List�� �������̽��ϱ� �̸� ��ӹ��� LinkedList�� ArrayList�� ��ȣ�� ȣȯ���� �ִ�.
	�׷��� �ؿ� �ִ� LinkedList�� ArrayList�� �ٲ㵵 ������ ����.
*/

public class Test125{
	public static void main(String[] args){
		// List l = new LinkedList();    // ���ʸ����� ���ʸ��� �ڷ��� ���� �����ָ� ���(Note)���. 
		List<String> l = new LinkedList<String>();    // �����Ǵ� LinkedList�� ���ʸ��̶�� ��. ArrayList�� �ٲ㵵 ��� ����.
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		
		System.out.println(l.size());
		for(int i=0; i<l.size(); i++){
			String t = l.get(i);
			System.out.println(t);
		}
		Iterator<String> it = l.iterator();    // �����Ŷ� ���� ���(����Ž��). �ڹ� ǥ�� ���. �ܿ��
		while(it.hasNext()){
			String t = it.next();
			System.out.println(t);
		}
	}
}


/*
	�⺻���� �ڷᱸ��(��ũ�� ����Ʈ ��)�� java���� �����Ѵ�. �ٵ� Tree�� Graph�� ����.
	�װ͵��� ���ʸ�������� �Ǿ� �ִ�.
	
	������� ������� ����ϴ� �ڵ�. get()�� ������ �ش��ϴ� �Էµ� ���� �����͸� �����Ѵ�.
*/


/*
import java.util.LinkedList
import java.util.List

public class Test125{
	public static void main(String[] args){
		List<String> l = new LinkedList<String>();
		
		l.add("apple");
		l.add("banana");
		
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i));
		}
	}
}
*/