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
		
		
		while(lst.isEmpty() == false){    // ���ﶩ ��û�� �ð��� �ɸ�.
			lst.remove(0);
		}
		
		time = (System.currentTimeMillis() - time);    // for�� ���ư��µ� ��������� �ð��� �ɷȴ���
		System.out.println(time);
	}
}

/*
	ArrayList : ���忡 �迭�� �̿��Ѵ�. �׳� �׾Ƴ��⿡ �ξ� ������. �߰��� ������ �Ͼ�� ������尡 ũ��.
	LinkedList : ���忡 ��带 �̿��Ѵ�. ���ۼӵ��� �������� �߰������� �Ͼ �� �δ��� ����.
	
	�߰��� ������ ����� �Ͼ�� LinkedList, �׷����� ���� �׳� �� �׾Ҵٰ� Ǯ��� ArrayList
	
	System.currentTimeMillis() : ������ �ð��� long������ ������ �и������� ������ ����Ѵ�.
	�̰ɷ� �ð� �� ���� ArrayList�� ������.
	
	ArrayList : ���ڶ�� ���� ������ 2�踦 �����Ͽ� �̻簡�µ� �ܼ� �ױ�� �ְ�� ������.
	���߻����� �Ͼ�� ����ִ� �ڸ��� �ڿ��� �ϳ��� ���ܿͼ� ������.
	
	LinkedList : ���߻����� �Ͼ�� �����͸� �ϳ� �ٲٰ� Node �ϳ��� �����Ѵ�. ���߻����� ���ϴ�.
*/