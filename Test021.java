public class Test021{
	public static void main(String[] args){
		for(int i=0; i<5; i++){
			System.out.println("Apple " + i);
			if(i == 3){
				System.out.println("Kiwi");
			}
			System.out.println("Banana " + i);
		}
	}
}
/*
	���ڿ��� �̾���̷��� + ��ȣ�� ����.
	break�� �ݺ��� �ȿ����� �� �� ������, for�� ������ ������ ���������� ��ɾ��̴�.
	continue�� ������ �� ���� ���� �ڵ带 �������� �ʰ� �ٷ� ������ 1 ���Ͽ�(i++), ���� ������ �����Ѵ�
	
	gcc.exe ����Ŭ�� �� ����Ǯ��
	C:\gcc\Bin �� �ý��� ȯ�溯���� ��� : ������ cmdâ�� �ٽ� ����ߵǴµ� Path�� ��ϵ� ���� �Ʒ��� ���������� ��θ� �� �Է����� �ʾƵ� ���� ����.
	�Ȱ��� �̸��� ������ ������ �ִٸ� ���� ��ο� �ִ� ������ �����.
	
*/