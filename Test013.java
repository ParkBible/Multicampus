public class Test013{
	public static void main(String[] args){
		int total = 1000000;
		int in = 0;
		for(int i=0; i<total; i++){
			double a = Math.random();
			double b = Math.random();
			double c2 = a*a + b*b;
			if(c2>1.0) {
			} else{
				in++;
			}
		}
		System.out.println( (in*1.0) / total * 4 );
		
	}
}

/*
	Math.random() : 0���� 1 ������ ������ �Ҽ��� �߻���Ų��. �Ҽ��ϱ� double ����.
	for(int i=0; i<10; i++){
			double r = Math.random();
			System.out.println(r);
		}
	
	Math.random()�� ���� ��������� pi�� ��������
	1/4 * pi : 1 = ��ä�� �ȿ� �ִ� �� ���� : ���簢�� �ȿ� �ִ� �� ����
	�� pi = 4 * ��ä�� �ȿ� �ִ� �� ���� / ���簢�� �ȿ� �ִ� �� ����
	c2�� double�̹Ƿ� 1.0�� ���ٰ� �ϸ� �� �������ʱ� ������, 1.0���� ũ�ٰ� ���ǹ��� �����.
	total(���簢�� �ȿ� �ִ� �� ����)�� ���ϰ�, ���� �� ���� ��ä�� �ȿ��� �ִٸ� in ������ �ϳ� ������Ŵ.
	�׷��� total�� in�� �� ������ ����Ͽ� pi�� ����.
*/