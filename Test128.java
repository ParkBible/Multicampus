
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Test128{
	public static void main(String[] args){
		Map<String,String> mp = new TreeMap<String,String>();
		mp.put("apple","���");
		mp.put("banana","�ٳ���");
		mp.put("orange","������");
		mp.put("kiwi","Ű��");
		mp.put("kiwi","Ű��2");
		
		String val = mp.get("banana");
		System.out.println(val);
		
		// �䷱ ������ �ڷ����� �����Ͽ� �� ���� ������? �����ϴ�.
		Map<Integer,String> mp2 = new HashMap<Integer,String>();    // TreeMap�̶�� �ص� �ȴ�.
		mp2.put(100, "apple");
		mp2.put(103, "banana");
		
		String val2 = mp2.get(103);
		System.out.println(val2);
	}
}

/*
	���� ���� ���ʸ��� ���� �� ���� ��쵵 �ִ�.
	
	�̷� ���� key, value��� �̾߱��Ѵ�.(�տ����� key) a=b�� ���� ���·� ������ �����Ѵ�.
	���� key�� �̿��ؼ� value�� ���� ���·� ����Ѵ�. mp.get("banana");
	
	���� key�� �ߺ��ؼ� �Է��ϸ� ���� ���� �о�� ����.(��ġ ���� �����ϵ���) mp.put("kiwi","Ű��2");
	
	�̷��� ���·� �����ϴ� �������̽��� Map�̶� �ϰ�, ��ųʸ� ��� �ϴ� �� �ִ�.
	Map<String,String���� ���� key�� �ش��ϴ� ���ʸ�, �ڰ� value�� �ش��ϴ� ���ʸ��̴�.
	
	...
	
	�ڹ� �ȿ��� �⺻������ ���� ����ϴ� �ڷᱸ������ �����ȴ�. ũ�� 3���� �������̽��� ��ӹ޾� �����.
	1. List(ArrayList LinkedList) : ���������ְ� �ߺ� ���
	2. Set(HashSet TreeSet) : ����������� �ߺ�����
	3. Map(HashMap TreeMap) : key=value ����, �ߺ�����
	
	�̰͵��� ��Ī�ؼ� Collection�̶�� �θ���.
*/
