
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class Test125{
	public static void main(String[] args){
		Set<String> l = new TreeSet<String>();
		l.add("apple");
		l.add("banana");
		l.add("orange");
		l.add("kiwi");
		l.add("kiwi");    // Treeset�� �ߺ� ��� ���ؼ� kiwi�� �ΰ� ������ �ѹ��� ����.
		System.out.println(l.size());
		
		Iterator<String> it = l.iterator();
		while(it.hasNext()){
			String t = it.next();
			System.out.println(t);
		}
	}
}

/*
	import�� �����? ��Ű���� �ƴϰ�, Ŭ������.
	Set �������̽����� System.out.println(l.get(0)); ���� ���� : get �Լ� ��������
	Set�� �����ϵ�, ���� ������ ���� ����.
	������ List���� �� ���� �˻��� ȿ������ ������ �����Ѵ�.
	
	TreeSet�� ���������� ����Ʈ���� �Ἥ �����Ѵ�. �ߺ��Է��� ������� �ʴ´�.
	
	HashSet�� TreeSet�� ���� Set �������̽��� ����ϹǷ� ȣȯ���� �����.
	HashSet�� ���������� �ؽ� �˰����� �Ἥ �����Ѵ�.
	�����ϴ� ���� ������ �ٸ����� ����Լ��� �����Ƿ� ����ڴ� ���� ������� �̿��� �� �ִ�.(LinkedList-ArrayList ó��)
*/