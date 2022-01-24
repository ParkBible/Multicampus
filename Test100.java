
class A{
	private int drug = 0;
	protected int vijagum = 1;
	public int budongsan = 2;
	
	void picnic(){
		System.out.println(this.drug);
		System.out.println(this.vijagum);
		System.out.println(this.budongsan);    // ���������ڿ� ������� ���� �� ��� �󸶵��� ���� ����.
	}
}

class B extends A{
	void print(){
		System.out.println(this.drug);    // ������ �ڽĵ� �� �����.
		System.out.println(this.vijagum);    // �ε����̶� ���ڱ��� �����ϴ�.
		System.out.println(this.budongsan);
	}
}

public class Test100{
	public static void main(String[] args){
		private int i = 0;    // ���ú��� �տ��� ���� �� ����.
		
		A t = new A();
		System.out.println(t.budongsan);    // ���Ķ�ġ�� �ε��� ���ϱ� ��������.
		System.out.println(t.drug);    // �ٵ� ������ ������ �ȵȴ�.
		System.out.println(t.vijagum);   // ���ڱ��� �ܺ����� �� ����ߵǴµ� �ڹٿ��� package���䶧���� ������ ���ü��� �ִ�.
										// ���� ��Ű���϶� ���������� �ٸ� ��Ű���� ������ �� ����.
	}
}

/*
	private, protected, public : ��������� ����Լ� �տ� ���� �� �ֱ���.
	Ŭ������ ����� ��������� ��� �Լ��ۿ� ����...
	
	��������� 3������ �з�
	1. �������� ������ ��.(����x, ���x) ������ �������ε� ����(drug)�� ����� ���������� �����Ŵ�. - private
	2. �����ֱ⸸ �� ��(����x, ���o) ������ ���ڱ�(vijagum)�� ���� ����� ��ƶ������� �����ֱ� �ҰŴ�. - protected
	3. �����ϸ鼭 �����ֱ⵵ �� �� (����o, ���o) �ε���(budongsan)�� �����Ǿ� �ְ� �����ֱ⵵ �ҰŴ�. - public
*/