
public class Test092{
	public static void main(String[] args){
		String l = null;
		String t = "HelloWorld";
		System.out.println(t.startsWith("Apple"));
		System.out.println(t.endsWith("ld"));
		
		int i;
		i = t.indexOf("l");    // int indexOf(str) �� Ŭ������ ������ ���ǵǾ��ִ�!
		System.out.println(i);   // ó������ �ε��� ��ȣ(2)
		
		int ii;
		ii = t.lastIndexOf("l");    // ���������� ���� �ε��� ��ȣ(8)
		System.out.println(ii);
		
		String i3 = t.substring(2, 4);   // ll�� ���. 2~3��° �ε����� �ش��ϴ� ���ڿ� ���
		System.out.println(i3);
	}
}

/*
	C:\apiDocs\docs\api\index.html �� �ڹ��� Ŭ�������� �ִ�.
	
	<Ŭ������ �� �� �ִ� ��>
	1. ������ ���� ���� String l = null;  // ������ ������ null�� ��.
	2. �ν��Ͻ� ����
	3. Ŭ������ ��ӹ޾� Ŭ������ ����(����� �̰ͻ�)
	
	���� Ÿ�Կ� ���� ������ ���� �ƴϸ� �ڷ��� �����ε� null�� �� �� �ִ� �� ������ �����̴�.
	���� String ���� ������ �Լ��� ������ �����̴�.
	
	�׷��� String t = "HelloWorld"; �� ��� �ν��Ͻ��̴�.
	new�� �� ��µ��� �ν��Ͻ����??? -> new�� �� �ᵵ �Ǵ� Ŭ������ String�� ������.
*/