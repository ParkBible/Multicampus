import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Test132_2 {
	public static void main( String[] args ) throws Exception {
		List<String> lst = new ArrayList<String>();
		lst.add("apple");
		lst.add("banana");
		lst.add("orange");
		lst.add("kiwi");
		
		/*
		// ����Ʈ ��� �����
		for(int i=0; i<lst.size(); i++){    // �ٶ������� ���� ����̴�. lst.size()�� ��� �پ���, �ε����� ������� ����.
			String t = lst.remove(i);		// ���Ը��ؼ� �ε��� 0�� apple�� �������� 0���� banana�� ����.
			System.out.println(t);   
		}
		
		// ���ʺ��� ���� ������, size()�� ���������� ����.
		// arraylist�� ���� �� �տ������� ����� �з��ö󰡱� ������ �����ٰ� �����ϱ� �ڿ������� ����� �ӵ��� ������.
		int len = lst.size();
		for(int i=len-1; i>=0; i--){
			lst.remove(i);
		}
		*/
		
		Iterator<String> it = lst.iterator();
		while(it.hasNext()){
			String t = it.next();
			it.remove();    // it.next() ���� �� Ƣ��� �׳��� �����ش�.
		}
		
		for(int i=0; i<lst.size(); i++){
			String t = lst.get(i);
			System.out.println(t);
		}
	
	}
}
